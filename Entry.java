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
		Integer result = null;
		if (values.size() == 0) {
			return result;
		}
		else if (values.size() > 0) {
			Integer n = values.get(index-1);
			List<Integer> new_ls = new ArrayList<Integer>();
			for(int i = 0; i < values.size(); i++){
				if (i == index-1){
					continue;
				}
			new_ls.add(values.get(i));
			}
			values = new_ls; 
			result = n; 
		}
		return result;
	}

	/**
	 * Finds and removes the first value.
	 *
	 * @return the first value
	 */
	public Integer pop() {
		Integer pop_value = pluck(1);
		return pop_value; 
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
	
	//Check if a number is in a list
	static boolean contain(Integer n, List<Integer> ls) {
		for (Integer num : ls){
			if (num == n){
				return true;
			}
		}
		return false; 
	}
	
	//Return only unique values of a list
	public static List<Integer> uniqList(List<Integer> ls){
		List<Integer> dup_ls = new ArrayList<Integer>();
		List<Integer> uniq_ls = new ArrayList<Integer>();
		
		for (Integer n : ls){
			if (contain(n, uniq_ls) == false){
				uniq_ls.add(n);
			}
			else {
				dup_ls.add(n);
			}
		}
		return uniq_ls;
	}

	//Simple difference methods for two entries 
	public static List<Integer> simpleDiff(List<Integer> ls1, List<Integer> ls2){
		List<Integer> big_ls = new ArrayList<Integer>();
		
		for (int i = 0; i < ls1.size(); i++){
			big_ls.add(ls1.get(i));
		}
		for (int i = 0; i < ls2.size(); i++){
			big_ls.add(ls2.get(i));
		}
		List<Integer> diff = new ArrayList<Integer>();
		for (Integer n : big_ls){
			if (contain(n, ls1) && contain(n, ls2)){
				continue; 
			}
			diff.add(n);
		}
		return diff;
	}	

	/**
	 * Computes the set difference of the entries.
	 *
	 * @param  entries the entries
	 * @return         the resulting values
	 */
	public static List<Integer> diff(List<Entry> entries) {
		if (entries.size() == 0){
			return null;
		}
		
		//Case where there is only one entry
		if (entries.size() == 1){
			return entries.get(0).values;
		}
		
		//Case where there are more than 2 entries 
		List<Integer> first_diff = simpleDiff(entries.get(0).values, entries.get(1).values);
		System.out.println("First diff: " + first_diff);
		
		List<List<Integer>> diff_list = new ArrayList<List<Integer>>();
		diff_list.add(first_diff);
		
		int i = 0;
		while (i < (entries.size()-2)){
			List<Integer> each_diff = simpleDiff(diff_list.get(i), entries.get(i+2).values);
			diff_list.add(each_diff);
			i+=1;
		}		
		
		//Adding all the difference values together in one list
		List<Integer> result_ls = new ArrayList<Integer>();
		for(List<Integer> tiny_ls : diff_list){
			for(Integer val : tiny_ls){
				result_ls.add(val);
			}
		}
		List<Integer> display_ls = uniqList(result_ls);
		return display_ls;
	}
	
	/**
	 * Computes the set intersection of the entries.
	 *
	 * @param  entries the entries
	 * @return         the resulting values
	 */
	public static List<Integer> inter(List<Entry> entries) {
		if (entries.size() == 0){
			return null;
		}
		if (entries.size() == 1){
			return entries.get(0).values;
		}
		List<Integer> intersect = new ArrayList<Integer>();
		for (Integer n : entries.get(0).values){
			boolean belongs_all = true;
			int i = 1;
			while (i < entries.size()){
				boolean check = contain(n, entries.get(i).values);
				if (check == false){
					belongs_all = false; 
				}
				i+=1;
			}
			if (belongs_all == true){
				intersect.add(n);
			}
		}
		List<Integer> display_inter = uniqList(intersect);
		return display_inter;
	}

	/**
	 * Computes the set union of the entries.
	 *
	 * @param  entries the entries
	 * @return         the resulting values
	 */
	public static List<Integer> union(List<Entry> entries) {
		if (entries.size() == 0){
			return null;
		}
		if (entries.size() == 1){
			return entries.get(0).values;
		}
		List<Integer> union = new ArrayList<Integer>();
		for (Entry entr : entries){
			for(Integer n : entr.values){
				union.add(n);
			}
		}
		List<Integer> display_union = uniqList(union);
		return display_union; 
	}

	/**
	 * Computes the Cartesian product of the entries.
	 *
	 * @param  entries the entries
	 * @return         the resulting values
	 */
	public static List<List<Integer>> cartprod(List<Entry> entries) {
		if (entries.size() == 0){
			return null;
		}
		if (entries.size() == 1){
			return entries.get(0).values;
		}
		
		List<List<Integer>> 
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
			
			for (int i = entries.size()-1; i >= 0; i--){
				String key = entries.get(i).getKey();
				String vals = entries.get(i).get();
				String each_entry = String.format("%s %s\n", key, vals);
				display += each_entry;
			}
		}
		return display;
	}

}
