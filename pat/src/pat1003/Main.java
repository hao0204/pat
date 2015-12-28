package pat1003;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cities = input.nextInt();
		int roads = input.nextInt();
		int C1 = input.nextInt();
		int C2 = input.nextInt();
		ArrayList<Integer> teams = new ArrayList<Integer>();
		for (int i = 0; i < cities; ++i)
			teams.add(input.nextInt());
		int[][] map = new int[cities][cities];
		for (int i = 0; i < cities; ++i)
			for (int j = 0; j < cities; ++j)
				map[i][j] = Integer.MAX_VALUE;
		for (int i = 0; i < roads; ++i){
			int city1 = input.nextInt();
			int city2 = input.nextInt();
			int distance = input.nextInt();
			if (map[city1][city2] > distance)
				map[city1][city2] = map[city2][city1] = distance;
		}
		ArrayList<Node> city = new ArrayList<Node>(cities);
		for (int i = 0; i < cities; ++i)
			city.add(new Node());
		boolean[] visit = new boolean[cities];
		Dijkstra(C1, C2, city, teams, visit, map);
		System.out.println(city.get(C2).getPaths() + " " + city.get(C2).getTeams());
		input.close();
	}
	
	static void Dijkstra(int C1, int C2, ArrayList<Node> city, ArrayList<Integer> teams, boolean[] visit, int[][] map){
		city.get(C1).setPaths(1);
		city.get(C1).setTeams(teams.get(C1));
		city.get(C1).setDistance(0);
		while(true){
			int temp = extractMin(city, visit);
			if (temp != -1){
				visit[temp] = true;
				if (temp == C2)
					return;
				for (int i = 0; i < map.length; ++i){
					if (visit[i] || map[temp][i] == Integer.MAX_VALUE)
						continue;
					if (city.get(i).getDistance() > city.get(temp).getDistance()+map[temp][i]){
						city.get(i).setDistance(city.get(temp).getDistance()+map[temp][i]);
						city.get(i).setTeams(city.get(temp).getTeams() + teams.get(i));
						city.get(i).setPaths(city.get(temp).getPaths());
					}else if (city.get(i).getDistance() == city.get(temp).getDistance()+map[temp][i]){
						//注意这里，不是＋1，因为当距离相等时，是将 能够去前面一个点的所有路径条数＋之前就能够去后面一个点的所有路径条数 相加
						city.get(i).setPaths(city.get(temp).getPaths() + city.get(i).getPaths());
						if (city.get(i).getTeams() < teams.get(i) + city.get(temp).getTeams())
							city.get(i).setTeams(teams.get(i) + city.get(temp).getTeams());;
					}
				}
			}else
				return;
		}
	}
	
	static int extractMin(ArrayList<Node> city, boolean[] visit){
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < city.size(); ++i){
			if (!visit[i] && city.get(i).getDistance() < min){
				min = city.get(i).getDistance();
				minIndex = i;
			}
		}
		return minIndex;
	}
	
}

class Node{
	
	private int paths;
	private int teams;
	private int distance;
	
	public Node(){
		paths = 0;
		teams = 0;
		distance = Integer.MAX_VALUE;
	}
	
	public int getPaths(){
		return paths;
	}
	public void setPaths(int paths){
		this.paths = paths;
	}
	
	public int getTeams(){
		return teams;
	}
	public void setTeams(int teams){
		this.teams = teams;
	}
	
	public int getDistance(){
		return distance;
	}
	public void setDistance(int distance){
		this.distance = distance;
	}
}