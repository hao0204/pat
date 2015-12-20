package pat1012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < N; i++){
			String ID = input.next();
			int C = input.nextInt();
			int M2 = input.nextInt();
			int E = input.nextInt();
			students.add(new Student(ID, (C+M2+E)/3, C, M2, E));
		}
		rank(0, students);
		rank(1, students);
		rank(2, students);
		rank(3, students);
//		for(Student a: students){
//			for (int i = 0; i < 4; i++)
//				System.out.print(a.getRankGrades()[i]);
//			System.out.print("\n");
//		}
		ArrayList<String> IDs = new ArrayList<String>();
		int max = Integer.MIN_VALUE;
		int max_course = -1;
		String name = "ACME";
		for (Student a: students)
			IDs.add(a.getID());
		for (int i = 0; i < M; i++){
			String str = input.next();
			//System.out.println("str="+str);
			max = Integer.MIN_VALUE;
			max_course = -1;
			if (IDs.indexOf(str) != -1){
				for (int j = 0; j < 4; ++j)
					if (max < students.get(i).getRankGrades()[j]){
						max = students.get(i).getRankGrades()[j];
						max_course = j;
					}
				System.out.println( (5-max) + " " + name.charAt(max_course));
			}else{
				System.out.println("N/A");
			}
		}
		input.close();
	}
	static void rank(int k, ArrayList<Student> students){
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (Student a: students){
			num.add(a.getGrades()[k]);
		}
		Collections.sort(num);
		//System.out.println(num);
		for(int i = 0; i < students.size(); i++){
			students.get(i).setRankGrades((num.indexOf(students.get(i).getGrades()[k])), k);
		}
	}

}

class Student{
	private String ID;
	private int[] grades = new int[4];
	private int rankGrades[] = new int[4];
	
	public Student(String ID, int A, int C, int M, int E){
		this.ID = ID;
		grades[0] = A;
		grades[1] = C;
		grades[2] = M;
		grades[3] = E;
	}
	
	public String getID(){
		return ID;
	}
	public int[] getGrades(){
		return grades;
	}
	
	public int[] getRankGrades(){
		return rankGrades;
	}
	public void setRankGrades(int rank, int index){
		rankGrades[index] = rank;
	}
}
