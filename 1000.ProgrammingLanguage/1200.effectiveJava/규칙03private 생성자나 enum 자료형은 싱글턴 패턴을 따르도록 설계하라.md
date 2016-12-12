## 규칙03private 생성자나 enum 자료형은 싱글턴 패턴을 따르도록 설계하라

싱글턴은 객체를 하나만 만들 수 있는 클래스다.  
싱글턴은 보통 유일할 수 밖에 없는 시스템 컴포넌트를 나타낸다.  
그런데 클래스를 싱글턴으로 만들면 클라이언트를 테스트하기가 어려워 질수 있다.  

```
	
	// public final 필드를 이용한 싱글턴
	public class Elvis{
		public static final Elvis INSTANCE = new Elvis();
		private Elvis(){ ... };

		public void leaveTheBuilding(){...}
	}

	// 정적 팩토리를 이용한 싱글턴
	public class Elvis{
		private static final Elvis INSTANCE = new Elvis();
		public static Elvis getInstance(){ return INSTANCE; };

		public void leaveTheBuilding(){...}
	}

```


public 필드를 사용하면 클래스가 싱글턴인지 선언만 보면 알수 있으나 성능이 더 좋을 것이라는 기대는 접는 것이 좋다.  

팩터리 메서드를 사용하는 방법의 한가지 장점은, API를 변경하기 않고도 싱글턴 패턴을 포기할 수 있다는 것이다.   
가령 스레드마다 별도의 객체를 반환하도록 팩터리 메서드를 수정하는 것도 간단하다.  
두번째 장점은 제네릭 타입을 수용하기 쉽다.   
그런데 이런 장점이 필요없는 경우가 많으므로 그럴때는 public 필드를 사용하는 쪽이 더 간단하다.  
 
아직 널리 사용되는 접근법은 아니지만, 원소가 하나뿐인 enum 자료형이야말로 싱글턴을 구현하는 가장 좋은 방법이다.  
