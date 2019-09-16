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
		String vals = "";
		if (values.size() > 0){
			vals += values.get(0);
			for (int i = 1; i < values.size(); i++){
				vals += " " + values.get(i);
			}
		}
		return "[" + vals + "]";
	}
	
	public String getKey(){
		return key;
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
		for (int i = values.size()-1; i >= 0; i--){
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
		Integer n = values.get(index-1);
		return n;
	}

	/**
	 * Finds and removes the value at the given index.
	 *
	 * @param  index the index
	 * @return       the value found
	 */
	public Integer pluck(int index) {
		Integer n = values.get(index-1);
		List<Integer> new_ls = new ArrayList<Integer>();
		if (values.size() > 1){
			for(int i = 0; i < values.size(); i++){
			if (i == index-1){
				continue;
			}
			new_ls.add(values.get(i));
			}
		}
		values = new_ls; 
		return n;
	}

	/**
	 * Finds and removes the first value.
	 *
	 * @return the first value
	 */
	public Integer pop() {
		Integer n = values.get(0);
		pluck(1);
		return n;
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
		System.out.println(newl);
		values = newl; 
	}
	
	/**
	 * Removes adjacent duplicate values.
	 */
	public void uniq() {
		List<Integer> uniq_ls = new ArrayList<Integer>();
		if (values.size() > 0){
			uniq_ls.add(values.get(0));
			for (int i = 1; i < values.size(); i++){
				Integer num = values.get(i);
				if (num == values.get(i-1)){
					continue;
				}
				uniq_ls.add(num);
			}
		}
		values = uniq_ls;
	}

	/**
	 * Sorts the list in ascending order.
	 */
	public void sort() {
		List<Integer> sort_ls = new ArrayList<Integer>();
		while (values.size() > 0){
				Integer lowest = min();
				sort_ls.add(lowest);
				int index = values.indexOf(lowest);
				pluck(index + 1);
				if (values.size() >= 1){
					lowest = min();
				}	
		}
		values = sort_ls;
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
		String display = "";
		if (entries.size() == 0){
			display += "no entries";
		}
		if (entries.size() > 0){
			
			for (int i = 0; i < entries.size(); i++){
				String key = entries.get(i).getKey();
				String vals = entries.get(i).get();
				String each_entry = String.format("%s %s\n", key, vals);
				display += each_entry;
			}
		}
		return display;
	}

}
