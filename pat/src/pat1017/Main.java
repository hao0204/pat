package pat1017;
//最后一个case被卡性能了，哭哭
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		input.nextLine();
		ArrayList<Person> customers = new ArrayList<Person>();
		for (int i = 0; i < N; ++i){
			String[] str = input.nextLine().split(" ");
			String[] temp = str[0].split(":");
			int hh = Integer.parseInt(temp[0]);
			int mm = Integer.parseInt(temp[1]);
			int ss = Integer.parseInt(temp[2]);
			customers.add(new Person(hh * 3600 + mm * 60 + ss, Integer.parseInt(str[1]) * 60));
		}
		Collections.sort(customers, new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2){
				Person p1 = (Person) o1;
				Person p2 = (Person) o2;
				return new Integer(p1.getComeSeconds()).compareTo(new Integer(p2.getComeSeconds()));
			}
		});
		int num = 0;
		ArrayList<Person> window = new ArrayList<Person>();
		int start = 8 * 60 * 60;
		int end = 17 * 60 * 60;
		int sum = 0;
		while (customers.size() != 0){
			Person p = customers.get(0);
			if (p.getComeSeconds() > end)
				break;
			++num;
			if (window.size() == K){
				int minFinishTime = Integer.MAX_VALUE;
				int minIndex = -1;
				for (int i = 0; i < 3; ++i){
					if (minFinishTime > window.get(i).getFinishSeconds()){
						minFinishTime = window.get(i).getFinishSeconds();
						minIndex = i;
					}
				}
				Person r1 = window.remove(minIndex);
				if (r1.getFinishSeconds() > p.getComeSeconds()){
					p.setWaitSeconds(r1.getFinishSeconds() - p.getComeSeconds());
					p.setFinishSeconds(r1.getFinishSeconds() + p.getDealSeconds());
				}
				else{
					p.setWaitSeconds(0);
					p.setFinishSeconds(p.getComeSeconds() + p.getDealSeconds());
				}
				sum += p.getWaitSeconds();
			}else{
				if (p.getComeSeconds() < start){
					p.setWaitSeconds(start - p.getComeSeconds());
					p.setFinishSeconds(start + p.getDealSeconds());
				}
				else{
					p.setWaitSeconds(0);
					p.setFinishSeconds(p.getComeSeconds() + p.getDealSeconds());
				}
				sum += p.getWaitSeconds();
			}
			window.add(p);
			customers.remove(0);
		}
		double time = sum * 1.0 / num / 60;
		String result = String.format("%.1f", time);
		System.out.println(result);
		input.close();
	}

}

class Person{
	
	private int comeSeconds;
	private int waitSeconds;
	private int dealSeconds;
	private int finishSeconds;
	
	Person(int comeSeconds, int dealSeconds){
		this.comeSeconds = comeSeconds;
		this.dealSeconds = dealSeconds;
	}
	
	public int getComeSeconds() {
		return comeSeconds;
	}
	public void setComeSeconds(int comeSeconds) {
		this.comeSeconds = comeSeconds;
	}
	public int getWaitSeconds() {
		return waitSeconds;
	}
	public void setWaitSeconds(int waitSeconds) {
		this.waitSeconds = waitSeconds;
	}
	public int getFinishSeconds() {
		return finishSeconds;
	}
	public void setFinishSeconds(int finishSeconds) {
		this.finishSeconds = finishSeconds;
	}

	public int getDealSeconds() {
		return dealSeconds;
	}

	public void setDealSeconds(int dealSeconds) {
		this.dealSeconds = dealSeconds;
	}
	
}
