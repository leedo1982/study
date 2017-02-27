

## HTTP Status Codes
restful API 를 사용하면서
궁금한 Http Status Codes 에  관하여...

프론트엔드 / 백엔드 / 앱 개발자들이 공통으로 알고 있으면
작업간 수월할 것이라 생각하여 작성함.

cf. 가장 자주사용하는 위주로 작성

| 대분류 | code  | message |   한글 설명	|
| --- | --- | --- | --- |
| 1XX |  |  Informational | | 
| 2XX |  |  Success |  |
| | 200 | ok  | 클라이언트의 요청을 정상적으로 수행함(GET, PUT를 통한 리소스 생성시) |
| | 201 | Created | 클라이언트가 어떠한 리소스 생성을 요청, 해당 리소스가 성공적으로 생성됨(POST를 통한 리소스 생성 작업 시)|
| |204 | No Content | 서버는 요청을 이행했지만 entity-body 를 반환할필요가없으며, 업데이트된 메타정보를 반환할 수 있다.(DELETE를 통한 리소스 생성 작업시) |
| 3XX | |  Redirection |  |
| |301 | Moved Permanently  | 클라이언트가 요청한 리소스에 대한 URI가 변경 되었을 때 사용하는 응답 코드 (응답 시 Location header에 변경된 URI를 적어 줘야 합니다.)|
| |304 |  Not Modifued | 클라이언트가 조건부 GET 요청을 수행하고 액세스 할 수있으나 문서가 변경되지 않은경우 |
| 4XX | |  Client Error |  |
| |400 | Bad Request   | 클라이언트의 요청이 부적절 할 경우 사용하는 응답 코드|
| |401 | Unauthorized  | 클라이언트가 인증되지 않은 상태에서 보호된 리소스를 요청했을 때 사용하는 응답 코드 (로그인 하지 않은 유저가 로그인 했을 때, 요청 가능한 리소스를 요청했을 때)|
| |403 | Forbidden  | 유저 인증상태와 관계 없이 응답하고 싶지 않은 리소스를 클라이언트가 요청했을 때 사용하는 응답 코드  (403 보다는 400이나 404를 사용할 것을 권고. 403 자체가 리소스가 존재한다는 뜻이기 때문에)|
| |404 | Not Found | 서버가Request-URI와 일치하는 것을 아무것도 발견되지 않았습니다. 조건이 일시적 또는 영구적인지 확인할 수없습니다.  |
| |405 | Method Not Allowed   | 클라이언트가 요청한 리소스에서는 사용 불가능한 Method를 이용했을 경우 사용하는 응답 코드|
| 5XX | |  Seerver Error |  |
| | 500 | Internal Server Error   | 서버에 문제가 있을 경우 사용하는 응답 코드| 

```
참조: http://www.restapitutorial.com/httpstatuscodes.html
```
