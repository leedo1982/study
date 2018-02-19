
# java 8 - OPTIONAL -


null vs empty 의 차이는 개발자 라면 누구나 알것이다.

그리고 NPE(Null Pointer Exception) ....

가장 많이 디버깅 되는 예외 중 하나일 것이다. 

NPE를 막기 위해

```java
// 객체에 접근하기전 NPE Check
if( anything != null)
    anything.getEverything();
    ....
```
이와 같은 방식으로 많은 확인을 했을 것이다.

정말 불필요한 대화를 하는 듯한 코드가 많이 필요하게 된다.

**이를 해결하기 위해 나온것이 java8의 Optional !!!!(뚜둥) **
java.util.Optional<T>

## What is the Optional?
있을 수도 있고 없을 수도 있는 객체. 일종의 wrapper class 이다.
한마디로, 내가 뭘 주든 받아서 써라~ 넌 option 이야

## What is good?
1. null을 직접 다루지 않는다.
2. 불필요한 대화를 안해도 된다.(NPE check)
3. optional 은 null 일수도 있다는 가능성을 표현한다.

## 객체 생성 3가지 방법
1. Optional.empty()
    - 비어있는 객체, Optional이 미리 생성해놓은 싱글턴 인스턴스
2. Optional.of(value)
    - null 이 아닌 객체를 담다. 따라서 null 인경우 NEP (펑!!!) 발생
3. Optional.ofNullable(value)
    - null 이어도 좋아 ㅠㅏㅏ
    - Optional.ofNullable(value) = Optional.of(value) + Optional.empty() (이렇게 생각해도 됨)


## 객체 접근법
- get() : 비어있지 않을 경우만 접근 가능(비어있으면, NoSuchElementException )
- orElse(T other) : 비어있는 객체에대에서, 처리를 할 수 있다.
- orElseGet(Supplier<? extends T> other) : 비어있는 객체에 대해서, 넘어온 함수형 인자를 통해 객체를 생성후 반환
- orElseThrow(Supplier<? extends T> exceptionSupplier) : 비어있는 객체에 대해서, 넘어온 함수형 인자를 통해 예외를 던진다.

## 이렇게 쓸거면 optional을 사용하지 말자.
```java
Optional<T> op = Optional.of?Nullable(value);
// 객체에 접근하기전 NPE Check
if( op.isPresent())
    anything.getEverything();
    ....
```

Optional도 Stream 클래스가 가지고 있는 map() , flatMap(), filter()와 같은 메소드를 가지고 있다. 

## 끝으로 
java 9에서는 
```java
public void logLogin(String customerId) {
    findCustomer(customerId)
        .ifPresentOrElse(
        this::logLogin,
        () -> logUnknownLogin(customerId)
        );
}

public void logLogin(String customerId) {
	findCustomer(customerId)
		.ifPresent(this::logLogin)
		.ifEmpty(() -> logUnknownLogin(customerId));
}

public Optional<Customer> findCustomer(String customerId) {
	return customers.findInMemory(customerId)
		.ifEmpty(() -> logCustomerNotInMemory(customerId))
		.or(() -> customers.findOnDisk(customerId))
		.ifEmpty(() -> logCustomerNotOnDisk(customerId))
		.or(() -> customers.findRemotely(customerId))
		.ifEmpty(() -> logCustomerNotOnRemote(customerId))
		.ifPresent(ignored -> logFoundCustomer(customerId));
}
```
위와 같이 더 편하게 사용할수 있게 메소드가 추가되었다기 하니

좀 더 가독성 및 유지보수성이 높아질 것 같다.



