import java.util.Scanner;

/**
 * 1로 만들기
 */
public class BaekJoon1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, cnt = 0;

        x = sc.nextInt();

        while (x != 1) {
            if (x % 2 == 0 && (x / 2) % 2 == 0) {
                x = x / 2;
            } else if (x % 3 == 0) {
                x = x / 3;
            } else {
                x--;
            }
            cnt++;
            System.out.println("cnt=" + cnt + " x=" + x);
        }

        System.out.println(cnt);

    }
}
