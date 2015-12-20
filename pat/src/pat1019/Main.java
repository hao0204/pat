package pat1019;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int b = input.nextInt();
		ArrayList<Integer> num = new ArrayList<Integer>();
		if (N == 0){
			num.add(N);
		}
		else{
			while (N != 0){
				num.add(N % b);
				N /= b;
			}
		}
		for (int i = 0, j = num.size()-1; i < j; i++, j--){
			if (num.get(i) != num.get(j)){
				System.out.println("No");
				System.out.print(num.get(num.size() - 1));
				for(int k = num.size() - 2; k >= 0; k--)
					System.out.print(" " + num.get(k));
				input.close();
				return ;
			}
		}
		System.out.println("Yes");
		System.out.print(num.get(0));
		for (int k = 1; k < num.size(); k++)
			System.out.print(" " + num.get(k));
		input.close();
	}

}
