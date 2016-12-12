## MYSQL - SQL 01  

mysql 기반 sql 문 기본 명령어 정리


```

	1. 사용자 생성
	CREATE USER 'sampadm'@'localhost' IDENTIFIED BY 'secret';

	2. 권한 부여
	GRANT ALL ON sampdb.* TO 'sampadm'@'localhost';

	3. 현재 날짜와 시간 요청
	SELECT NOW();

	4. 현재 날짜, mysql 사용자, mysql 버전
	SELECT NOW(), USER(), VERSION();

	5. 데이터베이스 생성
	CREATE DATABASE sampdb;

	6. 데이터베이스 선택
	USE sampdb;

	7. 현재 데이터베이스 확인
	SELECT DATABASE();

	8. 원격 호스트에 동작하는  mySql 서버에 연결하고 자하면, 커맨드라인데 호스트 이름을 넣오야 한다. 
	% mysql -h cobra.snake.net -p -u sampadm sampdb

	9. 테이블 생성
	CREATE TABLE member
	(
      member_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
      PRIMARY KEY (member_id),
      last_name VARCHAR(20) NOT NULL,
      first_name VARCHAR(20) NOT NULL,
      suffix VARCHAR(5) NULL,
      expiration DATE NULL,
      email VARCHAR(100) NULL,
      street VARCHAR(50) NULL,
      city VARCHAR(50) NULL,
      state VARCHAR(2) NULL,
      zip VARCHAR(10) NULL,
      phone VARCHAR(20) NULL,
      interests VARCHAR(255) NULL
	);

	10. DESCRIBE 확인방법
	DESCRIBE president;
	DESC president;
	EXPLAIN president;
	SHOW COLUMNS FROM president;
	SHOW FIELDS FROM president;
    
	11. 특정한 컬럼들로 출력을 제한할 경우
	SHOW COLUMNS FROM member LIKE '%name';

	12. 현재의 데이터베이스 안의 테이블 나열
	SHOW TABLES;

	13. 연결된 서버가 관리하는 데이터베이스 나열
	SHOW DATABASES;

	14. INNER JOIN EXAMPLE
	SHOW DATABASES;
	WHERE grade_event.date = '2008-09-23';

	15. DOUBLE INNER JOIN EXAMPLE
	SELECT student.name, grade_event.date, score.score, grade_event.category
	FROM grade_event INNER JOIN score INNER JOIN student
	ON grade_event.event_id = score.event_id
	AND score.student_id = student.student_id
	WHERE grade_event.date = '2008-09-23';

	16. CREATE TABLE ENUM EXAMPLE : ENUM은 어떤 칼럼이 취할수 있는 제한된 세트의 값들을 표시
	CREATE TABLE student
	(
	name VARCHAR(20) NOT NULL,
	sex ENUM ('F','M') NOT NULL,
	student_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (student_id)
	) ENGINE=InnoDB
	=> ENGINE=InnoDB : MySQL이 테이블을 생성하기 위해 사용되어야 하는 저장 엔진의 이름 

	17. FOREIGN KEY EXAMPLE
	CREATE TABLE score
	(
	student_id INT UNSIGNED NOT NULL,
	event_id INT UNSIGNED NOT NULL,
	score INT NOT NULL,
	PRIMARY KEY (event_id, student_id),
	INDEX (student_id),
	FOREIGN KEY (event_id) REFERENCES grade_event (event_id),
	FOREIGN KEY (student_id) REFERENCES student (student_id)
	) ENGINE = InnoDB;

	18. PRIMARY KEY 2 COLUMN EXAMPLE
	CREATE TABLE absence
	(
	student_id INT UNSIGNED NOT NULL,
	date DATE NOT NULL,
	PRIMARY KEY (student_id, date),
	PRIMARY KEY (student_id) REFERENCE student (student_id)
	) ENGINE = InnoDB;

	19. INSERT SQL
	INSERT INTO student VALUES('Kyle','M',NULL);
	INSERT INTO student VALUES('Avery','F',NULL),('Nathan','M',NULL); 
	-컬럼 지정
	INSERT INTO member (last_name,first_name) VALUES('Stein','Waldo');
	-컬럼에 값 지정
	INSERT INTO member SET last_name='Stein',first_name='Waldo'


	20. SELECT EXAMPLE : COLUMN은 대소문자 구별 않음.
	SELECT birth FROM president WHERE last_name = 'Eisenhower';

	21. ORDER BY EXAMPLE
	SELECT last_name, first_name FROM president
	ORDER BY last_name;

	22. LIMIT : 쿼리 결과 제한
		22-1 : (생일이 빠른 5명)
		SELECT last_name, first_name, birth FROM president
       ORDER BY birth LIMIT 5;

       22-2 : 가장 최근에 태어난 5명 검색
       SELECT last_name, first_name, birth FROM president
       ORDER BY birth DESC LIMIT 5;

       22-3 : 위와 동일하지만, 처음 10개의 행을 건너뛰고 5개의 행을 리턴
       SELECT last_name, first_name, birth FROM president
       ORDER BY birth DESC LIMIT 10, 5;
          
       22-4 : 테이블에서 임의적으로 행들을 선택하려면...
       SELECT last_name, first_name FROM president
       ORDER BY RAND() LIMIT 1;

	23. CONCAT & ALIAS : 문자열 합치기
	SELECT CONCAT(first_name,' ',last_name) AS 'President Name',
	CONCAT(city,', ',state) AS 'Place of Birth'
	FROM president;

	24. 날짜 관련 : 기본적으로 명심할 것은 MySql은 항상 연도가 먼저 나오도록 날짜를 표현 
		24-1 : 날짜 찾기
		SELECT * FROM event WHERE date = '2008-10-01';
		24-2 : 날짜 BETWEEN
		SELECT last_name, first_name, death
		FROM president
		WHERE death >= '1970-01-01' AND death < '1980-01-01';
		24-3 : YEAR(), MONTH(), 또는 DAYOFMONTH() 
		SELECT last_name, first_name, birth
		FROM president WHERE MONTH(birth) = 3;
		24-4 : 날짜 사이의 계산 TIMESTAMPDIFF()
		SELECT last_name, first_name, birth, death,
		TIMESTAMPDIFF(YEAR, birth, death) AS age
		FROM president WHERE death IS NOT NULL
		ORDER BY age DESC LIMIT 5;
		24-5 : 60일 이내에 자격 갱신을 해야하는 회원을 찾는 쿼리
		SELECT last_name, first_name, expiration FROM member
		WHERE (TO_DAYS(expiration) - TO_DAYS(CURDATE())) < 60;		
		OR
		SELECT last_name, first_name, expiration FROM member
		WHERE TIMESTAMPDIFF(DAY, CURDATE(), expiration) < 60;

	25 패턴 찾기 : 특정 문자가 포함되는  column 찾기(W나 w로 시작하는 column을 대응)
	SELECT last_name, first_name FROM president
	WHERE last_name LIKE 'W%';

	26 사용자 정의 변수들을 설정하고 사용하기
	1) SELECT @birth := birth FROM president
		WHERE last_name = 'Jackson' AND first_name = 'Andrew';
	2) SELECT last_name, first_name, birth FROM president
		WHERE birth < @birth ORDER BY birth;
	3) 또한 set 문을 사용하여 값을 대입할 수 있다.
		mysql> SET @today = CURDATE();
		mysql> SET @one_week_ago := DATE_SUB(@today(), INTERVAL 7 DAY);
		mysql> SELECT @today(), @one_week_ago;

	27 중복제거 DISTINCT
	SELECT DISTINCT state FROM president ORDER BY state;	

	28 GROUP BY 
	SELECT student.student_id, student.name,
	COUNT(absence.date) AS absences
	FROM student INNER JOIN absence
	ON student.student_id = absence.student_id
	GROUP BY student.student_id;
      +------------+-------+----------+
      | student_id | name | absences |
      +------------+-------+----------+
      | 3 | Kyle | 1 |
      | 5 | Abby | 1 |
      | 10 | Peter | 2 |
      | 17 | Will | 1 |
      | 20 | Avery | 1 |
      +------------+-------+----------+

	29 기존의 행 삭제 
	DELETE FROM tbl_name
	WHERE which rows to delete;
	
	30 기존의 행 갱신
	UPDATE member
	SET email='jeromey@aol.com', street='123 Elm St',
	city='Anytown', state='NY', zip='01003'
	WHERE last_name='York' AND first_name='Jerome';	 


```
