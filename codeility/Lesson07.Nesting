```
function solution(S) {
    var len = S.length;
     
    if (!len){
        return 1;
    }
     
    var stack = [],
    matches = {
        "(" : ")"
    };
     
    for (i=0; i < len; i++){
        var currentCharacter = S[i];
        if (matches[currentCharacter]){
            stack.push(currentCharacter);
        } else {
            if (!stack.length){
                return 0;
            }   
            var previousCharacter = stack.pop();
            if (matches[previousCharacter] !== currentCharacter){
                return 0;
            }   
        }   
    }        
     
    return (stack.length)? 0 : 1;
}  

출처  
http://julienrenaux.fr/2015/04/27/codility-efficient-algorithm-solutions-in-javascript/#Nesting
