package pat1032;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		//LinkedList<>
		Scanner input = new Scanner(System.in);
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int n3 = input.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n4, n6;
		for (int i = 0; i < n3; i++){
			n4 = input.nextInt();
			input.next();
			n6 = input.nextInt();
			map.put(n4, n6);
		}
		Set<Integer> s = new HashSet<Integer>();
		s.add(n1);
		int i = n1;
		while(map.get(i) != -1){
			s.add(map.get(i));
			i = map.get(i);
		}
		i = n2;
		while(map.get(i) != -1){
			if (!s.add(map.get(i))){
				String str = String.format("%05d", map.get(i));
				System.out.println(str);
				return;
			}
			i = map.get(i);
		}
		System.out.println(-1);
	}
	
}