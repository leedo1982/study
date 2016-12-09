

#규칙46 for 문보다는 for-each 문을 사용하라.

릴리스 1.5 부터 토입돤 for-each 문은 성가신 코드를 제거하고 반복자나 첨자변수를 완전히 제거해서
오류 가능성을 없앤다. 그 결과, 컬렉션이나 배열을 순회할 때 아래의 숙어대로 코딩할 수 있게 되었다.

```java
	// 컬렉션이나 배열을 순회할 때는 이 숙어를 따르자.
	for(Element e : elements){
		doSomething(e);	
	}
```
for-each 문의 성능은 for 문과 같다. 배열에도 마찬가지다. 어떤 상황에서는 일반 for 문보다 나은 
성능을 보이기도 한다.

for-each 문의 장점은 여러 컬렉선에 중첩되는 순환문을 만들어야 할 때 더 빛난다.
두개 컬렉선에 대한 순환문을 줍첩시킬때 흔히 저지르는 실수의 사례를 아래에 보였다.

```java
	// 버그가 어디 있는지 알겠는가?!
	enum Suit { CLUB, DIAMOND, HEART, SPADE }
	enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
	
	...
	
	Collection<Suit> suits = Arrays.asList(Suit.values());
	Collection<Rank> ranks = Arrays.asList(Rank.values());
	
	List<Card> deck = new ArrayList<Card>();
	for(Iterator<Suit> i  = suits.iterator(); i.hasNext(); )
		for(Iterator<Rank> j  = ranks.iterator(); j.hasNext(); )
			deck.add(new Card(i.next(), j.next()));

``` 

문제는, 바깥쪽 순환문에서 사용하는 컬렉선 반복자의 next 메서드가 너무 많이 호출된다는 것이다.
바깥쪽 순환문 안에서 카드 종류별로 한번만 호출되었어야 했는데(4회), 안쪽 순환문에서 호출되다
보니 카드 숫자별로 한번씩 호출되는 것이다(13회).

```java
	// 같은 버그, 다른 증상
	enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX }
	...
	Collection<Face> faces = Arrays.asList(Face.values());
	
	for(Iterator<Face> i  = faces.iterator(); i.hasNext(); )
		for(Iterator<Face> j  = faces.iterator(); j.hasNext(); )
			System.out.println(i.next()+" "+ j.next()));

```

이 프로그램은 예외를 발생시기지는 않으나 여섯개의 짝패만 출력한다. 원래는 36개의 조합을 출력했어야
했다. 이 버그를 수정하려면 바깥쪽 순환문의 유효범위 안에 새로운 변수 하나를 추가해야한다.
```java
	// 고치긴 했으나 코드가 보기 싫다.- 이보다는 잘할수 있다.!
	for(Iterator<Suit> i  = suits.iterator(); i.hasNext(); )
		Suit suit = i.next();
		for(Iterator<Rank> j  = ranks.iterator(); j.hasNext(); )
			deck.add(new Card(suit, j.next()));
```

for-each 문으로는 컬렉션과 배열뿐 아니라 Iterable 인터페이스를 구현하는 어떤 객체도 순회할 수 있다.

Iterable 인터페이스는 구현하기 어렵지 않다. 원소들의 그룹을 나타내는 자료형을 작성할 때는, Collection
은 구현하지 않더라도 , Iterable은 구현하도록하자.

요약하자면, For-each 문은 전통적인 for 문에 비해 명료하고 버그 발생 가능성도 적으며, 성능도 for문에
뒤지지 않는다. 그러니 가능하다면 항상 사용해야 한다 그러나 불행이도 아래의 세 경우에 대해서는
for-each 문을 적용할 수 없다.

1. 필터링(filtering) - 컬렉션을 순회하다가 특정한 원소를 삭제할 필요가 있다면, 반복자를 명시적으로 
사용해야한다. 반복자의 remove 메서드를 호출해야 하기 때문이다.
2. 변환(transforming) - 리스트나 배열을 순회하다가 그원소 가운데 일부 또는 전부의 값을 변경해야 한다면,
원소의 값을 수정하기 위해서 리스트 반복자나 배열 첨자가 필요하다.
3. 병렬순회(parallel iteration) - 여러 컬렉션을 병렬적으로 순회해야 하고, 모든 반복자나 첨자 변수가 
발맞춰 나아가도록 구현해야 한다면 반복자나 첨자 변수를 명시적으로 제어할 필요가 있을 것이다.


