
# 그런 REST API 괜찮은가?!


## REST
REpresentational State Transfer

REST : 컴퓨터 시스템간의 상호 운영성을 제공하는 한가지 방법



##  팀 버너스리의 WEB
어떻게 인터넷에서 정보를 공유할 것인가?!
표현형식:HTML
식별자 : URI
전송방법 : HTTP

## 로이 필딩이....
http를 정립하고 등등등....
How do I improve HTTP without breaking the web?
ask: HTTP Object Model
이것이 4년후 REST(1998)라고 발표
2000년 논문으로 발표

XML-RPC (19982): 원격으로 다른 시스템의 메소드를 호출할수 있는  ->SOAP로 발전

2000년 Salesforce API(2000.2)에 공개 : 최초

## SOAP vs REST 비교 : 사실 같은일은하지만....
SOAP : 복잡하다, 규칙 많다, 어렵다.
REST : 단순하다, 규칙 적다, 쉽다.

2006년 AWS가 자사 API가 자사 API의사용량의 85%가 REST임을 밝힘
2010년 Salesforce.com, REST API 추가

REST 의 승리

그런데...ㅠㅠ
CMIS(2008): REST 바인딩지원
            But 로이필딩은  "NO REST in CMIS" 라고 얘기함


## Microsoft REST API Guidelines(2016)
 uri는 https://{serveiceRoot}/{collection}/{id} 형식이여야 한다.
 GET, PUT, DELETE, POST, HEAD, PATCH, OPTI?ONS를 지원해야한다.
 API 버저닝은 Major.minor로 하고 uri에 버전 정보를 포함시킨다.
 등등등...and so on....

로이 필딩이 이것도 RESTAPI가 아니고 HTTP API라고 얘기함...

로이필딩은 블로그에
" REST APIs must be hypertext-driven"
" REST API를 위한 최고의 버저닝 전략은 버저닝을 안하는 것"

뭐가 문제인 걸까....
REST API
:REST 아키텍쳐 스타일을 따르는 API


그럼 REST ?
로이 필딩의 박사학위 논문에
REST : 분산 하이퍼미디어 시스템을 위한 아키텍처 스타일
아키텍쳐 스타일 : 제약조건의 집합
REST 를 구성하는 스타일
1. clent-serve
2. stateless
3. cache
4. uniform interface
5. layered system
6. code-on-demand(optional) : javascript


4. uniform interface 제약조건
- identification of resources
- manipulation of resources through representations
- self-descriptive messages : 메세지가 스스로 설명해
- hypermedia as the engine of application state(HATEOAS)

    3,4번째는 거의 지키지 못하고 있음...


```
    ex.1
    GET  / HTTP/1.1
    : 목적지가 없다....


    ex.2
    HTTP/1.1 200 OK

   [ { "op" : "remove", "path":"a/b/c/"}]   

       :response가 어떤 의미인지 파악 못함....
       content-type가 붙더라도 op, path가 어떤의미인지 파악못하면,
       여전히 REST에 만족하지 못함...

```


HATEOAS : 예플리케이션의 상태는 Hyperlink를 이용해 전이되어야한다.








