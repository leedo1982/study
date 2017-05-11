
String  vs StringBuffer vs StringBuilder
:문자열을 저장하고 관리하는 클래스

1. String vs other
String : immutable(불변함)
한번 생성되면 할당된 메모리 공간이 변하지 안흔다.

+를 사용하는 것은 기존의 문자열에 붙이는 것이 아니라
새로운 String 객체를 만든후 새 String 객체에 연결된 문자열을 저장하고, 그 객체를 참조
따라서 연산이 많은 경우 성능이 안 좋음.
하지만 immutable한 객체는 간단하게 사용가능하고,
동기화에 대한 신경을 쓰지 않아도 되기 때문에(Thread safe) , 내부 데이터를 자유롭게 공유할 수 있다.

other String : mutable(변함,변하기 쉬움)
StringBuffer와 StringBuilder는 문자열 연산등 기존 객체가 공간 부족인 경우,
기존의 버퍼 크기를 느리며 유연하게 동작. 두 클래스의 제공 메서드도 동일합니다.

두 클래스의 차이점은 동기화 여부 이다.
StringBuffer 는 각 메서드 별로 Synchronized Keywird가 존재하며, 멀티 쓰레드 환경에도소 동기화 지원
하지만StringBuilder는 동기화를 보장하지 않습니다.
그렇기 때문에
멀티쓰레드 환경이라면 값 동기화 보정을 위해서 StringBuffer
단일쓰레드 환경이라면 StringBuilder 를 사용하는 것이 좋다.
단일쓰레드 환경에서 StringBuffer를 사용한다고 문제가 되는 것은 아니나, 동기화 처리로 인해 StringBuilde에 비해 성능이 좋지 않다.

그러나 JDK 1.5이후에는  컴파일단계에서 String -> StringBuilder로 컴파일 되도록 변경되었다.
단순 성능비교만 놓고 연산이 많은경우
StringBuilder > StringBuffer >>>> String
