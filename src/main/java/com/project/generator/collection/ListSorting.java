/*package com.project.generator.collection;

import java.util.*;

public class ListSorting {

	public static List<Object> sortList(List<Object> obj) {
		List<Object> sortList = new ArrayList<>();
		List<String> srtList = new ArrayList<>();
		Object temp = null;
	

			if (obj.get(0) instanceof Integer) {
				for (int i = 0; i < obj.size(); i++) {
				for (int j = i + 1; j < obj.size(); j++) {
					if ((Integer) obj.get(i) > (Integer) obj.get(j)) {
						temp = obj.get(i);
						sortList.add(i, obj.get(j));
						sortList.add(j, temp);
					}
				}
				}
			} else if (obj.get(0) instanceof String) {
				for (int i = 0; i < obj.size(); i++) {
					srtList.add((String) obj.get(i));
				}
				for (int k = 0; k < srtList.size(); k++) {
					
					for (int j = k + 1; j < srtList.size(); j++) {

						if (srtList.get(k).compareToIgnoreCase(srtList.get(j)) > 0) {
							temp = srtList.get(k);
						srtList.add(k, (String) obj.get(j));
						srtList.add(j, (String) temp);
						}
					}
				}
				
			}

	return sortList;

	}

	public static void main(String[] args) {
      List<Integer> intList=new ArrayList<>();
      
      intList.add(1);
      intList.add(5);
      intList.add(3);
      intList.add(9);
		sortList((List<Object>)intList);
		/*int[] array = { 5, 2, 8, 1, 4 };
		int temp = 0;
		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}

			}

		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
     Stack<String> stk=new Stack<>();
     //stk.a
	}
}
class Node {
	public int data;
	public Node next;
	
	public Node(int data) {
		this.data=data;
	}
	
}

class LinkeList{
	
	Node first;
	
	public LinkeList() {
		first=null;
	}
	public void insert(int value) {
		Node node=new Node(value);
		node.next=first;
		first=node;
	}
	
	public Node delete() {
		
		Node temp=first;
		first=first.next;
		
		return temp;
	}
}

class stack{
	
	int size;
	int[] stkarray;
	int top;
	
	public stack(int size) {
		this.size=size;
		stkarray=new int[size];
		top=-1;
	}
	
	public void push(int value) {
		stkarray[++top]=value;
	}
	public int pop() {
		return stkarray[top--];
		
	}
}



class quqe{
	
	int[] quArr;
	int size;
	int fornt;
	int rear;
  int number;
	public quqe(int size) {
		this.size=size;
		quArr=new int[size];
		rear=0;
		fornt=0;
	}
	public void insert(int value) {
		
		if(rear==size)
		  rear=0;
		quArr[rear++]=value;
		number++;
	}
	public int delete() {
		int deletionval=quArr[fornt++];
		if(fornt==size)
			fornt=0;
		number--;
		return deletionval;
		}
}

class hashMap<K,V>{
	private Entry<K,V>[] table;
	private int capacity=4;
	static class Entry<K,V> {
		K key;
		V Value;
		Entry<K,V> next;
		
		public Entry(K key,V value,Entry<K,V> next) {
			this.key=key;
			this.Value=value;
			this.next=next;
		}
	}	
	
	public hashMap() {
		table=new Entry[capacity];
	}
	private int hash(K key) {
		
		return Math.abs(key.hashCode())%capacity;
	}
	public void put(K neykey,V data) {
		if(neykey==null)
		   return;
		 int hash=hash(neykey);
		 Entry<K,V> neEntry=new Entry(neykey, data, null);
		 if(table[hash]==null) {
			 table[hash]=neEntry;
		 }
		 else {
			 Entry<K,V> previous=null;
			 Entry<K,V> current=table[hash];
			 while(current!=null) {
			 if(current.key.equals(neykey))
			 {
				 if(previous==null) {
					 neEntry.next=current.next;
					 table[hash]=neEntry;
					 return;
				 }
				 else {
					 neEntry.next=current.next;
					 previous.next=neEntry;
				 }
				
			 }
			 previous=current;
			 current=current.next;
			 }
			 previous.next=neEntry;
		 }
	}
	
	
}*/