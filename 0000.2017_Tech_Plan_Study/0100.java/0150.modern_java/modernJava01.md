


## 모던 자바
### 모던 자바 (자바8) 못다한 이야기 - 01 왜 배워야 하나요? 뭐가 좋아요?


```java
    /* Java 8 버전 */
    final String result = numbers.stream()
                                 .map(String::valueOf)      // 각 Integer를 String으로 변환
                                 .collect(joining(" : "));  // 1 : 2 : 3 : ... 10 끝!
```

java is first class citizen 

### 모던 자바 (자바8) 못다한 이야기 - 02 Function, The Transformer



