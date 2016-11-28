## 규칙12 Comparable 구현을 고려하라

compareTo 메서드는 Object 에 선언되어 있지 않다. 사실 이 메서드는 Comparable 인터페이스에 포함된 유일한 메서드이다.
Object 의 equals 메서드와 특성은 비슷하지만, 단순한 동치성 검사 이외에 순서 비교가 가능하며, 좀더 일반적이다.

Comparable 인터페이스를 구현하는 클래스의 객체들은 자연적 순서를 갖게 된다. Comparable 을 구현한 객체들의 배열을
정리하는 것은 아래의 예제처럼 아주 간단하다.
```java
	Arrays.sort(a);

```

아래의 프로그램은 String이 Comparable 을 구현하고 있다는 사실을 이용하여 명령행 인자들을 
알파벳 순서로 정렬하는 동시에 중복을 제거하고 있다.

```java
	public WordList{
		public static void main(String[] args){
			Set<String> s = new TreeSet<String>();
			Collections.addAll(s, args);
			System.out.println(s);
		}	
	}
```

자바 플랫폼 라이브러리에 포함된 거의 모든 값 클래스는 Comparable 인터페이스를 구현한다.
알파벳순서나 값의 크기, 또는 시간적 선후관계처럼 명확한 자연적 순서를 따르는 값 클래스를 구현할 때는 Comparable 인터페이스를
구현 할 것을 반드시 고려해봐야 한다.

```java
	public interface Comparable<T>{
		int compareTo(T t);
	}
```

compareTo 메서드의 일반규약은 equals와 비슷하다.
- 본 메서드는 이객체와 인자로 주어진 객체를 비교한다. 이 객체의 값이 인자로 주어진 값보다 작으면 음수를, 
같으면 0을, 크면 양수를 반환한다. 인자로 전달된 객체의 자료형이 이 객체와 비교 불가능한 자료형인 경우에는
ClassCastException 예외를 던진다.

equals 규갹과 마찬가지로 보기보다 복잡하지 않다. 한 클래스 객체 사이에 자연적 순서가 존재하기만 하면 
어떤 것이든 이 규약을 만족할 것이다. 또한 equals 와는 달리 compareTo 는 서로 다른 클래스에 적용될 필요가 없다.

이제 compareTo 규약의 각 항목을 상세히 살펴보자
1. 객체 참조를 비교하는 방향을 뒤집어도 객체간 대소관계는 그대로 유지되어야 함을 나타난다. 
즉, 만일 첫번째 객체가 두번째 객체 보다 작다면, 두번째 객체는 첫번째 객체보다 큰 객체여야 한다.
2. 첫번째 객체가 두번째 객체보다 크고 두번째 객체가 세번째 객체보다 클 경우 첫번째 객체는 세번째 객체보다
반드시 크야한다는 사실을 표현한다.
3. 세번째 항목은 비교 결과 같다고 판정된 모든 객체 각각을 다른 어떤 객체와 비교할 경우, 그 비교결과는
전부 동일해야 한다는 뜻이다.
