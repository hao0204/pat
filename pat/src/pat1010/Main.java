package pat1010;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		String N1 = input.next();
		String N2 = input.next();
		int tag = input.nextInt();
		int radix = input.nextInt();
		if (tag == 1)
			getRadix(N1, radix, N2);
		else if (tag == 2)
			getRadix(N2, radix, N1);
		input.close();
	}
	
	static void getRadix(String N1, int radix, String N2){
		double sum1 = 0, sum2 = 0;
		double k1 = 1, k2 = 0, radix2 = 0, k3 = 0;
		for (int i = N1.length()-1; i >= 0; --i){
			if ( Character.isLetter(N1.charAt(i))){
				sum1 = sum1 + (N1.charAt(i) - 'a' + 10) * k1;
				k1 *= radix;
			}else if (Character.isDigit(N1.charAt(i))){
				sum1 = sum1 + (N1.charAt(i) - '0') * k1;
				k1 *=radix;
			}
		}
		for (int i = 0; i < N2.length(); ++i){
			if (Character.isLetter(N2.charAt(i))){
				k3 = N2.charAt(i) - 'a' + 10;
			}else
				k3 = N2.charAt(i) - '0';
			if (radix2 < k3)
				radix2 = k3;
		}
		double low = radix2 +1;
		double high = sum1 > low? (sum1+1): (low+1);
		for (; low < high;){
			radix2 = (int)((low + high) / 2);
			sum2 = 0;
			k2 = 1;
			for (int i = N2.length()-1; i >= 0; --i){
				if (Character.isLetter(N2.charAt(i))){
					sum2 = sum2 + (N2.charAt(i) - 'a' + 10) * k2;
					k2 *= radix2;
				}else if (Character.isDigit(N2.charAt(i))){
					sum2 = sum2 + (N2.charAt(i) - '0') * k2;
					k2 *= radix2;
				}
			}
			if (sum2 > sum1){
				high = radix2;
			}else if (sum2 < sum1){
				low = radix2;
			}else
				break;
		}
		if (sum1 == sum2)
			System.out.println((int)radix2);
		else
			System.out.println("Impossible");
	}

}
