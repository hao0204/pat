package pat1007;

import java.util.ArrayList;
import java.util.Scanner;
//动态规划
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int K = input.nextInt();
		ArrayList<Node> numbers = new ArrayList<Node>(K);
		boolean flag = false;
		for (int i = 0; i < K; ++i){
			int temp = input.nextInt();
			numbers.add(new Node(temp));
			if (temp >= 0)
				flag = true;
		}
		input.close();
		if (!flag){
			System.out.println(0 + " " + numbers.get(0).getNum() + " " + numbers.get(K-1).getNum());
			return;
		}
		numbers.get(0).setStart(0);
		numbers.get(0).setSum(numbers.get(0).getNum());
		for (int i = 1; i < K; ++i){
			if (numbers.get(i-1).getSum() < 0){
				numbers.get(i).setStart(i);
				numbers.get(i).setSum(numbers.get(i).getNum());
			}else{
				numbers.get(i).setStart(numbers.get(i-1).getStart());
				numbers.get(i).setSum(numbers.get(i-1).getSum() + numbers.get(i).getNum());
			}
		}
		int sum = numbers.get(0).getSum();
		int index = 0;
		for (int i = 1; i < K; ++i){
			if(numbers.get(i).getSum() > sum){
				sum = numbers.get(i).getSum();
				index = i;
			}
		}
		System.out.println(numbers.get(index).getSum() + " " + numbers.get(numbers.get(index).getStart()).getNum() + " " + numbers.get(index).getNum());
	}

}

class Node{
	
	private int num;
	private int sum;
	private int start;
	
	public Node(){
		num = 0;
		sum = 0;
		start = 0;
	}
	public Node(int num){
		this.num = num;
		sum = 0;
		start = 0;
	}
	
	public int getSum(){
		return sum;
	}
	public void setSum(int sum){
		this.sum = sum;
	}
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
