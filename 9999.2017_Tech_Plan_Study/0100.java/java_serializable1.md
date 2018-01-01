
## 자비 직렬화
출처 [우아한형제들 기술블로그](http://woowabros.github.io/experience/2017/10/17/java-serialize.html)


### 직렬화란?!
- 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바시스템에서도 사용할 수 있도록
바이트 형태로 데이터를 변화나는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술을
아울려 이야기한다.
- 시스템적으로 JVM의 메모리에 상주되어 있는 객체 데이터를 바이트 형태로 변환하는 기술과
질렬화된 바이트 형태의 데이터를 객챌로 변환해서 JVM에 상주시키는 형태를 아울로 이야기한다.

### 어떻게 사용할 수 있나?!
#### 1. 직렬화 조건
자바 기본타입과 java.io.Serializable 인터페이스를 상속받는 객체

```java 
/**
    * 직렬 화할 회원 클래스
    */
    public class Member implements Serializable {
        private String name;
        private String email;
        private int age;
    
        public Member(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }
    
        // Getter 생략
    
        @Override
        public String toString() {
            return String.format("Member{name='%s', email='%s', age='%s'}", name, email, age);
        }
    }
```


#### 2. 직렬화 방법
java.io.ObjectOutputStream 객체를 이용

```java
    Member member = new Member("김배민", "deliverykim@baemin.com", 25);
    byte[] serializedMember;
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(member);
            // serializedMember -> 직렬화된 member 객체 
            serializedMember = baos.toByteArray();
        }
    }
    // 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
    System.out.println(Base64.getEncoder().encodeToString(serializedMember));
```

#### 3. 역직렬화 조건
* 직렬화 대상이 된 객체의 클래스가 클래스패스에 존재해야 하며 import 되어 있어야 합니다.
    * 중요한 점은 직렬화와 역질렬화를 진행하는 시스템이 서로 다룰 수 있다는 것을 반드시 고려
* 자바 직렬화 대상 객체는 동일한 serialVersionUID를 가지고 있어야 한다. 
위의 member 클래스에는 serialVersionUID가 없는데, 이는 필수가 아니라 빼둔것이다. 추후 설명예정


#### 4. 직렬화 방법
```java
    // 직렬화 예제에서 생성된 base64 데이터 
    String base64Member = "...생략";
    byte[] serializedMember = Base64.getDecoder().decode(base64Member);
    try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            // 역직렬화된 Member 객체를 읽어온다.
            Object objectMember = ois.readObject();
            Member member = (Member) objectMember;
            System.out.println(member);
        }
    }
```




