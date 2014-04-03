package org.macalester.edu.comp124.lists;

/**
 * An unfinished implementation of a basic doubly-linked list.
 *
 * Note that the head and the tail contain "sentinel" nodes without values.
 * This makes the edge cases of the algorithm easier because the list always has a discrete head and tail.
 *
 * @author shilad
 * @param <E>
 */
public class MyLinkedList<E> {
	private MyLinkedNode<E> head;
	private MyLinkedNode<E> tail;
    private MyLinkedNode<E> temp;
	private int numElements = 0;

    /**
     * Creates a new empty linked list.
     */
	public MyLinkedList() {
		head = new MyLinkedNode<E>(null);
		tail = new MyLinkedNode<E>(null);
		clear();
	}

    /**
     * Returns the element at position index.
     * @param index
     * @return
     */
	public E get(int index) {
    temp= head;
		for(int i=0; i<=index; i++){
            temp=temp.getNext();

        }return temp.getValue();
	}

    /**
     * Adds a new element to the end of the list:
     *
     * @param elem
     */
	public void add(E elem) {
        MyLinkedNode<E> plus= new MyLinkedNode<E>(elem);
        if(numElements==0){
            head.setNext(plus);
            plus.setNext(tail);
            plus.setPrev(tail);
            tail.setPrev(plus);
            numElements++;
        }else{

        tail.getPrev().setNext(plus);
        plus.setNext(tail);
        plus.setPrev(tail.getPrev());
        tail.setPrev(plus);
        numElements++;
        }
	}

    /**
     * Inserts a new element at the specified index.
     *
     * @param elem
     */
	public void add(int i, E elem) {
        MyLinkedNode<E> plus= new MyLinkedNode<E>(elem);
        temp= head;
        for(int a=0; a<=i; a++){
            temp=temp.getNext();
        }
        plus.setNext(temp);
        plus.setPrev(temp.getPrev());
        plus.getPrev().setNext(plus);
        plus.getNext().setPrev(plus);
        numElements++;
	}

    /**
     * Returns the current size of the list.
     * @return
     */
	public int size() {
		return numElements;
	}

    /**
     * Clears the contents of the list.
     */
	public void clear() {
		// set head's next to the tail
		head.setNext(tail);
		head.setPrev(null);
		
		// set tails prev to the head
		tail.setPrev(head);
		tail.setNext(null);
		numElements = 0;
	}


    /**
     * These methods are only used by the unit tests.
     * They are intentionally not public.
     * @return
     */
    MyLinkedNode getHead() { return head; }
    MyLinkedNode getTail() { return tail; }
}
