package pat1023;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		int[] num1 = new int[22];
		int num1_length = num.length(), num2_length;
		int[] num2 = new int[22];
		int[] sum1 = new int[10];
		int[] sum2 = new int[10];
		for (int i = num.length() - 1; i >= 0; i--){
			num1[num.length() - 1 - i] = num.charAt(i) - '0';
		}
		int temp = 0;
		for (int i = 0; i < 22; i++){
			temp = num1[i] << 1; 
			if (temp >= 10){
				num2[i] = num2[i] + temp - 10;
				num2[i+1]++;
			}else
				num2[i] += temp;	
		}
		if (num2[num1_length] > 0)
			num2_length = num1_length + 1;
		else
			num2_length = num1_length;
		for (int i = 0; i < num1_length; i++){
			sum1[num1[i]]++;
		}
		for (int i = 0; i < num2_length; i++){
			sum2[num2[i]]++;
		}
		for (int i = 0; i < 10; i++)
			if (sum1[i] != sum2[i]){
				System.out.println("No");
				for (int k = num2_length - 1; k >=0; k--)
					System.out.print(num2[k]);
				input.close();
				return;
			}
		System.out.println("Yes");
		for (int k = num2_length - 1; k >=0; k--)
			System.out.print(num2[k]);
		input.close();
	}

}
