75%/25%ㅡㅡ
    function solution(A, B) {
        var arr1 = [];
        var aLen = A.length;
        
        A.push(A[aLen]);

        for (var i = 0; i < aLen; i++) {
            arr1.push(A[i]);
            // B가 1이고 다음이 0인경우만 문제....
            if (B[i] == 1 && B[i + 1] == 0) {
                if (A[i] > A[i + 1]) {
                    A[i + 1] = A[i];
                    B[i + 1] = 1;
                    arr1.pop();
                }else{
                    arr1.pop();
                }
            }
        }
        return arr1.length;
    }
