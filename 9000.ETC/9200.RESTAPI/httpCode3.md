REST의 representation이란 무엇인가

작성일자 2017년 4월 3일카테고리 HTTP
사실 서버가 보내준 것은 리소스가 아니다.
다음과 같은 HTTP GET 요청을 서버에 보내서

GET https://example.org/greeting
Host: example.org
Accept: text/plain, text/html; q=0.9 *; q=0.1
Accept-Language: en, ko; q=0.9, *; q=0.1

“hello”라는 메시지를 응답으로 받았다고 해 보자.

HTTP/1.1 200 OK
Content-Length: 6
Date: Sun, 19 Mar 2017 10:20:47 GMT
Last-Modified: Sun, 19 Mar 2017 08:00:00 GMT
Content-Type: text/plain
Content-Language: en

hello
이러한 상황을, https://example.org/greeting 라는 uri를 요청해서 “hello”라는 리소스를 응답으로 받았다고 표현하는 경우를 흔히 보았을 것이다. 그런데 그건 엄밀히 말해 약간 틀린 표현이다. 왜냐하면 “hello”는 리소스가 아니라 representation data이기 때문이다.

HTTP에서의 representation
GET 메서드의 정의는 다음과 같다.

The GET method requests transfer of a current selected representation
for the target resource.
즉, target resource에 대한 현재의 선택된 representation 하나를 반환한다.

위 정의에서 “target resource”란 https://example.org/greeting 라는 uri가 가리키는 리소스이다. 그렇다면 리소스란 무엇인가? HTTP 요청의 대상이다. HTTP는 리소스의 개념을 제한하지 않으며 무엇이든 될 수 있다. 여기서는 “hello” 라는 텍스트 자체가 리소스가 아니라, “환영의 의미를 담은 문서”가 리소스가 된다고 볼 수 있을 것이다.

그럼 “현재의 선택된 representation”이란 무엇인가? 단어 하나 하나를 차근차근 따져보도록 하자.

일단 “representation”은 무엇인가? 어떤 리소스의 특정 시점의 상태를 반영하고 있는 정보이다. 하나의 representation은 representation data와 representation metadata로 구성된다. 위의 예에서는 “hello”가 representation data이고, “Content-Type: text/plain”과 “Content-Language: en”이 representation metadata이다. (HTTP 헤더들 중 representation metadata에 해당하는 것이 있고 그렇지 않은 것이 있다.)

“현재”란 무엇인가? 이것은 말 그대로 해석하면 될 것이다. 만약 https://example.org/greeting 가 가리키는 리소스의 representation이 “hi”에서 “hello”로 수정되었다면 “현재” representation은 “hi”가 아닌 “hello”가 될 것이다.

“선택된”이라고 함은 무슨 뜻인가? 이는 하나의 리소스의 현재 representation이 하나 이상이 될 수 있으며, 그 중 하나가 선택되었음을 의미한다. 즉 “greeting” 리소스의 현재 representation은, 영어 사용자를 위한 “hello”, 한국어 사용자를 위한 “안녕하세요”, HTML 문서를 원하는 클라이언트를 위한 “<html><body>hello</body></html>”등 여러가지가 될 수 있는데, 이들 중 하나가 선택되었다는 의미이다. metadata를 포함하여 representation들의 예를 들어보자.

영어 사용자를 위한 representation:

Content-Type: text/plain
Content-Language: en

hello
한국어 사용자를 위한 representation:

Content-Type: text/plain
Content-Language: ko

안녕하세요
HTML을 선호하는 영어 사용자를 위한 representation:

Content-Type: text/html; charset=UTF-8
Content-Language: en

<html><body>hello</body></html>
HTML을 선호하는 한국어 사용자를 위한 representation:

Content-Type: text/html; charset=UTF-8
Content-Language: ko

<html><body>안녕하세요</body></html>
그렇다면 이들 중 하나를 “선택”하는 것은 누가 어떻게 하는가? 클라이언트와 서버간의 내용 협상(Content negotiation)을 통해 선택하며, 선택의 주체는 협상 방법에 따라 다르다. 사전 협상(proactive negotiation)의 경우 서버가 선택한다. 클라이언트가 GET 요청에 “Accept-Language: ko” 헤더를 포함시켜 한국어를 선호함을 밝혔다면, 서버는 가장 적절한 representation인 “안녕하세요”로 응답할 것이며, 만약 여기에 “Accept: text/html; charset=UTF-8” 헤더도 포함시켜서 한국어로 되어있고 UTF-8로 인코딩된 HTML 문서를 선호한다고 밝혔다면 “<html><body>안녕하세요</body></html>” representation을 선택하여 응답할 것이다. 만약 적절한 representation이 존재하지 않는다면 406 Not Acceptable로 응답할 것이다.

이러한 선택을 “여러 리소스 중 하나가 선택되었다”라고 말할 수 없는 이유는 무엇인가? “안녕하세요”든 “hello”든 모두 uri가 동일하기 때문이다. uri가 동일하다면 같은 리소스이다. 따라서 여러 리소스 중 하나가 선택된 것이 아니다.

주의: 서버가 uri의 목록으로 된 선택지를 주면 클라이언트가 선택하는 사후 협상(reactive negotiation)도 있는데, 이 경우는 선택지마다 uri가 각각 다를 것이므로, 클라이언트가 리소스들 중 하나를 선택한다고 표현해도 무방할지도 모른다. 자세한 것은 HTTP 명세를 참고하라.

REST에서의 representation
이처럼 HTTP 명세는 representation이라는 개념을 도입하고 있다. 그리고 이 representation은 바로 REST에서 온 것이다.

REST는 REpresentational State Transfer의 줄임말이다. “State”는 웹 애플리케이션 의 상태를 의미하며, “Transfer”는 이 상태의 전송을 의미한다.

웹 브라우저로 웹 사이트를 이용하는 예를 들어보자. 웹 페이지 A를 보고 있던 사용자가 웹 페이지 B로 가는 링크를 클릭하면, 웹 브라우저는 링크가 가리키는 웹 페이지 B를 렌더링해서 보여줄 것이다.

위의 상황에서 웹 애플리케이션은 무엇인가? 웹 브라우저와 웹 서버가 연결되어 사용자에게 가치를 제공하는 애플리케이션이다. 웹 서버가 웹 애플리케이션인 것이 아니라, 웹 브라우저가 웹 서버에 접속해야 웹 애플리케이션이다. 두 명의 사용자가 각각 자신의 웹 브라우저로 같은 웹 서버에 접속한다면, 두 개의 웹 애플리케이션이 실행되고 있는 것이다.

링크를 클릭함으로써 브라우저가 보여주던 페이지는 A에서 B로 바뀌었다. 즉, 웹 애플리케이션의 상태가 변경된 것이다. 또한 이 상태의 변경은 representation의 전송(Transfer)을 통해 이루어졌다. 그렇기 때문에 이것이 REpresentational State Transfer인 것이다.

여기서 두 가지 주의할 점이 있다.

1. Transfer는 상태의 전이(transit)을 의미하는 것이 아니다. 사용자가 링크를 클릭함으로써 웹 애플리케이션의 상태가 전이된 것은 사실이지만, Transfer가 의미하는 것은 그 전이가 아니라 network component 사이에서의 전송을 말한다. 즉 이 예에서는 서버에서 클라이언트로의 웹 페이지 전송을 의미하는 것이다.

2. 리소스의 상태와 애플리케이션의 상태는, 둘 다 동일하게 “state”라는 단어로 표현되고 있긴 하지만, 본질적으로 완전히 다른 것이다. 앞서 representation이란 “어떤 리소스의 특정 시점의 상태(state)를 반영하고 있는 정보”라고 말했다. 그것은 리소스의 상태지 애플리케이션의 상태는 아니다. 애플리케이션의 상태란, 웹 애플리케이션이 웹 페이지 A를 렌더링하다가 B를 렌더링하는 것으로 바뀐 그 상태를 말하는 것이다.

모든 payload는 representation
HTTP 메시지의 payload로 전달되는 모든 것은 하나의 representation이거나 적어도 그의 일부이다. PUT 메서드를 이용해 “welcome” 이란 텍스트를 전송해서, greeting 리소스의 representation을 업데이트하는 경우, 클라이언트가 서버로 전송한 “welcome”은 representation이다. 업데이트가 성공하여 서버가 “성공적으로 업데이트되었습니다”라는 메시지를 응답의 payload로 돌려보냈다면 이 메시지 역시 representation이다. “권한이 없습니다”라는 에러 메시지로 응답했다면 그 메시지도 역시 representation이다.

그렇다. 성공시나 에러시의 메시지도 역시 representation이다. 그런데 앞에서 분명 representation은 어떤 “리소스”에 대한 상태를 담은 정보라고 했다. 그렇다면 도대체 “성공적으로 업데이트되었습니다”는 어떤 리소스에 대한 것인가? greeting 리소스의 representation은 “welcome”으로 업데이트되었으니 분명 그것은 아닐 것인데 대체 무엇일까?

이론적으로 정확한 정답은 “Content-Location 헤더에 들어있는 uri가 가리키는 리소스”이다. 그러나 보통 Content-Location 헤더는 비어 있을 것이므로 현실적인 정답은 “uri를 모르는 어떤 리소스”이다. 그 메시지는 representation이 맞고, 어떤 존재하는 리소스에 대한 것이지만, 그 리소스를 가리키는 uri가 뭔지는 모른다. 이와 같은 representation을 unidentified representation이라고 하며, 어떤 payload가 unidentified representation인지 판단하는 방법은 RFC 7231의 “3.1.4.1. Identifying a Representation” 에 자세히 나와있다.

나는 왜 representation을 몰랐을까
HTTP를 이용해서 오래 개발을 해 온 개발자라도 representation에 대해 잘 몰랐을 수 있다(일단 나는 몰랐다). 그것은 당연한 일이다. 왜냐하면 2014년에 HTTP/1.1이 개정되기 전 까지는 representation의 개념이 명세에 명확하게 드러나 있지 않았기 때문이다. 예를 들어 1999년부터 15년간 HTTP/1.1 명세였던 RFC 2616의 GET 메서드 정의는 다음과 같다.

The GET method means retrieve whatever information (in the form of an
entity) is identified by the Request-URI.

이처럼 representation에 대한 명시적인 언급이 없었다.

하지만 이제 HTTP를 사용하는 개발자들은 representation에 대해 알아야 할 것이다. 그 첫 번째 이유는 오늘날의 HTTP 명세에서 수도 없이 등장하는 개념이기 때문에 이를 모른다면 명세를 올바르게 해석할 수 없기 때문이며, 두 번째 이유는 representation을 이해하지 않고서는 REST에 대해 진지하게 이야기하기가 매우 어렵기 때문이다.
