package ddd;

import java.util.Scanner;

public class algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int a, b;
		while (cin.hasNext()) {
			a = cin.nextInt();
			b = cin.nextInt();
			System.out.println(a + b);
		}
		cin.close();

	}

}
