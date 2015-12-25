package pat1042;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int K = input.nextInt();
		int[] order = new int[55];
		for (int i = 1; i < 55; ++i)
			order[i] = input.nextInt();
		
		String[] cards = new String[55];
		for (int i = 1; i <= 13; ++i)
			cards[i+0] = "S" + i;
		for (int i = 1; i <= 13; ++i)
			cards[i+13] = "H" + i;
		for (int i = 1; i <= 13; ++i)
			cards[i+26] = "C" + i;
		for (int i = 1; i <= 13; ++i)
			cards[i+39] = "D" + i;
		cards[53] = "J1";
		cards[54] = "J2";
		while(K > 0){
			String[] temp = new String[55];
			for (int i = 1; i < 55; ++i)
				temp[order[i]] = cards[i];
			cards = temp;
			--K;
		}
		for(int i = 1; i < 54; ++i)
			System.out.print(cards[i] + " ");
		System.out.println(cards[54]);
		input.close();
	}

}
