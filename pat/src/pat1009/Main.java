package pat1009;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int K1 = input.nextInt();
		HashMap<Integer, Double> polynomial1 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> polynomial2 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> polynomial3 = new HashMap<Integer, Double>();
		for (int i = 0; i < K1; ++i){
			int exponents = input.nextInt();
			double coefficients = input.nextDouble();
			polynomial1.put(exponents, coefficients);
		}
		int K2 = input.nextInt();
		for (int i = 0; i < K2; ++i){
			int exponents = input.nextInt();
			double coefficients = input.nextDouble();
			polynomial2.put(exponents, coefficients);
		}
		for (Map.Entry<Integer, Double> entry1: polynomial1.entrySet()){
			int a1 = entry1.getKey();
			double b1 = entry1.getValue();
			for (Map.Entry<Integer, Double> entry2: polynomial2.entrySet()){
				int a2 = entry2.getKey();
				double b2 = entry2.getValue();
				int a3 = a1 + a2;
				double b3 = b1 * b2;
				if (polynomial3.containsKey(a3)){
					polynomial3.put(a3, polynomial3.get(a3) + b3);
				}else{
					polynomial3.put(a3, b3);
				}
			}
		}
		List<Map.Entry<Integer, Double>> array = new ArrayList<Map.Entry<Integer, Double>>(polynomial3.entrySet());
		for (int i = array.size() -1; i >= 0; --i){
			if (array.get(i).getValue().compareTo(0.0) == 0)
				array.remove(i);
		}
		Collections.sort(array, new Comparator<Map.Entry<Integer, Double>>(){
			@Override
			public int compare(Map.Entry<Integer, Double>o1, Map.Entry<Integer, Double>o2){
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		Collections.reverse(array);
		int i = 0;
		System.out.print(array.size() + " ");
		for (i = 0; i < array.size() - 1; ++i){
			Map.Entry<Integer, Double> entry = array.get(i);
			System.out.print(entry.getKey() + " " + String.format("%.1f", entry.getValue()) + " ");
		}
		System.out.print(array.get(i).getKey() + " " + String.format("%.1f", array.get(i).getValue()));
		input.close();
	}

}