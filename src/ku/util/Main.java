package ku.util;

/**
 * Run the program, create ArrayIterator
 * @author Narut Poovorakit
 * @version 05.02.2016
 */
public class Main {
	public static void main(String[] args) {
		String[] fruit = { "Apple", null, null, "Banana" };
		ArrayIterator<String> it = new ArrayIterator<String>(fruit);
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		
		Object[] array = new Object[1];
		ArrayIterator it2 = new ArrayIterator(array);
		System.out.println(it2.hasNext());
		System.out.println(it2.next());
	}
}
