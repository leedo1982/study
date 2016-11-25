## 규칙08 equals를 재정의할 때는 일반 규약을 따르라

아래의 조건 가운데 하나라도 만족되면 equals를 재정의 하지 않아도 된다.

- 각각의 객체가 고유하다. : 값(value) 대신 활성개체(active entity)를 나타내는 Thread 같은 클래스
- 클래스에 "논리적 동일성" 검사방법이 있건 없건 상관 없다.
- 상위 클래스에서 재정의한 equals가 하위 클래스에서 사용하기에도 적당하다.  
  예를 들어, 대부분의 Set클래스는 AbstractSet의 equals 메서드를 그래도 사용한다.
- 클래스가 private 또는 package-private로 선언되었고, equals 메서드를 호출할 일이 없다.  
```java
	@Override public Boolean equals(Object o){  
		throw new AssertionError(); // 호출 되면 안되는 메서드를 호출했다는 뜻.	 
  	}  

``` 
equals 메서드를 재정의할 때 준수해야하는 일반규약은 다음과 같다. Object 클래스 명세에서 복사한 것이다.  

equals 메서드는 동치 관계를 구현한다. 다음과 같은 관계를 동치관계라 한다.
- 반사성(reflexive) : null 이 아닌 참조 x가 있을 때, x.equals(x)는 true를 반환한다.  
- 대칭성(symmetric) : null 이 아닌 참조 x와 y가 있을 때, x.equals(y)는 y.equals(x)가 true를 반환한다.  
- 추이성(reansitive): null 이 아닌 참조 x, y, z가 있을때, x.equals(y)가 true이고, y.equals(z)가 true이면, x.equals(z)도 true이다.
- 일관성(consistent): null 이 아닌 참조 x, y가 있을때, equals을 통해 비교되는 정보에 아무 변화가 없다면, x.equals(y) 호출 결과는  호출횟수에 상관없이 항상 같아야한다.
- null 아닌 참조 x에 대해서 x.equals(null)은 항상 false 이다.
  
 
**equals가 따라야 할 규약을 어기면, 그 객체를 만난 다른 개게들이 어떻게 행동할지 예측할 수 없게 된다.**


#####*리스코프 대체원칙 : 어떤 자료형의 중요한 속성은 하위 자료형에도 그대로 유지되어서, 그자료형을 위한 메서드는 하위 자료형에도 잘 동작해야한다.

  
훌륭한 equals 메서드를 구현하기 위해 따라야 할 지침들  

1. == 연산자를 사용하여 equals의 인자가 자기 자신인지 검사하라.
2. instanceof 연산자를 사용하여 인자의 자료형이 정확한지 검사하라.
3. equals의 인자를 정확한 자료형으로 변환하라. 그앞에 instanceof를 사용한 검사코드를 두었으므로, 형변환은 반드시 성공할 것이다.
4. "중요"필드 각각이 인자로 주어진 객체의 해당 필드와 일치하는지 검사한다.
5. equals 메서드 구현을 끝냈다면, 대칭성, 추이성, 일관성의 세 속성이 만족되는지 검토하라.


equals를 구현할 주의사항
- equals를 구현할 때는 hashCode도 재정의하라.
- 너무 머리쓰지 마라.
- equals 메서드의 인자형을 Object에서 다른것으로 바꾸지 마라.

  
  
  
