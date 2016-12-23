

### title : Build a pile of Cubes.



```javaScript

	//my solution
    function findNb(m) {
        // your code
        // 1. m�� ��� �� �����ΰ�?!
           var nSqrt =  Math.sqrt(m);

        // 2. nSqrt�� ���� �ΰ�?!
        if(!(/^\d*$/.test(nSqrt))){
                   return (-1); 
        }
        
        // 2. m�� n(n+1)/2 �ΰ�?1
        var nNum = 2 * nSqrt;
           for(var i = 1 ; i < nSqrt ; i++){
                if( nNum % i == 0  && Math.abs( (nNum / i) - i) == 1 ){
                  return i; 
           }
        }
           // �׿ܴ� ��� -1
        return (-1);
    }

    // best solution
    function findNb(m) {
      var n = 0
      while (m > 0) m -= ++n**3
      return m ? -1 : n
    }

```