
package journal;
import java.util.Arrays;
import be.kuleuven.cs.som.annotate.*;
import java.util.Calendar;
/**
 * A class to represent journal article.
 * 
 * @invar The issue number of each journal article is legal.
 *        | isValidIssueNr(getIssueNr())  
 * @invar The publication year of each journal article is valid year.
 *        | isValidYear(getYear())  
 * @invar 
 *     
 * @author William Roberts-Sengier & Xu Xiao
 *
 */
public class JournalArticle {

	/**
	 * Initialize this journal article with given title, author(s), 
	 * journal name, issue number and publication year.
	 * 
	 * @param title
	 *        The title for this new journal article.
	 * @param author
	 *        The author(s) for this new journal article.
	 * @param journalName 
	 *        The name of the journal in which this new journal article is published.
	 * @param issueNr
	 *        The issue number of the journal in which this new journal article is published.
	 * @param year
	 *        The publication year of this new journal article.
	 * @pre   The given issue number is valid for this journal article.
	 *        | isValidIssueNr(issueNr)
	 * @pre   The publication year of the article is valid for this journal article.
	 *        | isValidYear(year)
	 * @post  The issue number of this new journal article is equal to the given issueNr.
	 *        | assert isValidIssueNr(issueNr)
	 *        | new.getIssueNr() == issueNr
	 * @throws InvalidPublicationYearException   
	 *         The given publication year of this journal article is invalid.
	 *         | !isValidYear(year)
	 * @effect The title of this new journal article is equal to the given capitalized title.
	 *         | new.getTitle() == new.capitalizeTitle(title)
	 * @effect The author of this new journal article is equal to the given author name 
	 *         consisting the author’s initial and the last name.
	 *         | new.getAuthor() == new.authorName(author)	
	 */
	public JournalArticle(String title, String[] author, String journalName,int issueNr,int year, 
			JournalArticle[] citation, JournalArticle[] citeby) 
			throws InvalidPublicationYearException{
		setTitle(title);
		setAuthor(author);
		setJournalName(journalName);
		assert isValidIssueNr(issueNr);
		    this.issueNr=issueNr;
	    if (!isValidYear(year))
	    	throw new InvalidPublicationYearException(year);
	    this.year=year;
	    setCitation(citation);
	    
	    //setAsCitation(asciation);
	    
	}
	
	/**
	 * Initialize the new journal article with given title.
	 * 
	 * @param  title
	 *         The title for this new journal article.
	 * @throws InvalidPublicationYearException 
	 * @effect This new journal article is initialized only with given capitalized title.
	 * 
	 */
	public JournalArticle(String title) throws InvalidPublicationYearException{
		this(title,null,null,0,0);   // 调用前一个constructor.
	}
	
	/**
	 * Return the title of this journal article.
	 */
	@Basic
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Set the title of this journal article and capitalize it.
	 * 
	 * @param title
	 *        The new title for this journal article
	 * @post  The title of this journal article is equal to the given title capitalized.
	 *        | new.getTitle() == capitalizeTitle(title)
	 */
	public void setTitle(String title) {
		this.capitalizeTitle(title);  
	}
	
	/**
	 * Capitalizes every word in title.
	 * 
	 * @param	title 
	 *        	The title of this journal article.
	 * @pre		The title of this journal article must exist. 
	 *      	| title != null
	 * @effect	The given title will be capitalized .
	 * @note 	Split the title into array of words, using whitespace as a separator.
	 *          Convert first letter of each word to uppercase and all other characters
	 *          to lowercase. Reconstruct the title by extending an empty string with 
	 *          each converted word.
	 */
	public void capitalizeTitle(String title){
		 assert title != null;
		 String title1="";
		 String[] rename=title.split("\\s+");
		   for(int i=0;i<rename.length;i++){
			String s0=rename[i];
			String s1=s0.substring(0, 1);
			String s2=s0.substring(1);
			String s3=s1.toUpperCase();
			String s4=s2.toLowerCase();
			title1=title1+" "+s3.concat(s4);
		   }
		   this.title= title1;
	}
	
	/**
	 * Variable registering the title of this journal article.
	 */
	private String title;
	
	/**
	 * Return the author(s) of this journal article.
	 */
	@Basic
	public String[] getAuthor() {
		return this.author;
	}
	
	/**
	 * Sets author of this journal article to an array of correctly formatted names.
	 * 
	 * @param  author
	 *         A list of names of the author(s) of this journal article.
	 * @effect The author(s) name is equal to the given author and convert 
	 *         the author's initial and last name.
	 *         | new.getAuthor == new.authorName(author)
	 * 
	 */
	public void setAuthor(String[] author) {
		this.authorName(author);
	}
	
	/**
	 * 
	 * Return the number of authors of this journal article.
	 */
	@Basic
	public int getNrAuthor(){
		int number=getAuthor().length;
		return number;
	}
	/**
	 * Converts each name of the author(s) of this journal article to format "INITIAL. LASTNAME".
	 * 
	 * @param  author
	 *         A list of names of the author(s) of this journal article.
	 * @throws InvalidPublicationYearException 
	 * @effect Change the old author name format (lastname, firstname) to new author name format (F.Lastname)
	 *         of this journal article.
	 * @note   Iterating over every author's name, split it into last name and first name.
	 * 		   Extract and capitalize initial of first name followed by capitalized last name.  
	 */
	public  void authorName(String[] author) {
		String firstName,lastName,firstNameInitial;
		for(int i=0; i<author.length;i++){
		  String author1= author[i];
		  String[] rename=author1.split(",");
		  firstName= rename[1];
		  firstNameInitial=firstName.substring(1, 2);
		  lastName= rename[0];
		  // rethink about it here.
		  //author[i]= firstNameInitial.toUpperCase()+"."+ name.getTitle();
		}
		  this.author=author;
	} 
	
	/**
	 * Variable registering the author of this journal article.
	 */
	private String[] author;
	
    /**
     * Return the Journal name of this journal article.
     */
	@Basic
	public String getJournalName() {
		return journalName;
	}
	
	/**
	 * Set the journal name for this journal article to the given name.
	 * 
	 * @param  journalName
	 *         The new journal name for this journal article.
	 * @effect | new.getJournalName() == journalName
	 */
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
	
	/**
	 * Variable registering journal name of this article.
	 */
    private String journalName;
    
    /**
     * 
     * Return issue number of this journal article.
     */
    @Basic
	public int getIssueNr() {
		return issueNr;
	}
	
	/**
	 * Check whether the issue number is valid.
	 *        
	 * @return True if the issue number is larger than zero.
	 *         | result == (getIssueNr() > 0)
	 */
	public boolean isValidIssueNr(int issueNr){
		return issueNr > 0;
	}
	
	 /**
     * Variable registering the issue number of this journal article.
     */
    private int issueNr;
    
    /**
     * 
     * Return the publication year of this journal article.
     */
    @Basic
	public int getYear() {
		return year;
	}
	
	/**
	 * 
	 * @param  year
	 *         The publication year of this journal article.
	 * @return True if the publication year less than the current year.
	 *         | result == getYear() < now.get(Calendar.YEAR)
	 */
	public boolean isValidYear(int year){
		Calendar now=Calendar.getInstance();
		return year <= now.get(Calendar.YEAR);
	}
	
    /**
     * Set the publication year for this journal article to given year.
     * 
     * @param year
     *        The new publication year for this journal article.
     *        | new.getYear == year
     */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * Check whether this journal article was published more than 10 years ago.
	 * 
	 * @return True if this article was published more than 10 years age
	 *         | result == now.get(Calendar.YEAR)-getYear()>10
	 */
	public boolean isOverYear(){
		Calendar now=Calendar.getInstance();
		return now.get(Calendar.YEAR)-getYear()>10;  
	}
	
	/**
	 * Variable registering the publication year of this journal article.
	 */
	private int year;
	
    /**
     * Return a textual representation of this journal article.
     * 
     * @return An string of the following form 
     *         "author(s) names. title. journal name. publication year; issue number"
     *         
     */
	@Override
	public String toString() {
		String author1= Arrays.toString(author);
		String authors = author1.substring(1,author1.length()-1);
		return authors + ". " + title + ". "+ journalName+"."
				 + year+ "; "+ issueNr ;
	}   
	/**
	 * 
	 */
	

}
