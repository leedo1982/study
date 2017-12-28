
### java 1.5 (기능적으로 가장 많은 변화가 생김)
1. Generics 
2. annotation
3. auto boxing
4. enum
5. vararg 
6. foreach
7. static imports 도입
7. 스레드 풀
8. Java Generics

### java 1.6
1. 기능에 별 차이 없음 - 보안 성능 강화 주력
2. G1(Garbage First) GC 도입


### java 1.7
1. Switch에서 String
2. try-resource
3. generics에서 타입추론
4. 숫자에서 underscore사용

### java 1.8
1. Lambda expressions
 - 람다 표현식은 Anonymous Function라고 할 수 있다
 - 람다를 이용하여 코드를 간결하게 할 수 있다

2. Method Reference ( -> )
 - 특정 람다 표현식을 축약한 것으로 볼 수 있다
 - 메서드 정의를 활용하여 람다처럼 사용 가능하다

3. Stream
 - 간결하게 컬렉션의 데이터를 처리하는 기능

4. Parallel Stream
 - 위 Stream을 병렬로 처리가능하도록 하는 기능
 - 여러 쓰레드에서 처리할 수 있도록 분할한 Stream 이다

5. Default Method
 - 인터페이스의 구현체를 인터페이스 자체에서 기본으로 제공 가능하다
 - 구현 클래스에서 인터페이스를 구현하지 않아도 된다

6. Optional
 - 값을 Optional<T>로 캡슐화하여 NullPointerException을 막는다
 - 값이 존재한다면 Optional 클래스는 값을 감싼다
 - 값이 없다면 Optional.empty메서드로 Optional을 리턴한다


7. CompletaleFuture
 - Future의 기능을 확장시켜준다
   - 두 개의 비동기 계산 결과를 하나로 합친다
     - 각 계산 결과는 독립적이거나 종속적일 수 있다
   - Future 집합이 실행하는 모든 태스크의 완료를 기다린다
   - Future 집합에서 가장 빨리 완료되는 태스크를 기다렸다가 결과를 얻는다
   - Future가 완료되면 추가 작업을 수행 할 수 있다

8. New date / time APIs
 - Joda-Time의 많은 기능을 java.time 패키지로 추가했다
   -LocalDate, LocalTime, Instant, Duration, Period 


