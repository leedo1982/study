

### title : Build a pile of Cubes.



```javaScript

	//my solution
    function findNb(m) {
        // your code
        // 1. m이 어떤수 의 제곱인가?!
           var nSqrt =  Math.sqrt(m);

        // 2. nSqrt이 정수 인가?!
        if(!(/^\d*$/.test(nSqrt))){
                   return (-1); 
        }
        
        // 2. m이 n(n+1)/2 인가?1
        var nNum = 2 * nSqrt;
           for(var i = 1 ; i < nSqrt ; i++){
                if( nNum % i == 0  && Math.abs( (nNum / i) - i) == 1 ){
                  return i; 
           }
        }
           // 그외는 모두 -1
        return (-1);
    }

    // best solution
    function findNb(m) {
      var n = 0
      while (m > 0) m -= ++n**3
      return m ? -1 : n
    }

```