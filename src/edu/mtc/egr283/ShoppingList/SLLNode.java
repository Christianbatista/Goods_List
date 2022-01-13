package edu.mtc.egr283.ShoppingList;

public class SLLNode<T> {

	private T nodeData;
	private SLLNode<T> next;
	
	/**
	 * Default constructor
	 */
	public SLLNode() {
		this(null, null);
	}// Ending bracket of new Constructor
	
	/**
	 * @param newNodeData
	 * @param newNext
	 */
	public SLLNode(T newNodeData, SLLNode<T> newNext) {
		this.nodeData = newNodeData;
		this.next = newNext;
	}// ending bracket of new Constructor

	/**
	 * @return the nodeData
	 */
	public T getNodeData() {
		return this.nodeData;
	}// Ending bracket of method getNodeData
	
	/**
	 * @param nodeData the nodeData to set
	 */
	public void setNodeData(T newNodeData) {
		this.nodeData = newNodeData;
	}// Ending bracket of method setNodeData
	
	/**
	 * @return the next
	 */
	public SLLNode<T> getNext() {
		return this.next;
	}// Ending bracket of method getNext
	
	/**
	 * @param newNext the next to set
	 */
	public void setNext(SLLNode<T> newNext) {
		this.next = newNext;
	}
	
}// Ending bracket of class SLLNode