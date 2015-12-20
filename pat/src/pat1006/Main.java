package pat1006;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int M = input.nextInt();
		input.nextLine();
		ArrayList<String> records = new ArrayList<String>();
		int minIndex = 0, maxIndex = 0, minTime = Integer.MAX_VALUE, maxTime = Integer.MIN_VALUE, minTimeTemp, maxTimeTemp;
		for (int i = 0; i < M; i++){
			records.add(input.nextLine());
		}
		for(int i = 0; i < records.size(); i++){
			//System.out.println(records.get(i) + " " + i);
			String[] temp = records.get(i).split(" ");
			String[] time1 = temp[1].split(":");
			String[] time2 = temp[2].split(":");
			minTimeTemp = Integer.parseInt(time1[0]) * 3600 + Integer.parseInt(time1[1]) * 60 + Integer.parseInt(time1[2]);
			maxTimeTemp = Integer.parseInt(time2[0]) * 3600 + Integer.parseInt(time2[1]) * 60 + Integer.parseInt(time2[2]);
			if (minTime > minTimeTemp){
				minTime = minTimeTemp;
				minIndex = i;
			}
			if (maxTime < maxTimeTemp){
				maxTime = maxTimeTemp;
				maxIndex = i;
			}
		}
		System.out.println(records.get(minIndex).split(" ")[0] + " " + records.get(maxIndex).split(" ")[0]);
		input.close();
	}

}
