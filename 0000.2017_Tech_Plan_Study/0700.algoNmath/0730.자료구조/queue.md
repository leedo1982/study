
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

#### 1.선형큐
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


