package pat1046;

import java.util.ArrayList;
import java.util.Scanner;
// 一个测试用例为运行超时
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		ArrayList<Integer> distances = new ArrayList<Integer>(N);
		for (int i = 0; i < N; ++i)
			distances.add(input.nextInt());
		int M = input.nextInt();
		for (int i = 0; i < M; ++i){
			int start = input.nextInt() - 1;
			int end = input.nextInt() - 1;
			if (start > end){
				start ^= end;
				end ^= start;
				start ^=end;
			}
			int distance1 = 0;
			int distance2 = 0;
			for (int j = start; j < end; ++j)
				distance1 += distances.get(j);
			for (int j = end; j < N; ++j)
				distance2 += distances.get(j);
			for (int j = 0; j < start; ++j)
				distance2 += distances.get(j);
			if (distance1 < distance2)
				System.out.println(distance1);
			else
				System.out.println(distance2);
		}
		input.close();
	}

}
