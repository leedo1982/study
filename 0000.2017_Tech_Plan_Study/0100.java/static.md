
### STATIC
static 은 보통 변수나 메소드 앞에 static 키워드를 붙여서 사용하게 된다.

항상 값이 변하지 않는 경우라면 static 사용 시 메모리의 이점을 얻을 수 있다.

static을 사용하는 또 한가지 이유로 공유의 개념을 들 수 있다. static 으로 설정하면 단 한곳의 메모리 주소만을 바라보기 때문에 static 변수의 값을 공유하게 되는 것이다. 다음의 예를 보면 더욱 명확하게 파악할 수 있을 것이다.


### STATIC METHOD
static이라는 키워드가 메소드 앞에 붙으면 이 메소드는 클래스 메소드(static method)가 된다.

※ 클래스 메소드 안에서는 인스턴스 변수 접근이 불가능 하다. 하지만 static methodt는 static 변수이기 때문에 클래스 메소드(static method)에서 접근이 가능한 것이다.


```
public class Counter  {
    static int count = 0;
    Counter() {
        this.count++;
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        System.out.println(Counter.getCount());
    }
}
```
