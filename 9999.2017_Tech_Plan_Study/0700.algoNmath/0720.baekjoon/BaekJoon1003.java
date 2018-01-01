import java.util.Scanner;

public class BaekJoon1003 {

    static int zCnt = 0;
    static int oCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int i = 0 ; i < T ; i++){
            int y ;
            y = sc.nextInt();
            fibonacci(y);
            System.out.println(zCnt+ " "+ oCnt);
            zCnt = 0;
            oCnt = 0;
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            zCnt++;
            return 0;
        } else if (n == 1) {
            oCnt++;
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
