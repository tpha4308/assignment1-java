import java.util.List;
/**
 * Snapshot deals with storing the id and current state of the database. 
 * As well as storing this data, the Snapshot class should manage operations
 * related to snapshots.
 */

public class Snapshot {
	private int id;
	private List<Entry> entries;

	public Snapshot(int id, List<Entry> entries) {
		// TODO: write this constructor
	}

	/**
	 * Finds and removes the key.
	 *
	 * @param key the key to remove
	 */
	public void removeKey(String key) {
		// TODO: implement this
	}

	/**
	 * Finds the list of entries to restore.
	 *
	 * @return the list of entries in the restored state
	 */
	public List<Entry> rollback() {
		// TODO: implement this
		return null;
	}


	/**
	 * Saves the snapshot to file.
	 *
	 * @param filename the name of the file
	 */
	public void archive(String filename) {
		// TODO: implement this
	}

	/**
	 * Loads and restores a snapshot from file.
	 *
	 * @param  filename the name of the file
	 * @return          the list of entries in the restored state
	 */
	public static List<Entry> restore(String filename) {
		// TODO: implement this
		return null;
	}

	/**
	 * Formats all snapshots for display.
	 *
	 * @param  snapshots the snapshots to display
	 * @return           the snapshots ready to display
	 */
	public static String listAllSnapshots(List<Snapshot> snapshots) {
		// TODO: implement this
		return null;
	}
}
