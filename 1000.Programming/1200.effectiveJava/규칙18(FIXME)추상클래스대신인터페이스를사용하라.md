## 규칙18 추상 클래스 대신 인터페이스를 사용하라

자바 언어에는 여러가지 구현을 허용하는 자료형을 만드는 방법이 두가지 포함되어있다.
인터페이스와 추상 클래스가 그것이다.

두 방법의 가장 분명한 차이는, 추상클래스는 구현된 메서드를 포함할 수 있지만 
인터페이스는 아니라는 것이다. 좀 더 중요한 차이는, 추상 클래스가 규정하는 자료형을
구현하기 위해서는 추상클래스를 반드시 계승해야 한다는 것이다.  

이미 있는 클래스를 개죠해서 새로운 인터페이스를 구현하도록 하는 것은 간단하다.

인터페이스는 믹스인을 정의하는데 이상적이다. 믹스인은 클래스가 주자료형이외에 추가로
구현할 수 있는 자료형으로, 어떤 선택적 기능을 제공한다는 사실을 선언하기 위해 쓰인다.  

인터페이스는 비계층적인 자료형 프레임워크를 만들 수 있도록한다. 

예를 들어 가수를 표현하는 인터페이서와 작곡가를 표현한느 인터페이스가 있다
```java 
	public interface Singer{
		AudioClip sing(Song s);
	}

	public interface Songwriter{
		Song compose(boolean hit);	
	}
```
그런데 가수가운데 작곡가인 사람도 있다.

```java
	public interface SingerSongwriter extends Singer, Songwriter{
		AudioClip strum();
		void actSensitive();	
	}

```

인터페이스를 사용하면 포장 클래스 숙어를 통해 안전하면서도 강력한 기능 개선이 가능하다.

인터페이스 안에서 메서드 구현을 둘수 없지만, 그렇다고 프로그래머가 사용할 수 있는 코드를
제공할 방법이 없는 것은 아니다. 추상골격구현클래스를 중요 인터페이스마다 두면, 인터페이스의
장점과 추상 클래스의 장점을 결합할 수 있다.

```java
	// 골격 구현 위에서 만들어진 완전한 List 구현
	static List<Integer> intArrayAsList(final int[] a){
		if(a == null){ throw new NullPointerException(); };
		
		return new AbstractList<Integer>(){
			public Integer get(int i){
				return a[i]; // 자동 객체화	
			}	
			
			@Override public Integer set(int i, Integer val){
				int oldVal = a[i];
				a[i] = val;    // 자동 비객체화
				return oldVal; // 자동 객체화	
			}	
			
			public int size(){
				return a.length;	
			}
		}	
	}

```

요약하자면, 인터페이스는 다양한 구현이 가능한 자료형을 정의하는 일반적으로 가장 좋은
방법이다. public  인터페이스는 극도로 주의해서 설계해야 하며, 실제로 여러 구현을 
만들어 보면서 광범위하게 테스트 해야한다. 
