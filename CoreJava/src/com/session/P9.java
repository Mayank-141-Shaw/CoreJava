package com.session;

public class P9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList list = new DoubleLinkedList();
		list.add(10);
		list.addToEnd(20);
		list.addFront(5);
		list.addToEnd(30);
		list.display();
		
		list.removeFront();
		list.display();
		
		list.addFront(50);
		list.addToEnd(87);
		list.display();
	}

}

class Node{
	int data;
	Node prev;
	Node next;
	
	Node(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
}

class DoubleLinkedList{
	Node first;
	Node last;
	
	DoubleLinkedList(){
		this.first = null;
		this.last = null;
	}
	
	void add(int data) {
		
		if(this.first==null) {
			Node node = new Node(data);
			this.first = node;
			this.last = node;
		}
		else {
			// add to the end
			this.addToEnd(data);
		}
	}
	
	void addToEnd(int data) {
		Node node = new Node(data);
		node.prev = this.last;
		this.last.next = node;
		this.last = node;
	}
	
	void addFront(int data) {
		Node node = new Node(data);
		node.next = this.first;
		this.first.prev = node;
		this.first = node;
	}
	
	void removeFront() {
		if(this.first == null) {
			System.out.println("List empty");
		}
		else if(this.first == this.last) {
			this.first = null;
			this.last = null;
		}
		else {
			Node newFront = this.first.next;
			newFront.prev = null;
			this.first = newFront;	
		}
		
	}
	
	void removeEnd() {
		if(this.last==null) {
			System.out.println("List Empty");
		}
		else if(this.first == this.last) {
			this.first = null;
			this.last = null;
		}
		else {
			Node newLast = this.last.prev;
			newLast.next = null;
			this.last = newLast;
		}
	}
	
	int listLength() {
		int len = 0;
		Node temp = this.first;
		
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}
	
	void removeValueAtPosition(int pos) {
		if(pos > this.listLength()) {
			System.out.println("No such position exists in this list");
		}else {
			// loop till that position
			Node temp = this.first;
			for(int i=1; i<pos; i++) {
				temp = temp.next;
			}
			
			// after looping 
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			temp = null;
		}
	}
	
	void display() {
		// display the entire list in order
		if(this.first == null) {
			System.out.println("List is empty");
		}
		else {
			Node temp = this.first;
			while(temp!=null) {
				System.out.print(temp.data+ " ");
				temp = temp.next;
			}
			System.out.println();
		}
		
	}
}



