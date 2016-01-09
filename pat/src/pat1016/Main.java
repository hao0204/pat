package pat1016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int[] toll = new int[24];
		for (int i = 0; i < 24; ++i)
			toll[i] = input.nextInt();
		int N = input.nextInt();
		input.nextLine();
		ArrayList<Record> records = new ArrayList<Record>();
		for (int i = 0; i < N; ++i){
			String[] temp = input.nextLine().split(" ");
			records.add(new Record(temp[0], temp[1], temp[2]));
		}
		input.close();
		Collections.sort(records, new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2){
				Record r1 = (Record) o1;
				Record r2 = (Record) o2;
				return r1.getName().compareTo(r2.getName());
			}
		});
		ArrayList<Person> people = new ArrayList<Person>();
		ArrayList<Record> data = new ArrayList<Record>();
		while(!records.isEmpty()){
			data = findSameName(records);
			dealRecords(data, people, toll);
		}
		for (int i = 0; i < people.size(); ++i){
			Person p = people.get(i);
			ArrayList<Valid> v = p.getRecords();
			if (v.size() == 0)
				continue;
			System.out.println(p.getName() + " " + p.getMm());
			for (int j = 0; j < v.size(); ++j)
				System.out.println(v.get(j).getBeginning() +  " " + v.get(j).getEnding()
						+ " " + v.get(j).getLastingTime() + " " 
						+ dealMoney(v.get(j).getCharge()));
			System.out.println("Total amount: " + dealMoney(p.getTotal()));
		}
	}
	
	static String dealMoney(int money){
		double a = money / 100.0;
		String s = String.format("%.2f", a);
		return "$" + s;
		
	}
	
	static void dealRecords(ArrayList<Record> data, ArrayList<Person> people, int[] toll){
		Collections.sort(data, new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2){
				Record r1 = (Record) o1;
				Record r2 = (Record) o2;
				return r1.getTime().compareTo(r2.getTime());
			}
		});
		Person p = new Person();
		p.setName(data.get(0).getName());
		p.setMm(data.get(0).getTime().substring(0, 2));
		p.setTotal(0);
		ArrayList<Valid> vs = new ArrayList<Valid>();
		for (int i = 0; i < data.size() - 1; ++i){
			if (data.get(i).getType().equals("on-line") 
					&& data.get(i+1).getType().equals("off-line")){
				Valid v = new Valid();
				Record r1 = data.get(i);
				Record r2 = data.get(i+1);
				v.setBeginning(r1.getTime().substring(3));
				v.setEnding(r2.getTime().substring(3));
				int[] dd = {Integer.valueOf(r1.getTime().substring(3, 5)), 
						Integer.valueOf(r2.getTime().substring(3, 5))};
				int[] hh = {Integer.valueOf(r1.getTime().substring(6, 8)), 
						Integer.valueOf(r2.getTime().substring(6, 8))};
				int[] mm = {Integer.valueOf(r1.getTime().substring(9)),
						Integer.valueOf(r2.getTime().substring(9))};
				int sum = 0, j = 0;
				for (;;++j){
					if (dd[0] == dd[1] && hh[0] == hh[1] && mm[0] == mm[1])
						break;
					sum += toll[hh[0]];
					++mm[0];
					if (mm[0] == 60){
						mm[0] = 0;
						++hh[0];
					}
					if (hh[0] == 24){
						hh[0] = 0;
						++dd[0];
					}
				}
				v.setLastingTime(j);
				v.setCharge(sum);
				vs.add(v);
				p.setTotal(p.getTotal() + sum);
			}
		}
		p.setRecords(vs);
		people.add(p);
	}
	
	static ArrayList<Record> findSameName(ArrayList<Record> records){
		ArrayList<Record> data = new ArrayList<Record>();
		Record r = records.get(0);
		data.add(r);
		int i = 0; 
		for (i = 1; i < records.size(); ++i){
			if (r.getName().equals(records.get(i).getName()))
				data.add(records.get(i));
			else
				break;
		}
		for (int j = 0; j < i; ++j)
			records.remove(0);
		return data;
	}
}

class Person {
	
	private String name;
	private String mm;
	private ArrayList<Valid> records;
	private int total;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public ArrayList<Valid> getRecords() {
		return records;
	}
	public void setRecords(ArrayList<Valid> records) {
		this.records = records;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}

class Valid {
	
	private String beginning;
	private String ending;
	private int lastingTime;
	private int charge;
	
	public String getBeginning() {
		return beginning;
	}
	public void setBeginning(String beginning) {
		this.beginning = beginning;
	}
	public String getEnding() {
		return ending;
	}
	public void setEnding(String ending) {
		this.ending = ending;
	}
	public int getLastingTime() {
		return lastingTime;
	}
	public void setLastingTime(int lastingTime) {
		this.lastingTime = lastingTime;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
}

class Record{
	
	private String name;
	private String time;
	private String type;
	
	Record(String name, String time, String type){
		this.name = name;
		this.time = time;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}