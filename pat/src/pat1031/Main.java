package pat1031;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		int N = str.length();
		int n2 = 0, n1 = 0;
		for (int i = 3; i <= (N+3)/3 +1; ++i){
			if ( (N+2-i) % 2 == 0){
				n1 = (N+2-i) / 2;
				n2 = i;
			}
		}
		int head = 0, tail = N - 1;
		for (int i = 0; i < n1 - 1; ++i){
			System.out.print(str.charAt(head));
			for (int j = 0; j < n2 - 2; ++j)
				System.out.print(" ");
			System.out.println(str.charAt(tail));
			++head;
			--tail;
		}
		System.out.println(str.substring(head, tail + 1));
		input.close();
	}

}
