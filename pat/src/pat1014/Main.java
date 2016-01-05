package pat1014;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int K = input.nextInt();
		int Q = input.nextInt();
		
		ArrayList<Window> queues = new ArrayList<Window>();
		for (int i = 0; i < N; ++i){
			queues.add(new Window(M));
		}
		ArrayList<Node> customers = new ArrayList<Node>();
		for (int i = 0; i < K; ++i){
			int cost = input.nextInt();
			Node node=  new Node(i+1, cost);
			Node temp = insert(queues, node);
			customers.add(node);
			if (temp.getIndex() != -1){
				for (int j = 0; j < customers.size(); ++j)
					if (customers.get(j).equals(temp)){
						customers.get(j).setStartTime(temp.getStartTime());
						customers.get(j).setFinishedTime(temp.getFinishedTime());
					}
			}
		}
		for (int i = 0; i < queues.size(); ++i){
			Window window = queues.get(i);
			Queue<Node> queue = window.getArray();
			int time = window.getTime();
			while (true){
				Node node = queue.poll();
				if (node != null){
					node.setStartTime(time);
					time += node.getCost();
					node.setFinishedTime(time);
					for (int k = 0; k < customers.size(); ++k)
						if (customers.get(k).equals(node)){
							customers.get(k).setStartTime(node.getStartTime());
							customers.get(k).setFinishedTime(node.getFinishedTime());
						}
				}else
					break;
			}
		}
		for (int i = 0; i < Q; ++i){
			int query = input.nextInt();
			int time1 = customers.get(query - 1).getStartTime();
			if (time1 < 1020)
				System.out.println(deal(customers.get(query - 1).getFinishedTime()));
			else
				System.out.println("Sorry");
		}
		input.close();
	}
	
	static Node insert(ArrayList<Window> queues, Node node){
		int index = -1;
		int min = Integer.MAX_VALUE;
		Node temp = new Node();
		for (int i = 0; i < queues.size(); ++i){
			Window window = queues.get(i);
			if (window.getCapacity() > (window.getIndex()+1) && min > window.getIndex()){
				min = window.getIndex();
				index = i;
			}
		}
		if (index != -1){
			queues.get(index).setIndex(queues.get(index).getIndex() + 1);
			queues.get(index).getArray().offer(node);
		}else{
			int minTime = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 0; i < queues.size(); ++i){
				Window window = queues.get(i);
				if (minTime > (window.getTime() + window.getArray().peek().getCost())){
					minTime = window.getTime() + window.getArray().peek().getCost();
					minIndex = i;
				}
			}
			temp = queues.get(minIndex).getArray().poll();
			temp.setStartTime(queues.get(minIndex).getTime());
			queues.get(minIndex).setTime(minTime);
			queues.get(minIndex).getArray().offer(node);
			temp.setFinishedTime(minTime);
		}
		return temp;
	}
	
	static String deal(int time){
		int i = time % 60;
		int j = time / 60;
		String s = "";
		if (j < 10)
			s += "0";
		s = s + j + ":";
		if (i < 10)
			s += "0";
		s += i;
		return s;
	}
}

class Node{
	
	private int index;
	private int cost;
	private int startTime;
	private int finishedTime;

	Node(){
		index = -1;
		cost = -1;
	}
	
	@Override
	public boolean equals(Object o){
		Node temp = (Node)o;
		return this.index == temp.getIndex();
	}
	
	Node(int index, int cost){
		this.index = index;
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getFinishedTime() {
		return finishedTime;
	}
	public void setFinishedTime(int finishedTime) {
		this.finishedTime = finishedTime;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
}

class Window{
	
	private int capacity;
	private int time;
	private int index;
	Queue<Node> array;
	
	Window(int capacity){
		this.capacity = capacity;
		this.time = 480;
		this.index = -1;
		array = new LinkedList<Node>();
	}
		
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Queue<Node> getArray() {
		return array;
	}

	public void setArray(Queue<Node> array) {
		this.array = array;
	}
}