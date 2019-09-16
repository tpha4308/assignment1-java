import java.util.List;
import java.util.ArrayList;

/**
 * Entry deals with storing the key and value associated with entries in the
 * database. 
 * As well as storing the data the entry class should manage operations
 * associated with any Entry.
 */

public class Entry {
	private String key;
	private List<Integer> values;

	public Entry(String key, List<Integer> values) {
		// TODO: write the constructor
		this.key = key;
		this.values = values; 
	}

	/**
	 * Formats the Entry for display
	 *
	 * @return  the String of values
	 */
	public String get() {
		
		if (values.size() > 0){
			String vals = values.get(0);
			for (int i = 1; i < values.size(); i++){
				vals += " " + values.get(i);
			}
		}
		else {
			vals = "";
		}
		return "[" + vals + "]";
	}

	/**
	 * Sets the values of this Entry.
	 *
	 * @param values the values to set
	 */
	public void set(List<Integer> values) {
		// TODO: implement this
		this.values = values; 
	}

	/**
	 * Adds the values to the start.
	 *
	 * @param values the values to add
	 */
	public void push(List<Integer> values) {
		// TODO: implement this
		List<Integer> new_ls = new ArrayList<Integer>();
		for (int i = 0; i < values.size(); i++){
			new_ls.add(values.get(i));
		}
		for (int i = 0; i < this.values.size(); i++){
			new_ls.add(this.values.get(i));
		}
		this.values = new_ls; 
	}

	/**
	 * Adds the values to the end.
	 *
	 * @param values the values to add
	 */
	public void append(List<Integer> values) {
		// TODO: implement this
		for(int i = 0; i < values.size(); i++){
			this.values.add(values.get(i));
		}
	}

	/**
	 * Finds the value at the given index.
	 *
	 * @param  index the index
	 * @return       the value found 
	 */
	public Integer pick(int index) {
		// TODO: implement this
		Integer a = values.get(index);
		return a;
	}

	/**
	 * Finds and removes the value at the given index.
	 *
	 * @param  index the index
	 * @return       the value found
	 */
	public Integer pluck(int index) {
		// TODO: implement this
		return null;
	}

	/**
	 * Finds and removes the first value.
	 *
	 * @return the first value
	 */
	public Integer pop() {
		// TODO: implement this
		return null;
	}

	/**
	 * Finds the minimum value.
	 *
	 * @return the minimum value
	 */
	public Integer min() {
		Integer min_value = values.get(0);
		for(int i = 0; i < values.size(); i++){
			if (values.get(i) < min_value){
				min_value = values.get(i);
			}
		}
		return min_value;
	}

	/**
	 * Finds the maximum value.
	 *
	 * @return the maximum value
	 */
	public Integer max() {
		Integer max_value = values.get(0);
		for(int i = 0; i < values.size(); i++){
			if (values.get(i) > max_value){
				max_value = values.get(i);
			}
		}
		return max_value;
	}

	/**
	 * Computes the sum of all values.
	 *
	 * @return the sum
	 */
	public Integer sum() {
		Integer sum_value = 0;
		for (Integer n : values){
			sum_value += n;
		}
		return sum_value;
	}

	/**
	 * Finds the number of values.
	 *
	 * @return the number of values.
	 */
	public Integer len() {
		// TODO: implement this
		return values.size();
	}

	/**
	 * Reverses the order of values.
	 */
	public void rev() {
		List<Integer> newl = new ArrayList<Integer>();
		for (int i = values.size()-1; i >= 0; i--){
			newl.add(values.get(i));
		}
		values = newl; 
	}
	
	/**
	 * Removes adjacent duplicate values.
	 */
	public void uniq() {
		// TODO: implement this
	}

	/**
	 * Sorts the list in ascending order.
	 */
	public void sort() {
		// TODO: implement this
	}

	/**
	 * Computes the set difference of the entries.
	 *
	 * @param  entries the entries
	 * @return         the resulting values
	 */
	public static List<Integer> diff(List<Entry> entries) {
		// TODO: implement this
		return null;
	}
	
	/**
	 * Computes the set intersection of the entries.
	 *
	 * @param  entries the entries
	 * @return         the resulting values
	 */
	public static List<Integer> inter(List<Entry> entries) {
		// TODO: implement this
		return null;
	}

	/**
	 * Computes the set union of the entries.
	 *
	 * @param  entries the entries
	 * @return         the resulting values
	 */
	public static List<Integer> union(List<Entry> entries) {
		// TODO: implement this
		return null;
	}

	/**
	 * Computes the Cartesian product of the entries.
	 *
	 * @param  entries the entries
	 * @return         the resulting values
	 */
	public static List<List<Integer>> cartprod(List<Entry> entries) {
		// TODO: implement this
		return null;
	}

	/**
	 * Formats all the entries for display.
	 *
	 * @param  entries the entries to display
	 * @return         the entries with their values
	 */
	public static String listAllEntries(List<Entry> entries) { 
		// TODO: implement this
		return null;
	}

}
