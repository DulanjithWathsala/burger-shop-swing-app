/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import Model.Customer;

/**
 *
 * @author DULA
 */
public class List {
    private Node first;
	private int listSize = 0;
	
	public boolean isEmpty(){
		return first == null;
	}
	public void add(Customer customer){
		Node temp = new Node(customer);
		if (isEmpty()){
			first = temp;
		} else{
			Node lastNode = first;
			while (lastNode.next != null){
				lastNode = lastNode.next;
			}
			lastNode.next = temp;
		}
		listSize++;
	}
	public void add(int index, Customer customer){
		Node n1 = new Node(customer);
		if (index >= 0 && index <= listSize){
			if (index == 0){
				n1.next = first;
				first = n1;
			} else{
				int count = 0;
				Node temp = first;
				while (count < index - 1){
					temp = temp.next;
					count++;
				}
				n1.next = temp.next;
				temp.next = n1;
			}
		}
		listSize++;
	}
	public void removeFirst(){
		if(first!=null){
			first=first.next;
		}
		listSize--;
	}
	public void remove(int index){
		if (index >= 0 && index < listSize){
			if (index == 0){
				first = first.next;
				listSize--;
			} else{
				int count = 0;
				Node temp = first;
				while (count < index - 1){
					temp = temp.next;
					count++;
				}
				temp.next = temp.next.next;
				listSize--;
			}
		}
	}
	public int size(){
		return listSize;
	}
	public void clear(){
		first = null;
		listSize = 0;
	}
	public Customer[] toArray(){
		Customer[] ar = new Customer[listSize];
		Node temp = first;
		for (int i = 0; i < listSize; i++){
			ar[i] = temp.customer;
			temp = temp.next;
		}
		return ar;
	}
	public Customer get(int index){
		if (index >= 0 && index < listSize){
			int count = 0;
			Node temp = first;
			while (count != index){
				temp =  temp.next;
				count++;
			}
			return temp.customer;
		}
		return null;	
	}
	public Customer get(String customerId){	
		Node temp = first;
		for (int i = 0; i < listSize; i++){
			if (temp.customer.getCustomerId().equals(customerId)){
				return temp.customer;
			}
			temp = temp.next;
		}
		return null;
	}
	public int indexOf(String customerId){
		Node temp = first;
		for (int i = 0; i < listSize; i++){
			if (temp.customer.getCustomerId().equals(customerId)){
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}
	
	//-------------------Inner Classes------------------
	class Node{
		private Customer customer;
		private Node next;
		
		Node(Customer customer){
			this.customer = customer;
		}
	}
	//---------------End of Inner Classes---------------
}
