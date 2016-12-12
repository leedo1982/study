
## 규칙11 clone을 재정의할 때는 신중하라

Cloneable은 어떤 객체가 복제(clone)를 허용한다는 사실을 알리는 데 쓰려고 고안된 믹스인(mixin) 인터페이스다.  
불행이도 당초 목적에는 부합하지 못하고 있다.

일반적으로 인터페이스를 구현한다는 것은 클래스가 무슨 일을 할 수 있는지 클라이언트에게 알리는 것이다.  
그런데 Cloneable의 경우에는 상위 클래스의 protected 멤버가 어떻게 동작할지 규정하는 용도로 쓰이고 있다.

clone 메서드의 일반규약은 느슨한다. java.lang.Object 명세를 보면 다음과 같이 되어있다.
```text
	객체의 복사본을 만들어서 반환한다. "복사"의 정확한 의미는 클래스마다 다르다. 
	일반적으로는 다음의 조건이 충족되어야 한다. 객체 X가 있다고 하자.
	
	x.clone() != x 
	
	위의 조건은 참이어야 한다..
	
	x.clone().getClass() == x.getClass()
	
	위의 조건은 참이 되겠지만, 반드시 그래야 하는 것은 아니다.
	
	x.clone().equals(x)
	
	위의 코드를 실행한 결과도 true가 되겠지만, 반드시 그래야 하는 것은 아니다.  
	객체를 복사하면 보통 같은 클래스의 새로운 객체가 만들어지는데,  내부자료구조까지  
	복사해야 될 수도 있다. 어떤 생성자도 호출되지 않는다.
```

**비-final 클래스에 clone을 재정의할 때는 반드시 super.clone을 호출해 얻은 객체를 반환해야한다.**  
어떤 클래스의 모든 상위 클래스가 이 규칙을 따른다면, super.clone은 최종적으로 Object의 clone 메서드를 호출하게 될것이고,
원하는 클래스의 객체가 만들어 질것이다. 이 메커니즘은 생성자들이 자동으로 연결되는 것과 얼추 비슷하긴 하나 강제적인 사항은 아니라는 차이가 있다.

**실질적으로 Cloneable 인터페이스를 구현하는 클래스는 제대로 동작하는 public clone 메서드를 제공해야한다.**   
해당 클래스의 모든 상위 클래스가 제대로 된 public 또는 protected clone 메서드를 제공하지 않으면 일반적으로 불가능한 일디ㅏ.

**라이브러리가 할 수 있는 일을 클라이언트에게 미루지 말라**

만일 복제할 객체가 변경 가능 객체에 대함 참조 필드를 가지고 있다면, 위에서 본 clone을 그래로 이용하면 끔찍한 결과가 초래된다.
예를 틀어 Stack 클래스의 경우를 보자

```java
	public class Stack{
		private Object[] elements;
		private int size = 0;
		private static final int DEFAULT_INITIAL_CAPACITY = 16;
		
		public Stack(){
			this.elements = new Onject[DEFAULT_INITIAL_CAPACITY];	
		}	
	
		public void push(Object e){
			ensureCapacity();
			elements[size++] = e;
		}	
	
		public Object pop(){
			if(size == 0){ throw new EmptyStackException(); }
				
			Object result = elements[--size];
			elements[size] = null; // 만기 참조 제거
			return result;
		}
	
		// 적어도 한 원소가 들어갈 공간 확보
		private void ensureCapacity(){
			if(elements.length == size){
				elements = Arrays.copyOf(elements, 2 * size + 1);
			}	
		}
	}
```

이 클래스를 복제 가능하도록 하고 싶다고 하자. clone 메서드가 단순히 super.clone()이 반환한 객체를
그대로 반환하도록 구현하면, 그 복사본의 size 필드는 올바른 값을 갖겠지만 elements 필드는 원래 stack
객체와 같은 배열을 참조하게 된다. 그 상태에서 원래 객체나 복사본을 변경하면 다른 객체의 상태가 깨지게 된다.

Stack 클래스의 생성자를 호출할 때는 이런 상황이 벌어지지 않는다. 
**사실상 clone 메서드는 또다른 형태의 생성자다. 원래 객체를 손상시키는 일이 없도록 해야 하고, 복사본의
불변식도 제대로 만족시켜야 한다.**

stack의 clone 메서드가 제대로 동작하도록 하려면 스택의 내부 구조도 복사해야한다.
가장 간단한 방법은 elements 배열에도 clone을 재귀적으로 호출하는 것이다.

```java
	@Override public Stack clone(){
		try{
			Stack result = (Stack)super.clone();
			result.elements = elements.clone();
			return result;	
		}catch(CloneNotSupportedExceptrion e){
			throw new AssertionError();	
		}	

	}
```
위의 해법은 elements 필드가 final로 선언 되어 있으면 동작하지 않는다는 것에 유의하자. clone 안에서 필드에 새로운
값을 할당할 수가 없기 때문이다. **clone의 아키텍처는 변경 가능한 객체를 참조하는 final 필드의 일반적 용법과 
호환되지 않는다.** 

