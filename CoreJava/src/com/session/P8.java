package com.session;

import java.util.*;

public class P8 {
	
	static boolean filterTrainer(Trainer t) {
		if(t.course.equalsIgnoreCase("JAVA") && t.salary>20000) return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Trainer> tr = new ArrayList<Trainer>();
		tr.add(new Trainer(1, "Kailash", "Python", 25000));
		tr.add(new Trainer(2, "Kiran", "JAVA", 21000));
		tr.add(new Trainer(3, "Rohan", "C++", 35000));
		tr.add(new Trainer(4, "Yash", "JAVA", 45000));
		tr.add(new Trainer(5, "Indrajit", "JAVA", 18000));
		
		List<Trainer> filteredTr = new ArrayList<Trainer>();
		
		// this way wont throw concurrentModification error
		// we are looping the iterator object and removing value through itr which
		// indirectly affect list
		// those are two different objects so it wont throw error
		// its throws error while using forEach
		for(Iterator<Trainer> itr = tr.iterator(); itr.hasNext();) {
			Trainer trainer = itr.next();
			if(filterTrainer(trainer)) {
				filteredTr.add(trainer);
				itr.remove();
			}
		}
		
		
		// display filtered list using iterator
		Iterator<Trainer> iterator = filteredTr.iterator();
		System.out.println("Filtered List : ");
		
		while(iterator.hasNext()) {
			iterator.next().display();
		}
	}

}

class Trainer{
	int tr_id;
	String name;
	String course;
	int salary;
	public Trainer(int tr_id, String name, String course, int salary) {
		this.tr_id = tr_id;
		this.name = name;
		this.course = course;
		this.salary = salary;
	};
	
	void display() {
		System.out.println("ID : "+this.tr_id+" Name : "+this.name+" Course : "+this.course+" Salary : "+this.salary);
	}
	
}