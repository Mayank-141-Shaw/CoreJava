package com.session;

import java.util.*;
public class P12 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Movies1> movies = new ArrayList<Movies1>();
		movies.add(new Movies1(4, "Far Cry", 2017));
		movies.add(new Movies1(4, "BlackJack", 2010));
		movies.add(new Movies1(5, "Interstellar", 2014));
		int choice;
		while(true) {
			System.out.println("A switch driven Movie viewer\n"+
					"1. Sort by ratings\r\n"
					+ "2. Sort by name\r\n"
					+ "3. Sort by year\r\n"
					+ "4. Sort by ratings in Reverse\r\n"
					+ "5. Sort by name in Reverse\r\n"
					+ "6. Sort by year in Reverse\r\n"
					+ "7. EXIT");
			choice = sc.nextInt();
			switch(choice){
				case 1:
					// sort by ratings asc
					Collections.sort(movies, Movies1.MovRatingComparator);
					System.out.println("Sorted by rating");
					movies.forEach((movie)->System.out.println(movie.display()));					
					break;
				case 2:
					//sort by name
					Collections.sort(movies, Movies1.MovNameComparator);
					System.out.println("Sorted by name");
					movies.forEach((movie)->System.out.println(movie.display()));					
					break;
				case 3:
					//sort by year
					Collections.sort(movies, Movies1.MovYearComparator);
					System.out.println("Sorted by year");
					movies.forEach((movie)->System.out.println(movie.display()));					
					break;
				case 4:
					//sort by ratings in reverse
					Collections.sort(movies, Movies1.MovRatingComparatorRev);
					System.out.println("Sorted by rating in reverse");
					movies.forEach((movie)->System.out.println(movie.display()));					
					break;
				case 5:
					// sort by name in reverse
					Collections.sort(movies, Movies1.MovNameComparatorRev);
					System.out.println("Sorted by name in reverse");
					movies.forEach((movie)->System.out.println(movie.display()));					
					break;
				case 6:
					// sort by year in reverse
					Collections.sort(movies, Movies1.MovYearComparatorRev);
					System.out.println("Sorted by year in reverse");
					movies.forEach((movie)->System.out.println(movie.display()));					
					break;
				case 7:
					System.out.println("Thanking for using MovieBot");
					System.exit(0);
					break;
				default:
					System.out.println("Wrong choice");
			}
			
		}

	}

}

class Movies1{
	private int rating;
	private String name;
	private int year;
	
	public Movies1(int rating, String name, int year) {
		this.setRating(rating);
		this.setName(name);
		this.setYear(year);
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void watchMovie() {
		System.out.println("Watching Now : "+this.name);
	}
	
	public String display() {
		return "Name :"+this.name+" Rating : "+this.rating+" Year : "+this.year;
	}
	
	public static Comparator<Movies1> MovNameComparator = new Comparator<Movies1>() {
        
	      public int compare(Movies1 s1, Movies1 s2)
	              {
	  
	                  String MovieName1 = s1.getName().toUpperCase();
	                  String MovieName2 = s2.getName().toUpperCase();
	  
	                  // ascending order
	                  return MovieName1.compareTo(MovieName2);
	  
	                  // descending order
	                  // return
	                  // StudentName2.compareTo(StudentName1);
	              }
	          };
	          public static Comparator<Movies1> MovNameComparatorRev = new Comparator<Movies1>() {
	              
	    	      public int compare(Movies1 s1, Movies1 s2)
	    	              {
	    	  
	    	                  String MovieName1 = s1.getName().toUpperCase();
	    	                  String MovieName2 = s2.getName().toUpperCase();
	    	  
	    	                  // ascending order
	    	                  return MovieName2.compareTo(MovieName1);
	    	  
	    	                  // descending order
	    	                  // return
	    	                  // StudentName2.compareTo(StudentName1);
	    	              }
	    	          };
	          
	 public static Comparator<Movies1> MovRatingComparator = new Comparator<Movies1>() {
	       public int compare(Movies1 s1, Movies1 s2)
	              {
	  
	                  int r1 = s1.getRating();
	                  int r2 = s2.getRating();
	  
	                  // For ascending order
	                  return r1 - r2;
	  
	                  // For descending order
	                  // rollno2-rollno1;
	              }
	          };
	   public static Comparator<Movies1> MovRatingComparatorRev = new Comparator<Movies1>() {
	   	       public int compare(Movies1 s1, Movies1 s2)
	   	              {
	   	  
	   	                  int r1 = s1.getRating();
	   	                  int r2 = s2.getRating();
	   	  
	   	                  // For ascending order
	   	                  return r2 - r1;
	   	  
	   	                  // For descending order
	   	                  // rollno2-rollno1;
	   	              }
	   	          };
	  public static Comparator<Movies1> MovYearComparator = new Comparator<Movies1>() {
	  	       public int compare(Movies1 s1, Movies1 s2)
	  	              {
	  	  
	  	                  int y1 = s1.getYear();
	  	                  int y2 = s2.getYear();
	  	  
	  	                  // For ascending order
	  	                  return y1 - y2;
	  	  
	  	                  // For descending order
	  	                  // rollno2-rollno1;
	  	              }
	  	          };	          

	  	  	  public static Comparator<Movies1> MovYearComparatorRev = new Comparator<Movies1>() {
		  	       public int compare(Movies1 s1, Movies1 s2)
		  	              {
		  	  
		  	                  int y1 = s1.getYear();
		  	                  int y2 = s2.getYear();
		  	  
		  	                  // For ascending order
		  	                  return y2 - y1;
		  	  
		  	                  // For descending order
		  	                  // rollno2-rollno1;
		  	              }
		  	          };	          
	  
}
