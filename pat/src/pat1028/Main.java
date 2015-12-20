package pat1028;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {

	static int C;
	public static void main(String[] args) {
		Main ma = new Main();
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		C = input.nextInt();
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < N; i++){
			int a = input.nextInt();
			String b = input.next();
			int c = input.nextInt();
			students.add(ma.new Student(a, b, c));
		}
		Collections.sort(students);
		for (Student s: students){
			String str = String.format("%06d", s.ID);
			System.out.print(str + " " + s.name + " " + s.grade + "\n");
		}

	}
	
	class Student implements Comparable<Object>{
		private int ID;
		private String name;
		private int grade;
		
		public Student(){
			
		}
		public Student(int ID, String name, int grade){
			this.ID = ID;
			this.name = name;
			this.grade = grade;
		}
		
		@Override
		public int compareTo(Object o){
			Student s = (Student)o;
			if (C == 1)
				return this.ID - s.ID; 
			else if (C == 2){
				int res = this.name.compareTo(s.name);
				return res == 0 ? this.ID - s.ID: res;
			}else if (C == 3){
				int res = this.grade - s.grade;
				return res == 0 ? this.ID - s.ID: res;
			}else
				return 0;
			
		}
	}
	
}

