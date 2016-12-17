package journal;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class JournalArticleTest {

	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void testJournalArticle() throws InvalidPublicationYearException{
		JournalArticle journal1= new JournalArticle("this is the first article");
		assertEquals(" This Is The First Article",journal1.getTitle());
	}
	
	@Test
	public void testGetNrAuthor() throws InvalidPublicationYearException{
		String[] author={"xiao, xu","roberts-Sengier, william"};
		JournalArticle journal1= new JournalArticle("this is the first article",author,"journal", 8 , 2000 );
		assertEquals(2,journal1.getNrAuthor());
	}
	
	@Test
	public void testIsOverYear() throws InvalidPublicationYearException{
		String[] author={"xiao, xu","roberts-Sengier, william"};
		JournalArticle journal1= new JournalArticle("this is the first article",author,"journal", 8 , 2000 );
		assertTrue(journal1.isOverYear());
		
	}

	@Test
	public void testAuthorName() throws InvalidPublicationYearException{
		String[] author={"xIAo, xu","roberts-Sengier, william"};
		JournalArticle journal1= new JournalArticle("this is the first article",author,"journal", 8 , 2000 );
		assertEquals("[X. Xiao, W. Roberts-sengier]", Arrays.toString(journal1.getAuthor()));
	}
	
	

}
