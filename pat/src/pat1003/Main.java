package pat1003;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//ArrayList<Integer> adjacent = new ArrayList<Integer>();
		ArrayList<Node> node = new ArrayList<Node>();
		Scanner input = new Scanner(System.in);
		int a1 = input.nextInt();
		int a2 = input.nextInt();
		int a3 = input.nextInt();
		int a4 = input.nextInt();
		for (int i = 0; i < a1; i++){
			int a5 = input.nextInt();
			node.add(new Node(false, a5));
		}
		node.get(a3).setknown(true);
		for (int i = 0; i < a2; i++){
			int a6 = input.nextInt();
			int a7 = input.nextInt();
			int a8 = input.nextInt();
			node.get(a6).getAdjacent().add(new Adjacent(a7, a8));
			node.get(a7).getAdjacent().add(new Adjacent(a6, a8));
		}
		
	}

}

class  Node{
	private boolean known;
	private int rescue;
	ArrayList<Adjacent> adjacent = new ArrayList<Adjacent>();
	
	public Node(boolean known, int rescue){
		this.known = known;
		this.rescue = rescue;
	}
	
	public boolean getknown(){
		return known;
	}
	public void setknown(boolean known){
		this.known = known;
	}
	public int getrescue(){
		return rescue;
	}
	public void setrescue(int rescue){
		this.rescue = rescue;
	}
	public ArrayList<Adjacent> getAdjacent(){
		return adjacent;
	}
}

class Adjacent{
	private int city;
	private int distance;
	
	public Adjacent(int city, int distance){
		this.city = city;
		this.distance = distance;
	}
	public void setcity(int city){
		this.city = city;
	}
	public void setdistance(int distance){
		this.distance = distance;
	}
}