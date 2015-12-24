package pat1035;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		ArrayList<String> accounts = new ArrayList<String>();
		input.nextLine();
		for (int i = 0; i < N; ++i){
			String temp = input.nextLine();
			accounts.add(temp);
		}
		boolean flag = false;
		int count = 0;
		for (int i = accounts.size() - 1; i >= 0; --i){
			String str[] = accounts.get(i).split(" ");
			if (str[1].contains("1") || str[1].contains("0")
					|| str[1].contains("l") || str[1].contains("O")){
				flag = true;
				accounts.set(i, str[0] + " " + (str[1] = str[1].replaceAll("1", "@")));
				accounts.set(i, str[0] + " " + (str[1] = str[1].replaceAll("0", "%")));
				accounts.set(i, str[0] + " " + (str[1] = str[1].replaceAll("l", "L")));
				accounts.set(i, str[0] + " " + (str[1] = str[1].replaceAll("O", "o")));
			}else{
				++count;
				accounts.remove(i);
			}
		}
		if (flag){
			System.out.println(accounts.size());
			for (int i = 0 ; i < accounts.size(); ++i)
				System.out.println(accounts.get(i));
		}else
			System.out.println("There " + (count == 1?"is ":"are ") + count
					+ (count == 1?" account":" accounts") + " and no account is modified");
		input.close();
	}

}
