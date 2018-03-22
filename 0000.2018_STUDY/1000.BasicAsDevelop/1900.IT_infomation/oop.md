
# Object Oriented Programming
> 객체지향 프로그래밍

너무 큰 범위지만 아는 선에서

절차적 프로그래밍 -> 구조적 프로그래밍 -> 객체지향 프로그래밍의 발전


> 구조적 프로그래밍은 프로그램을 작성할 때, 알고리즘으 세분화해 계층적인 구조가 되도록 설계하는 프로그래밍 방법으로, 프로그램은 세개의 기본구조(순차, 선택, 반복)만으로 구성된다.

객체지향을 패러다임은 프로그래밍 주체자가 
컴퓨터 중심에서 사람으로의 이동 했다고 볼수 있다.
현실 세계의 사물들을 객체라고 보고 그 객체를 개발하고자하는 특징을 뽑아
개발하는 것이다.

객체지향은 모듈화 시켜서 사용하므로 재사용성이 높다.

객체지향 프로그래밍의 치명적인 단점을 함수형 프로그래밍을 통해 알수 있다.
바로 객체가 상태를 갖는다는 것이다.
변수가 존재하고 이변수를 통해 예측할 수 없는 상태를 갖게 되어 애플리케이션 내부에서 버그를 발생시킨다.
그래서 요즘 함수형 프로그래밍이 주목받는다.

## 객체지향 원칙 (SOLID)
1. SRP(single responsibility p) : 단일 책임 원칙
 -> 클래스는 단하나의 책임을 가지며, 변경이유도 하나여야한다.
2. OCP(Open-Closed P) : 개방 폐쇄원칙
 -> 확장에는 열려있고, 변경에는 닫여있어야 한다.
3. LSP(Likov Subustitution P) : 리스코프 치환원칙
 -> 상위타입의 객체를 하위 타입의 객체로 치환해도 상위타입을 사용하는 프로그램은 정상적으로 동작해야 한다.
4. ISP(Interface Segregation P) : 인터페이스 분리 원칙
 -> 인터페이스는 그 인터페이스를 사용하는 클라이언트를 기준으로 분리해야한다.
5. DIP(Dependency Inversion P) : 의존 역전 원칙
 -> 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안된다. 

 
