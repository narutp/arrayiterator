package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Narut Poovorakit
 * @version 05.02.2016
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator<T> {

	/** array that want to iterate */
	private T[] array;
	
	/** a number position of the array */
	private int index;
	
	/** a last number position of the array that been return */
	private int lastReturnedIndex;

	/**
	 * A constructor that initialize a new array iterator
	 * 
	 * @param array
	 *            is the array that want to iterate
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.index = 0;
		this.lastReturnedIndex = -1;
	}

	/**
	 * Return true if the rest of the array element have non-null element
	 * false if there not have non-null element anymore 
	 * @return Return true if the rest of the array element have non-null element
	 * false if there not have non-null element anymore 
	 */
	@Override
	public boolean hasNext() {
		for (int i = index; i < array.length; i++) {
			if (array[i] != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the next non-null element from the array
	 * 
	 * @return the next non-null element from the array
	 * @throws NoSuchElementException
	 *             if there are no elements
	 */
	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		while (array[index] == null) {
			index++;
		}
		T temp = array[index];
		lastReturnedIndex = index;
		index++;
		while (hasNext() && array[index] == null) {
			index++;
		}
		return temp;
	}
	
	/**
	 * Remove the last return element to null but if it never been return before it will throw
	 * IllegalStateException 
	 */
	public void remove() {
		if (lastReturnedIndex == -1 || array[lastReturnedIndex] == null) {
			throw new IllegalStateException();
		}
		array[lastReturnedIndex] = null;
	}
}
