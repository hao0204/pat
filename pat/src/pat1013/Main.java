package pat1013;

import java.util.Scanner;
//考察并查集知识。用java最后一个case过不了，改写c／c++即可。
public class Main {
	
	private static int[] father;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int K = input.nextInt();
		int[][] map = new int[M][2];
		father = new int[N + 1];
		for (int i = 0; i < M; ++i){
			map[i][0] = input.nextInt();
			map[i][1] = input.nextInt();
		}
		for (int i = 0; i < K; ++i){
			int city = input.nextInt();
			int sum = 0;
			for (int j = 1; j < N+1; ++j)
				father[j] = j;
			for (int j = 0; j < M; ++j)
				if (map[j][0] != city && map[j][1] != city)
					union(map[j][0], map[j][1]);
			for (int j = 1; j < N+1; ++j)
				if (father[j] == j && j != city)
					++sum;
			System.out.println(sum - 1);
		}
		input.close();
	}
	
	private static void union(int a, int b){
		int a1 = findParent(a);
		int b1 = findParent(b);
		if (a1 == b1)
			return;
		else if (a1 > b1)
			father[a1] = b1;
		else
			father[b1] = a1;
	}
	
	private static int findParent(int a){
		while(father[a] != a){
			a = father[a];
		}
		return a;
	}
}
