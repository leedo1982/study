```java
// 시작 부분에 아래처럼 현재 시간을 계산하고

long start = System.currentTimeMillis();



// 프로그램 본문


// 끝에 아래와 같이 삽입

long end = System.currentTimeMillis();

System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
```
