package pat1015;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N, D;
		while(( N = input.nextInt()) > 0){
			D = input.nextInt();
			if (isPrime(N) && isPrime(reverse(N, D)))
				System.out.println ("Yes");
			else
				System.out.println("No");
		}
		
		input.close();
	}
	
	public static boolean isPrime(int N){
		
		if (N == 0 || N ==1)
			return false;
		for (int i = 2; i <= Math.sqrt(N); i++){
			if (N%i == 0)
				return false;
		}
		return true;
	}
	
	public static int reverse(int N, int D){
		int sum = 0;
		while(N != 0){
			sum = sum*D + N%D;
			N /= D;
		}
		return sum;
	}
}
