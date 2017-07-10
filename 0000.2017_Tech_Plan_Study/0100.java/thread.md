쓰레드란
동시에 여러가지 작업을 동시에 수행할 수 있게하는것
동시에 여러가지 작업을 수행할 수 있습니다.
프로세스란 현재 실행되고 있는 프로그램을 말합니다.
자바 프로그램은 JVM에 위해 실행된다. 이 JVM도 프로그램중에 하나이다.
운영체제 입장으로 보면 자바도 하나의 프로세스로 실행을 하는 것입니다.
워드프로세서가 하나의 프로세스라면, 하나의 프로세스 안에서도 여러개의 흐름이 동작할 수 있다. 이것은 Thread라고 말을 합니다.
자바 그램이 여러개의 작업을 동시에 하게 만들고 싶다면 Thread를 공부해야 합니다.
자바에서 Thread를 만드는 방법은 크게 Thread 클래스를 상속받는 방법과 Runnable인터페이스를 구현하는 방법이 있다.
Thread를 상속 받아서 쓰레드를 생성하는 방법
java.lang.Thread클래스를 상속받는다. 그리고 Thread가 가지고 있는 run()메소드를 오버라이딩한다.
10번 반복하면서 str을 찍습니다.
```
    public class MyThread1 extends Thread {
        String str;
        public MyThread1(String str){
            this.str = str;
        }

        public void run(){
            for(int i = 0; i < 10; i ++){
                System.out.print(str);
                try {
                    //컴퓨터가 너무 빠르기 때문에 수행결과를 잘 확인 할 수 없어서 Thread.sleep() 메서드를 이용해서 조금씩
                    //쉬었다가 출력할 수 있게한다.
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
```
Thread 클래스를 상속받은 MyThread1을 사용하는 클래스
Thread를 상속 받았으므로 MyThread1은 Thread 이다.
쓰레드를 생성하고, Thread 클래스가 가지고 있는 start() 메소드를 호출 한다.
```
    public class ThreadExam1 {
        public static void main(String[] args) {
            // MyThread인스턴스를 2개 만듭니다.
            MyThread1 t1 = new MyThread1("*");
            MyThread1 t2 = new MyThread1("-");

            t1.start();
            t2.start();
            System.out.print("!!!!!");  
        }   
    }
```
