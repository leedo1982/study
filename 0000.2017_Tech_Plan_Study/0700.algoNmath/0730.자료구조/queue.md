
## Queue
### 목차
1. 큐
2. 큐의 구현
3. 큐의 응용

### 큐
FIFO(First-In-First-Out)

### 큐의 구현
- 선형 큐 : 1차원배열을 이용하는 구현
- 원형 큐 : 선현츄의 저장공간 제한 문제를 해결
- 연결 큐 : 연결 리스트를 이용하여 구현

#### 선형큐
- 1차원 배열을 이용한 큐
 - 큐의 크기 = 배열의 크기
 - 변수 front : 저장된 첫번재 원소의 인덱스 저장
 - 변수 rear : 저장된 마지막 원소의 인덱스 저장

상태표현
- 초기상태 : front = rear -1
- 공백상태 : front = rear
- 포화상태 : rear = n -1 ( n : 배열의 크기 , n-1 : 배열의 마지막 인덱스)

초기 공백 큐 생성 알고리즘
 - 크기가 n인 1차원 배열 생성
 - front와 rear를 -1로 초기화

공백 큐 검사 알고리즘과 포화상태 검사 알고리즘
 - 공백상태 : front = rear
 - 포화상태 : rear = n-1


 큐의 삽입 알고리즘
 ```
 enQueue(Q, item)
    if(isFull(Q)) then Queue_Full();
    else{
        rear <- rear+1;
        Q[rear] <- item;
    }
end enQueue()
 ```
큐 삭제 알고리즘
 ```
 deQueue(Q, item)
    if(isEmpty(Q)) then Queue_Empty();
    else{
        front <- front +1; // front의 위치를 한자리 뒤로 이동하여 남아있는 첫번째 원소의 위치로 이동하여 삭제할 자리준비
        retrun Q[front];   // 그 자리의 원소를 삭제하여 반환  
    }
end deQueue()

delete(Q)
    if(isEmpty(Q)) then Queue_Empty();
    else front <- front+1;
end delete()
 ```
큐의 검색 알고리즘 : 가장 앞에 있는 원소를 검색하여 반환하는 연산 
```
peek(Q)
    if(isEmpth(Q)) then Queue_Empty();
    else return Q[front+1];
end peek()
```


#### 원형 큐의 구현
1. 구조
 - 초기 공백상태 :  front = rear = 0
 - front와 rear 의 위치가 배열의 마지막 인덱스 n-1 에서 논리적인 다음자리인 
    인덱스 0번으로 이동하기 위해서 나머지연산자 mod를 사용

 - 포화상태와 공백상태 구분을 쉽게 하기 위해서 front가 있는 자리는 사용하지 않고 항산 빈자리로 둔다.

2. 초기 공백 원형 큐 생성 알고리즘

```
    createQueue()
        cQ[n];
        front <- 0;
        rear <- 0;
    end createQueue()
```

3. 원형큐의 공백상태 검사 알고리즘과 포화상태 검사 알고리즘
```
    isEmpty(cQ)
        if(front=rear) then return true;
        else return false;
    end isEmpth()

    isFull(cQ)
        if(((rear+a) mod n)=front ) then return true;
        else return false;
    end isFull()
```
4. 원형 큐의 삽일 알고리즘
```
    enQueue(cQ, item)
        if(isFull(cQ)) then Queue_Full();
        else {
            rear <- (rear+1) mod n; // rear의 값을 조정하여 삽입할 자리를 준비
            cQ[rear] <- item;   // 준비한 자리에 cQ[rear]에 원소 item을 삽입
        }
    end enQueu()
```

5. 원형 큐의 삭제 알고리즘
```
    deQueu(cQ)
        if(isEmpty(cQ)) then Queue_Empty();
        else {
            front <- (front+1) mod n; 
            return cQ[front];
        }
    end deQueue()

    delete(cQ)
        if(isEmpty(Q)) then Queu_Empty()'
        else front <- (front+1) mod n;
    end delete()
```

#### 연결 큐

1. 초기 공백 연결 큐 생성 알고리즘
```
    crateLinkedQueue()
        front <- null;
        rear <- null;
    end crateLinkedQueue() 
```

2. 공백 연결 큐 검사 알고리즘
```
    isEmpty(LQ)
        if(front=null) then return true;
        else return false;
    end isEmpty()
```

3. 연결 큐의 삽입 알고리즘
```
    enQueue(LQ, item)
        new <- getNode();
        new.data <- item;
        new.like <- null;
        if(isEmpth(LQ)) then {
            rear <- new;
            front <- new;
        }
        else {
            rear.link <- new;
            rear <- new;
        }
    end enQueue()
```

4. 연결 큐의 삭제 알고리즘
```
    deQueue(LQ)
        if(isEmpty(LQ)) then Queu_Empth();
        else {
            old <- front;
            item <- front.data;
            front <- front.link;
            if(isEmpth(LQ)) then rear <- null;
            returnNode(old);
            return item;
        }
    end deQueue()

    delete(LQ)
        if(isEmpth(LQ)) then Queue_Empty();
        else {
            old <- front;
            front <- front.link;
            if(isEmpty(LQ)) then rear <- null;
            returnNode(old);
        }
    end delete()
```

5. 연결 큐의 검색 알고리즘
```
    peek(LQ)
        if(isEmpth(LQ)) then Queue_Empty()
        else return (front.data)
    end peek()
```

#### 덱(deque)
: 큐 2개를 반대로 붙여서 만드는 자료구조

덱의 규현 : 양쪽 끝에서 삽입/삭제 연산을 수행하면서 크기 변화와 저장된 원소의 순서 변화가 많으므로
순차 자료구조는 비효율적, 양방향으로 연산이 가능한 이중 연결 리스트를 사용한다.

### 큐의 응용
1. 운영체제의 작업 큐
- 프린터 버퍼 큐
- 스케줄링 큐

2. 시뮬레이션 큐잉 시스템


