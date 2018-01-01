
```
Syntax
`string text`

`string text ${expression} string text`
tag `string text ${expression} string text`
```

Description
```
Template literal 들은  double 또는 single quiotes 대신 back-tick (` `) (grave accent) character 로 감싸집니다. 이들은 Dollar 사인과 중괄호( ${expression} ) 로 표기됩니다. placeholder 내부의 expression 들과 텍스트는 함께 function 으로 전달됩니다. default function 은 단지 부분들을 single string 으로 합칩니다. template literal (여기서는 tag) 이전에 expression 이 있다면, template string은 "tagged template literal" 이라고 불립니다. 그러한 경우에, tag expression (보통은 function) 은, 출력 전에 조작할 수 있는 processed template literal 을 필요로 합니다. template literal 내에서 back-tick 을 escape 하기 위해서, back-tick 앞에 backslash \ 를 넣습니다.
```

`\`` === "`" // --> true


Multi-line strings

source 내에 삽입되는 어떤 새로운 line의 character 들은 template literal 의 부분입니다. 일반 string 들을 사용하여, multi-line string 들을 얻기 위해서는 아래와 같은 문법을 사용해야 할 것입니다.

console.log("string text line 1\n"+
"string text line 2");
// "string text line 1
// string text line 2"
multi-line strings 과 같은 효과를 얻기 위해, 바로 아래와 같이 적을 수 있습니다.

console.log(`string text line 1
string text line 2`);
// "string text line 1
// string text line 2"
Expression interpolation

기본 strings 로 expression 을 embed 하기 위해서, 당신은 다음의 문법을 사용할 수 있을 것입니다.

var a = 5;
var b = 10;
console.log("Fifteen is " + (a + b) + " and\nnot " + (2 * a + b) + ".");
// "Fifteen is 15 and
// not 20."
바로 지금 template literals 로, 더욱 읽기 쉽도록 다음과 같은 문법 설탕(syntactic sugar) 을 활용할 수 있습니다.
