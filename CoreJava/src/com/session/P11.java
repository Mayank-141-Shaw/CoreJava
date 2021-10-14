package com.session;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class P11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Employee1> employees = new HashMap<Integer, Employee1>();
		employees.put(1, new Employee1(1, "Jacob", 10000));
		employees.put(11, new Employee1(11, "John", 18000));
		employees.put(4, new Employee1(4, "Sam", 20000));
		employees.put(6, new Employee1(6, "Mayank", 30000));
		employees.put(3, new Employee1(3, "Harris", 16000));
		employees.put(2, new Employee1(2, "Sarah", 20000));
		employees.put(8, new Employee1(8, "Chanel", 20000));
		employees.put(12, new Employee1(12, "Colin", 12000));
		employees.put(3, new Employee1(3, "Morris", 21000));
		employees.put(5, new Employee1(5, "Farris", 19000));
		
		System.out.println("Before sorting");
		employees.forEach((k,v)-> System.out.println(k+" "+v.display()));
		
		System.out.println("After sorting");
		Map<Integer, Employee1> sortedMap = new TreeMap<Integer, Employee1>(employees);
		sortedMap.forEach((k,v)-> System.out.println(k+" "+v.display()));
		
		
		Iterator<Map.Entry<Integer, Employee1>> itr = sortedMap.entrySet().iterator();
		
		Map<Integer, Employee1> newMap = new TreeMap<Integer, Employee1>();
		System.out.println("All employees having salary more than 15000");
		while(itr.hasNext()) {
			Map.Entry<Integer, Employee1> item = itr.next();
			if(item.getValue().esal < 15000) {
				itr.remove();
			}else {
				newMap.put(item.getKey(), item.getValue());
				System.out.println(item.getValue().display());
			}
		}
		
		
		
		
	}

}

class Employee1{
	int eid;
	String ename;
	int esal;
	public Employee1(int eid, String ename, int esal) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	
	String display() {
		return "ID : "+this.eid+" Name : "+this.ename+" Salary : "+this.esal;
	}
	
}
