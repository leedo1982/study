###ECMAScript 6 vs ECMAScript 5
---
목적 : ES5 와 ES6의 비교를 통한 ES6의 이해(참조사이트: http://es6-features.org)

###Constants
####1.Constants(상수: 수식에서 변하지 않는 값을 뜻함, 변수와 반대)
불변하는변수를 지원하며, 새로운 내용을 재할당할수 없다.

```
-ES6
const PI = 3.141593
PI > 3.0

-ES5
//  only in ES5 through the help of object properties
//  and only in global context and not in a block scope
Object.defineProperty(typeof global === "object" ? global : window, "PI", {
    value:        3.141593,
    enumerable:   true,
    writable:     false,
    configurable: false
})
PI > 3.0;

```
###Scoping
####1.Block-Scoped Variables
호스팅 없는 Block-scoped 변수


> var 과 let 차이
> var foo = 'bar1';
> cosole.log(foo); // bar1
> if (true) {
>  var foo = 'bar2';
>  console.log(foo); // bar2
>}
> console.log(foo); // bar2
>
> let foo = 'bar1';
> console.log(foo); // bar1
> 
> if (true) {
>   let foo = 'bar2';
>   console.log(foo) // bar2
> }
> console.log(foo); // bar1
>
> let foo = 'bar1';
> console.log(foo); // bar1
>  
> if (true) {
>   console.log(foo);
>   // Uncaught ReferenceError: foo is not defined
>  
>   let foo = 'bar2';
> }
>  
> console.log(foo);


```
-ES6
for (let i = 0; i < a.length; i++) {
    let x = a[i]
    …
}
for (let i = 0; i < b.length; i++) {
    let y = b[i]
    …
}

let callbacks = []
for (let i = 0; i <= 2; i++) {
    callbacks[i] = function () { return i * 2 }
}
callbacks[0]() === 0
callbacks[1]() === 2
callbacks[2]() === 4

-ES5
var i, x, y;
for (i = 0; i < a.length; i++) {
    x = a[i];
    …
}
for (i = 0; i < b.length; i++) {
    y = b[i];
    …
}

var callbacks = [];
for (var i = 0; i <= 2; i++) {
    (function (i) {
        callbacks[i] = function() { return i * 2; };
    })(i);
}
callbacks[0]() === 0;
callbacks[1]() === 2;
callbacks[2]() === 4;


```
####2.Block-Scoped Fucntion  
호스팅 없는 Block-scoped 함수

```
-ES6
{
    function foo () { return 1 }
    foo() === 1
    {
        function foo () { return 2 }
        foo() === 2
    }
    foo() === 1
}

-ES5
//  only in ES5 with the help of block-scope emulating
//  function scopes and function expressions
(function () {
    var foo = function () { return 1; }
    foo() === 1;
    (function () {
        var foo = function () { return 2; }
        foo() === 2;
    })();
    foo() === 1;
})();

```










---
*언제든 틀린내용이 있으면 말해주세요~
