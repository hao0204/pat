package pat1007;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int K = input.nextInt();
		int[][] sum = new int[K][K];
		boolean key = true;
		//ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < K; i++){
			//numbers.add(input.nextInt());
			sum[i][i] = input.nextInt();
			if (sum[i][i] >= 0)
				key = false;
		}
		/*for (int i : numbers){
			if (i >= 0)
			{
				key = false;
				break;
			}
		}*/
		if (key)
			System.out.println(0 + " " + 0 + " " +(K - 1));
		else{
			int j = 0;
			//int[][] sum = new int[K][K];
			int indexFirst = 0, indexLast = 0, maxSum = Integer.MIN_VALUE;
			/*for (int i : numbers){
				sum[j][j] = i;
				j++;
			}*/
			//j = 0;
			for (int i = 0; i < K; i++){
				for (j = i; j < K; j++){
					if (i != j)
						sum[i][j] = sum[i][j - 1] + sum[j][j];
					if (maxSum < sum[i][j]){
						maxSum = sum[i][j];
						indexFirst = i;
						indexLast = j;
					}
				}
			}
			System.out.println(maxSum + " " + sum[indexFirst][indexFirst] + " " + sum[indexLast][indexLast]);
		}
		input.close();
	}

}
