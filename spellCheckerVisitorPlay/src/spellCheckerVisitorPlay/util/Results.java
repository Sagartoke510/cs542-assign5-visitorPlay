package spellCheckerVisitorPlay.util;

/**
* Results defines an interface to be implemented by
* classes that intend to store the state for each runningaverage calculation
* processed in a stream of numbers.
*/
public interface Results {

	/**
	 * Method to write result in output file
	 */
	public void writeToFile();
	/**
	 * Method to close resources opened for writing to file
	 */
	public void close();
	/**
	 * Method to set result 
	 * @param result string containing result generated.
	 */
	public void setResult(String result);
	
	
	
}
