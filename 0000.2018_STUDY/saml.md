
# SAML

무엇인가?

SAML(Security Assertion Markup Language, 샘엘[1])은 인증 정보 제공자(identity provider)와 서비스 제공자(service provider) 간의 인증 및 인가 데이터를 교환하기 위한 XML 기반의 개방형 표준 데이터 포맷이다.
[출처: 위키](https://ko.wikipedia.org/wiki/SAML)


장점, 단점

어디에서 사용하고 있나



구현방법



인증과련
JWT, OpenAPI, OpenID, OAuth

## JWT
### 정의
JSON Web Token은 웹표준(RFC 7519)으로 두개체에서 JSON 객체를 사용하여 가볍고 자가수용적인 방식으로 정보를 안전성 있게 전달해줍니다.

:ㅈ
### 생김새
header.payload.signature
세부분으로 구분됨
1. Header 은 두가지정보를 지니고 있다.
- typ : 토큰의 타입(JWT)
- alg : 해싱 알로기즘을 지정(보통 HMAC SHA256 혹은 RSA 사용)
2. Payload 는 토큰에 담을 정보가 들어있다. 정보의 한 조각을 클레임(claim)이라고 부르ㅡ며, name/value의 쌍으로 이루어져 있다.
클레임은 세종류로 분류됨
2.1 등록된(registered) 클레임
 :서비스에서 필요한것이 아닌, 토큰에 대한 정보를 담기위하여 이름이 정해진 클래임
2.2 공걔(public)클레임
 : 충돌이 방지된 이름을 가지고 있어야하며, 충돌방지를 위해 클레임 이름을 URI형식으로짓는다.
2.3 비공개(private) 클레임
:양측간 협읳에 사용되는 클레임 이름들

3.signature
헤더의 인코딩값과 정보의 인코딩값을 합친후 주어진 비밀키로 해쉬하여 생성합니다.

SAML과 OAuth 의 차이
Web Service 보안의 3가지 영역
1. 데이터 무결성  ==> 전자서명, 데이터 암호화, SSL등 암호화 기술
2. 데이터 기밀성  ==> 전자서명, 데이터 암호화, SSL등 암호화 기술
3. AAA(인증/인가/감사)  ==> SAML , OAuth

SAML은 멀티 도메인 간의 SSO 성격이 강핟.
:ㅈㅂ
