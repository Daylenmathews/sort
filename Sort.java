import java.util.Comparator;

/**
 * Class for sorting lists that implement the IndexedUnsortedList interface,
 * using ordering defined by class of objects in list or a Comparator.
 * As written uses Mergesort algorithm.
 *
 * @author CS221
 */
public class Sort
{	
	/**
	 * Returns a new list that implements the IndexedUnsortedList interface. 
	 * As configured, uses WrappedDLL. Must be changed if using 
	 * your own IUDoubleLinkedList class. 
	 * 
	 * @return a new list that implements the IndexedUnsortedList interface
	 */
	private static <T> IndexedUnsortedList<T> newList() 
	{
		return new WrappedDLL<T>(); //TODO: replace with your IUDoubleLinkedList for extra-credit
	}
	
	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @see IndexedUnsortedList 
	 */
	public static <T extends Comparable<T>> void sort(IndexedUnsortedList<T> list) 
	{
		mergesort(list);
	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using given Comparator.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 * @see IndexedUnsortedList 
	 */
	public static <T> void sort(IndexedUnsortedList <T> list, Comparator<T> c) 
	{
		mergesort(list, c);
	}
	
	/**
	 * Mergesort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface, 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 */
	private static <T extends Comparable<T>> void mergesort(IndexedUnsortedList<T> list)
	{
		// TODO: Implement recursive mergesort algorithm
		if (list.size() <=1){
			return; //base case sorted
		} 
		
		IndexedUnsortedList<T> left = newList();
		IndexedUnsortedList<T> right = newList();

		int middle = list.size() / 2;
		for (int i = 0; i< middle; i++){
			left.add(list.removeFirst());
		}
		while (!list.isEmpty()){
			right.add(list.removeFirst());
		}

		mergesort(left);
		mergesort(right);
		merge(list, left, right);
 
	}
		
	/**
	 * Mergesort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface,
	 * using the given Comparator.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 */
	private static <T> void mergesort(IndexedUnsortedList<T> list, Comparator<T> c)
	{
		// TODO: Implement recursive mergesort algorithm using Comparator
		if (list.size() <= 1) {
			return; //base case sorted
		}

		IndexedUnsortedList<T> left = newList();
		IndexedUnsortedList<T> right = newList();

		int middle = list.size() / 2;
		for (int i = 0; i < middle; i++) {
			left.add(list.removeFirst());
		}
		while (!list.isEmpty()) {
			right.add(list.removeFirst());
		}

		mergesort(left, c);
		mergesort(right, c);
		merge(list, left, right, c);
	}

	private static <T extends Comparable<T>> void merge(
			IndexedUnsortedList<T> result, 
			IndexedUnsortedList<T> left, 
			IndexedUnsortedList<T> right) 
	{
		while (!left.isEmpty() && !right.isEmpty()) {
			if (left.first().compareTo(right.first()) <= 0) {
				result.add(left.removeFirst());
			} else {
				result.add(right.removeFirst());
			}
		}
		while (!left.isEmpty()) {
			result.add(left.removeFirst());
		}
		while (!right.isEmpty()) {
			result.add(right.removeFirst());
		}
	}
	
	private static <T> void merge(
			IndexedUnsortedList<T> result, 
			IndexedUnsortedList<T> left, 
			IndexedUnsortedList<T> right, 
			Comparator<T> c) 
	{
		while (!left.isEmpty() && !right.isEmpty()) {
			if (c.compare(left.first(), right.first()) <= 0) {
				result.add(left.removeFirst());
			} else {
				result.add(right.removeFirst());
			}
		}
		while (!left.isEmpty()) {
			result.add(left.removeFirst());
		}
		while (!right.isEmpty()) {
			result.add(right.removeFirst());
		}
	}
}

