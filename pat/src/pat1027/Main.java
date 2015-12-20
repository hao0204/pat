package pat1027;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		String colors = "0123456789ABC";
		System.out.println("#" + colors.charAt(num1 / 13) + colors.charAt(num1 % 13) 
				+ colors.charAt(num2 / 13) + colors.charAt(num2 % 13) 
				+ colors.charAt(num3 / 13) + colors.charAt(num3 % 13));
	}

}
