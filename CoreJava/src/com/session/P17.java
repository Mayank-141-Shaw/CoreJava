package com.session;

import java.util.*;
import java.io.*;
public class P17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PulsarBike bike = new PulsarBike(1, "hg678901");
		ArrayList<PulsarBike> bikes = new ArrayList<>();
		
		String filename = "res/bike.txt";
		try {
			bikes.add(bike);
			bikes.add((PulsarBike)bike.clone());
			bikes.add((PulsarBike)bike.clone());
			bikes.add((PulsarBike)bike.clone());
			bikes.add((PulsarBike)bike.clone());
			
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(bikes);
			out.close();
			file.close();
			System.out.println("Bikes added to the file");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		bikes.clear();
		// try read them again
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			bikes = (ArrayList<PulsarBike>)in.readObject();
			
			// now we got the array we will  print it all
			Iterator<PulsarBike> itr = bikes.iterator();
			while(itr.hasNext()) {
				itr.next().display();
			}
			
			in.close();
			file.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

class PulsarBike implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String bannerCode;
	public PulsarBike(int id, String bannerCode) {
		super();
		this.id = id;
		this.bannerCode = bannerCode;
	}
	
	public void display() {
		System.out.println("BikeId : "+this.id+" NumberPlate : "+this.bannerCode);
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}