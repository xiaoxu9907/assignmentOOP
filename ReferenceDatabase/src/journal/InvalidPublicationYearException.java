/**
 * 
 */
package journal;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class for invalid publication year for journal article.
 * 
 * @author William Roberts-Sengier & Xu Xiao
 *
 */
public class InvalidPublicationYearException extends Exception {
	
    /**
     * Initialize this new invalid publication year exception with given year.
     * 
     * @param year
     *        The year for this new invalid publication year exception.
     * @post  The year of this new invalid publication year is equal
	 *         to the given year.
	 *       | new.getYear() == year
     */
	public InvalidPublicationYearException(int year){
		this.year = year;
	}
	
	/**
	 * Return the year for this invalid publication year.
	 */
	@Basic @Immutable
	public int getYear(){
		return this.year;
	}
	
	/**
	 * Variable registering the year for this invalid publication year.
	 */
	private int year;
	
	
	/**
	 * Return an information about this invalid publication year.
	 */
    @Override
	public String toString() {
		return  year + " is not a valid year! This article might be a furture one.";
	}


    private static final long serialVersionUID = 1L;
}
