

## Resuful Design



### Rest API 중심규칙

#### URI는 정보의 자원을 표현해야 한다.(리소스명은 동사보다는 명사를 사용)
```
//  옳지 않은 경우
GET /members/delete/1
```
delete  와 같은 행위에 대한표현이 들어가서는 안된다.

#### 자원에 대한 행위는 HTTP Method(GET, PUT, POST, DELETE 등)로 표현
```
DELETE /members/delete/1
```

회원정보를 가져오는 URI
 
```
GET /members/show/1  (x)
GET /members/1       (o)
```

| METHDO | RULE |
|---|---|
|POST | 리소스생성|
|GET | 리소스 조회|
|PUT | 리소스 수정|
|DELETE | 리소스 삭제|


### URI 설계시 주의할 점

#### 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용
```
    http://restapi.example.com/houses/apartments
    http://restapi.example.com/animals/mammals/whales
```

#### URI 마지막 문자로 슬래스(/)를 포함하지 않는다.
```
    http://restapi.example.com/houses/apartments/ (X)
    http://restapi.example.com/houses/apartments  (0)
```

#### 하이픈(-)은 URI 가독성을 높이는데 사용


#### 밑줄(_)은 URI에 사용하지 않는다.

#### URI 경로에는 소문자가 적합하다. 

#### 파일 확장자는 URI에 포함시키지 않는다.
```
    http://restapi.example.com/members/soccer/345/photo.jpg (X)
```

### 리소스 간의 관계를 표현하는 방법
```
    /리소스명/리소스 ID/관계가 있는 다른 리소스명
    ex)    GET : /users/{userid}/devices (일반적으로 소유 ‘has’의 관계를 표현할 때)
```

### 자원을 표현하는 Colllection과 Document
Collection과 Document에 대해 알면 URI 설계가 한 층 더 쉬워집니다. 
DOCUMENT는 단순히 문서로 이해해도 되고, 한 객체라고 이해하셔도 될 것 같습니다. 
컬렉션은 문서들의 집합, 객체들의 집합이라고 생각하시면 이해하시는데 좀더 편하실 것 같습니다. 
컬렉션과 도큐먼트는 모두 리소스라고 표현할 수 있으며 URI에 표현됩니다. 예를 살펴보도록 하겠습니다.

```
    http:// restapi.example.com/sports/soccer
```
위 URI를 보시면 sports라는 컬렉션과 soccer라는 도큐먼트로 표현되고 있다고 생각하면 됩니다.
좀 더 예를 들어보자면

```
    http:// restapi.example.com/sports/soccer/players/13
```
sports, players 컬렉션과 soccer, 13(13번인 선수)를 의미하는 도큐먼트로 URI가 이루어지게 됩니다. 
여기서 중요한 점은 컬렉션은 복수로 사용하고 있다는 점입니다. 
좀 더 직관적인 REST API를 위해서는 컬렉션과 도큐먼트를 사용할 때 단수 복수도 지켜준다면 좀 더 이해하기 쉬운 URI를 설계할 수 있습니다.