```
function solution(S) {
    var sLen = S.length;
    if(sLen%2 == 1){
    	console.log("even");
        return 0;
    }
    
    var arrA = S.slice(0,(sLen/2-1));
    var arrB = S.slice((sLen/2-1));
    
    for(var i in arrA){
        if(arrA[i] == arrB[arrB.length-i]){
            return 0;
        }
    }		
    return 1;
}
console.log(solution("())"));
console.log(solution("(())"));

//현재 codility 유지보수중
