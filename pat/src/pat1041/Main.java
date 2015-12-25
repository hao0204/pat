package pat1041;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//pat上无法通过，运行超时。语言本身问题。
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String[] str = input.nextLine().split(" ");
		LinkedHashMap<String, Integer> winningNumber = new LinkedHashMap<String, Integer>();
		for(int i = 1; i < str.length; ++i){
			String temp = str[i];
			if (winningNumber.containsKey(temp))
				winningNumber.put(temp, winningNumber.get(temp) + 1);
			else
				winningNumber.put(temp, 1);
		}
		boolean flag = false;
		for (Map.Entry<String, Integer> e: winningNumber.entrySet()){
			if (e.getValue() == 1){
				flag = true;
				System.out.println(e.getKey());
				break;
			}
		}
		if (!flag)
			System.out.println("None");
		input.close();
	}

}
