
# java 8 LocalDate
- java 8에 날짜 관련 패키지가 추가되었다.
- 실제 사용해본결과 Date보다 직관적이고 사용이 용이하다.

간단히 알아보고 정리하자.

1. LocalTime : 시간정보만 필요할때
2. LocalDate : 날짜 정보만 필요할때
3. LocalDateTime ( = LocalDate  + LocalTime : 재미있다..ㅋㅋㅋ)

## 객체 생성

```java
// 현재 날짜
LocalDate nowDate = LocalDate.now();
// 특정날짜
LocalDate spotDate = LocalDate.of(int 년, int 월, int 일);

// 현재 시간 
LocalTime nowTime = LocalTime.now();
// 특정 시간
LocalTime spotTime = LocalTime.of(int 시, int 분, int 초, int 나노초);

// 현재 날짜 시간
LocalDateTime nowDateTime = LocalDateTime.now();
// 특정 시간
LocalDateTime spotDateTime = LocalTime.of(LocalDate, LocalTime);

## 맺으며
실제로 사용해보니 직관적이고 쉬워서 자주 사용할꺼 같다.

