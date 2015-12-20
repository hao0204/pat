package pat1029;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int N1 = input.nextInt();
			int[] n1 = new int[N1];
			for (int i = 0; i < N1; ++i){
				n1[i] = input.nextInt();
			}
			int N2 = input.nextInt();
			int[] n2 = new int[N2];
			for (int i = 0; i < N2; ++i){
				n2[i] = input.nextInt();
			}
			int i1 = 0, i2 = 0;
			int k;
			int cur;
			int mid = (N1 + N2 - 1) / 2;
			for (k = -1; i1 < N1 && i2 < N2;){
				if (n1[i1] <= n2[i2]){
					cur = n1[i1];
					++i1;
					++k;
				}else{
					cur = n2[i2];
					++i2;
					++k;
				}
				if (k == mid){
					System.out.println(cur);
					break;
				}
			}
			if (k != mid && i1 < N1)
				System.out.println(n1[mid + i1 - k - 1]);
			if (k != mid && i2 < N2)
				System.out.println(n2[mid + i2 - k - 1]);
			input.close();
	}
}
