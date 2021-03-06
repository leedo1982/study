

### OSI 7 Layer
: Open System InterconnectionReference Model

국제 표준화 기구 ISO 에서 개발한 모델로 컴퓨터 네트워크 소프트웨어의 개발을
돕기 위해서 7계층으로 나누어 정의한 명세서다.

컴퓨터 네트워크는 아래로 물리/전자기 적인 알고리즘과 이들을 이용해서 통신을 하기 위한
물리적은 장비들 그리고 위로는 컴퓨터 운영체제와 수만은 네트워크 소프트웨어들이 놓이는 전지구적
규모의 광대하고 복잡한 시스템이다.

이런 복잡 거대한 시스템을 유지하기 위해서 네트워크 시스템을 7계층으로 나누기로 했다.

[이미지 참조](https://upload.wikimedia.org/wikipedia/commons/1/14/OSI7Layer_model_3.1.svg)

```
L7 응용계층
L6 표현계층
L5 세션계층
L4 전송계층
L3 네트워크 계층
L2 데이터 링크 계층
L1 물리계층
```

#### L1 물리계층
물리계층은 실제 장치들을 연결하기 위해 필요한 전기적, 물리적 세부사항을 정의한다.
예를 들어, 핀들의 배치나 전압, 전선의 명세 등이 이 계층에 포함된다.
허브나 리피터가 물리계층의 장치이다.
기계적 구조와 전기적 특성을 규정한다. 


#### L2 데이터링크 계층
데이터 링크 계층은 물리적인 네트워크 장비를 일대일(point to point)로 신뢰성있는 통신을 보장하기 위한 
명세를 정의한다.
네트워크 장비(NIC 카드)들이 일대일로 통신을 하기 위해서는 서로의 물리적 이름을 알고 있어야 한다.

NIC는 출시때 MAC Address를 할당하는데, 이 MAC Address를 이용해서 원하는 NIC으로 데이터를 전송할 수 있다.

MAC Address 는 단일 계층 주소 체계이다.
따라서 L2 계층에서는 모든 NIC을 하나의 네트워크로 묶어야 한다.
하나의 네트워크는 데이터가 브로드캐스팅 되는 영역을 의미한다.
L2에서는 NIC의 개수가 늘어나면 네트워크 전체의 성능이 떨어질 수 있다.
확장에 한계가 있다.
L2가 물리적으로 하나의 계층을 가지는 문제를 극복하기 위해서, VLAN 기술을 사용해서 논리적으로 네트워크를 나누는 방법이 있다.

#### L3 네트워크 계층
노드와 노드를 연결해서 네트워크를 구성하기 위한 프로토콜이 정의 되어 있는 계층이다.
망(네트워크)를 구성하기 위해서는 전체 네트워크에서 노드가 유일해야한다.
네트워크에서 노드를 식별하기 위해서 사용하는 대표적인 프로토콜이 IP(internew Protocol)이다

네크워크 상에서 노드는 유일한 IP주소를 부여받고, 이를 통해 식별할수 잇다.
L3에서 제공하는 프로토콜을 이용해서 네트워크 상의 노드는 다른 노드에 데이터를 전송할 수 있다.

MAC Address와 달리 IP Address는 계층구조를 가진다.
따라서 대규모의 네트워크를 조직적으로 관리할 수 잇다.

#### L4. 전송 계층
L3 계층은 노드와 노드사이에 데이터를 전송하는 것만 신경쓴다. 노드와 어떤 방식의 연결을 만들건지에 대해서는
관여하지 않는다.

인터넷은 패킷 스위칭 방식으로 데이터를 전송하며, 경로가 달라질 수 있다.
따라서 패키은 처음 순서와 다른 순소로 목적지에 도달할 수 있다.
또한 경로를 따라가면서 데이터에 잡음이 생길 수도 있다.

이경우 연결방식을 조정해서 패킷의 순서를 재조합하거나, 잡음이 생겼는지 확인하고, 잡음이 생긴
패킷에 대한 재전송 요청들의 일을 할 수 있어야 한다. 대표적인 프로토콜이 UDP와 TCP이다.

#### L5. 세션계층
세션계층은 양 끝단의 응용 프로세스가 통신을 관리하기 위한 방법을 제공한다.
동시 송수신방식, 반이중 방식, 전이중 반식의 통신과 함께, 체크포인팅과 유휴, 종류, 다시시작과정등을 수행한다.
이 계층은  TCP/IP 세션을 만들고 없애는 책이을 진다.

통신하는 사용자들을 동기화하고 오류 복구 명령들을 일괄적으로 다룬다.
L4의 TCP 의 세션과니 부분과 겹치는데, 보통 소프트웨어 개잘자는 세션계층을 신경쓰지 않는다.

#### L6. 표현계층
유저영역에서 처리해야할 데이터의 형식상의 차이를 대신 처리해준다. MIME 인코딩이나
암호화 등에 관련된 동작이 이루어진다. EBCDIC로 인코딩 된 데이터를 ASCII로바꿔주는 등의 일을 한다.

#### L7. 응용계층
일반적인 응용 소프트웨어들이 사용하는 계층으로, 인터넷 소프트웨어 개발자로서는 가장 많이 신경쓰이는 계층이다.
이계층에는 HTTP, FTP, TELNET, SSH 등의 표준 애플리케이션 프로토콜과 함꼐, 직접개발한 프로토콜들이 위치하는 계층이다.

