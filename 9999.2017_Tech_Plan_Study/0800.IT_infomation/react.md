

## redux 란

소파 테이블이 있는 방

소파의 위치와 테이블의 위치를 바꾸고 싶다.

2명 고용하여 각 가구를 담당 내가 지휘하여 부딪히지 않도록 한다.

MVC 아키텍쳐 패던....


redux == genie
지니는 방을 새로 만들어서 위치를 바꾸어버림~~~대박...

그래서 redux 는 뭐야?
라이브러리
컴포넌트끼지 데이터 교류 및 state를 관리

Flux 추상적 개념, 구현한 것이 redux

MVC
controller => model => <= view

Flux
Dispatcher -> store -> view


Flux 의 구현체 == redux

Redux 특징
1. Single Source of Truth
애플리케이션의 state 를 위헤  단한개의 store를 사용합니다.
Flux 와의 주요차이, Flux 는 여러개의 store를 사용

2. State is Read-only
state 를 변경하기 위해선 무조건 action이 dispatch되어야 한다.

3. Changes are made with pure Functions
reducer :  action 객체를 처리하는 함수
reducer 는 정보를 받아서 상태를 어ㄸ허게 업데이트 할 지 정의합니다.

reducer는 순순 함수로 작성되어야 합니다.  : 비동기 처리 x
즉, 네트워크 및 데이터베이스 접근 x, 인수 변경X
같은 인수르 실행된 함수는 언제나 같은 결과를 반환
순수하지 않은 api 사용불가


action : 작업에 대한 정보를 가지고 있는 객체

reducer  : 변화를 일으키는 함수,  순수해야함 (비동기 작업X, 인수변경 X, 동일한인수는 동일한 결과)
        이전상태와 액션을 받아서 다음상태를 반환한다.(이전 상태 변경이 아닌 새로운 상태를 반환)

store : 어플리케이션의 현재 상태를 지니고 있음        
하는일 1 : dispatch(action)
하는일 2 : getState
하는일 3 : subscribe(listener)
하는일 4 : replaceReducer(nextReducer)



react-redux : 뷰레이어 바인딩
1: provider(컴포넌트이다)
2: connect([...option]) 컴포넌트를 redux에 연결하는 함수를 반환합니다.
==> connect()(Counter) store에 연결된 새로운 컴포넌트 클래스가 반환됨
    옵션이 없으면 this.props.store로 접근가능 
