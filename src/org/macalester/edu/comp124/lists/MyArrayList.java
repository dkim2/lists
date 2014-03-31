package org.macalester.edu.comp124.lists;


import java.util.ArrayList;

public class MyArrayList<E> {

	private E elements[];
	private int currentSize;
    private E temp[];


	public MyArrayList() {

	}
	
	/**
	 * Clears the contents of the array.
	 */
	public void clear() {
		elements = newArrayOfE(4);
		currentSize = 0;
	}
	
	/**
	 * Returns the current size of the list.
	 * @return
	 */
	public int size() {
		return currentSize;
	}
	
	/**
	 * Returns the element at position index.
	 * @param index
	 * @return
	 */
	public E get(int index) {
      return elements[index];
	}
	
	/**
	 * Adds a new element to the end of the list:
	 * 
	 * If the array is full, expand the array.
	 * Add the element to the first unused position in the array.
	 * Update the size of the array.
	 * 
	 * @param elem
	 */
	public void add(E elem) {


        temp=newArrayOfE(currentSize+1);
     if(currentSize<elements.length){


        elements[currentSize]=elem;
         currentSize++;
        }else{
        int i=0;
        while(i<elements.length){
            temp[i]=elements[i];
            i++;
        }currentSize++;
        elements= newArrayOfE(currentSize);
         i--; //i becomes one larger than temp can hold.
        while(i>=0){
            elements[i]=temp[i];
            i--;

        } elements[currentSize-1]=elem;
    }


    }
	/**
	 * Inserts a new element at the specified index.
	 * 
	 * If the array is full, expand the array.
	 * Slide the elements of the array starting with index over.
	 * Place the new element in the correct spot of the array.
	 * 
	 * Update the size of the array.
	 * 
	 * @param elem
	 */
    //First checks to see if array is full, if so makes a new array element with same stored values+ one extra space.
    //Then insert at specified space
	public void add(int index, E elem) {
        temp=newArrayOfE(currentSize);
        int holder=currentSize;
        if(currentSize==elements.length){
            int i=0;
            while(i<elements.length){
                temp[i]=elements[i];
                i++;
            }
            elements= newArrayOfE(currentSize + 1);
            while(i>=0){
                elements[i]=temp[i];
                i--;

            }

        }if(elements[index]!=null){

            while(holder>index){
                elements[holder]=elements[holder-1];
                        holder--;

            }elements[index]=elem;
            currentSize++;




        }
    }

	
	/**
	 * Doubles the size of the array, copies the old elements
	 * into the new array, and updates elements to point to the
	 * new array.
	 * 
	 * This will be useful for both versions of add().
     * Hint: use newArrayOfE!
	 */
	private void expandSize() {
        int i=elements.length;
        elements=newArrayOfE(i*2);
	}
	
	/**
	 * Due to some crazy Java constraints, we can't simply create a
	 * new array of elements of class E.  We need to create an array
	 * of class Object and then cast the array to E.
	 * @param capacity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private E[] newArrayOfE(int capacity) {
		return (E[]) (E[])new Object[capacity];
	}
}
