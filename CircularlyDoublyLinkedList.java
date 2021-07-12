package diceGame;
/**
 * @author Justin Baraniuk
 * 
 * CircularylyDoublyLinkedList class stores generic objects.
 */

public class CircularlyDoublyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		public E getElement() { return element; }
		public Node<E> getPrev() { return prev; }
		public Node<E> getNext() { return next; }
		public void setPrev(Node<E> p) { prev = p; }
		public void setNext(Node<E> n) { next = n; }
	}
	
	private Node<E> tail = null;
	private int size = 0;
	public CircularlyDoublyLinkedList() {}
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	public E first() {
		if (isEmpty()) return null;
		return tail.getNext().getElement();
	}
	
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	public void rotate() {
		if (tail != null) 
			tail = tail.getNext();
	}
	
	public void rotateReverse() {
		if (tail != null)
			tail = tail.getPrev();
	}
	
	public void addFirst(E e) {
		if (size == 0) {
			tail = new Node<>(e, null, null);
			tail.setNext(tail);
			tail.setPrev(tail);
			size++;
		} else {
			addBetween(e, tail, tail.getNext());
		}
	}
	
	public void addBetween(E e, Node<E> p, Node<E> n) {
		Node<E> newest = new Node<>(e, p, n);
		p.setNext(newest);
		n.setPrev(newest);
		size++;
	}
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst() {
		if (isEmpty()) return null;
		Node<E> head = tail.getNext();
		if (head == tail) tail = null;
		else tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
}

	