package edu.mtc.egr283.ShoppingList;

public class SLL<E> {

	private int length;
	private SLLNode<E> head;
	private SLLNode<E> tail;

	public static final String COLON_SPACE = ": ";
	public static final String NEW_LINE = "\n ";
	
	public SLL( ) {
		this.length = 0;
		this.tail = new SLLNode<E>();	
		this.head = new SLLNode<E>(null,tail);
	}// Ending bracket of constructor
	
	public int size() {
		return this.length;
	}// Ending bracket for method size
	
	public E getDataAtPosition(int position) {
		return (this.find(position)).getNodeData();
	}// Ending bracket of method getDataAtPosition
	
	public void setDataAtPosition(int position, E dataAtPosition) {
		 (this.find(position)).setNodeData(dataAtPosition);
	}// Ending bracket of method set
	
	public void addAtHead(E newNodeData) {
		SLLNode<E> newNode = new SLLNode<E>(newNodeData,null);
		this.addAfter(this.head, newNode);
	}// Ending bracket of method addAtHead
	
	public void insertAtEnd(E newNodeData) {
		SLLNode<E> newNode = new SLLNode<E>(newNodeData,null);   
        if(this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        }
        	this.addAfter(this.head, newNode);
    }// Ending bracket of method insertAtHead
		
	public void add(E newNodeData, int position) {
		
		SLLNode<E> newNode = new SLLNode<E>(newNodeData, null);
		SLLNode<E> cursor = this.head;
		
		if(position > 0) {
			cursor = this.find(position -1);			
		}// Ending bracket of if
		
		this.addAfter(cursor, newNode);
		
	}// Ending bracket of method add
	
	public E remove(E targetData) {
		return this.remove(this.findIndex(targetData));
	}//Ending bracket of remove(E)
	
	public int findDataPosition(E targetData) {
		return this.findIndex(targetData);
	}//Ending bracket of remove(E)
	
	public E remove(int position) {
		
		SLLNode<E> cursor = this.head;
		if(position > 0) {
			cursor = this.find(position -1);
		}// Ending bracket of remove(int)
		
		SLLNode<E> targetNode = cursor.getNext();
		cursor.setNext(targetNode.getNext());
		--this.length;
		
	E rv = targetNode.getNodeData(); // will return the data
	targetNode.setNext(null);// Null it out so it eligible to get pick up by garbage collector
	targetNode.setNodeData(null);// Null it out so it eligible to get pick up by garbage collector
	
	return rv;	
	}// Ending bracket of method remove(int)
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		SLLNode<E> cursor = this.head.getNext();
		int index = 0;
		while(cursor != this.tail) {
			sb.append(index + SLL.COLON_SPACE);
			sb.append(cursor.getNodeData().toString());
			sb.append(SLL.NEW_LINE);
			cursor = cursor.getNext();
			++index;
		//	System.out.println(index);
		}// Ending bracket of while loop
		return sb.toString();
	}// Ending bracket of method toString
		
	private SLLNode<E> find(int position){
		SLLNode<E> cursor = this.head.getNext();
		int index =0;
		
		while((cursor != this.tail) && (index != position)){
			cursor = cursor.getNext();
			++index;
		}// Ending bracket of while loop
		return cursor;
	}// Ending bracket of method find(int)
	
	public SLLNode<E> find(E targetData){
		SLLNode<E> rv = null;
		
		SLLNode<E> cursor = this.head.getNext();
		while(cursor != tail) {
			if(cursor.getNodeData().equals(targetData)) {
				rv = cursor;
				break;
			}else {
				cursor = cursor.getNext();
			}// Ending bracket of if
		}// Ending bracket of while loop
		
		return rv;
	}// Ending bracket of find(E)
	
	private int findIndex(E targetData) {
		int rv = 0;
		
		SLLNode<E> cursor = this.head.getNext();
		while((cursor != this.tail) &&
			 (!(cursor.getNodeData().equals(targetData)))) { // Continue to loop as long as we have not made it to the tail and the. first thing you are checking are you at the tail. then i have not found the target data 
			cursor = cursor.getNext();
			++rv;
		}// Ending bracket of while loop
		
		if(rv == this.size()) {
			rv = -1; // standard in computer science if you can't find something return -1
		}// Ending bracket of if
		return rv;
	}// Ending bracket of findIndex
	
	private void addAfter(SLLNode<E> currentNode, SLLNode<E> newNode) {
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		++this.length;
	}// Ending bracket of method addAfter
	
	public void swap(SLL<E> list,int sub1, int sub2) {
		E temp;
		temp = list.getDataAtPosition(sub2);
		list.setDataAtPosition(sub2, this.getDataAtPosition(sub1));
		list.setDataAtPosition(sub1, temp);
		
	}// Ending bracket of method swap
	
}// Ending bracket of class SLL<E>