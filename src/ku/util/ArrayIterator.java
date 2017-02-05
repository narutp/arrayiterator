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

	/**
	 * A constructor that initialize a new array iterator
	 * 
	 * @param array
	 *            is the array that want to iterate
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.index = 0;
	}

	/**
	 * Return true if the rest of the array element have non-null element
	 * false if there not have non-null element anymore 
	 * @return 
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
		T temp = array[index];
		index++;
		while (hasNext() && array[index] == null) {
			index++;
		}
		return temp;
	}
}
