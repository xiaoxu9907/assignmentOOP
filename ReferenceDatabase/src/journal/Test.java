package journal;


public class Test {
	
	public static void main(String[] args) throws InvalidPublicationYearException{
		String[] author={"xIAO, xu DJFK","yu, qian","eiwo, lwekj","Einstein, Albert  middlename"};
		JournalArticle journal1= new JournalArticle("this is the first article",author,"cell", -8 , 2015);
		//JournalArticle journal1= new JournalArticle("this is the first article");
		System.out.println(journal1);
		
		// 怎么把标题前的空格去掉？
		
		// how to delete this sign[] in author?
		// and I don't know why issueNr=-8 cannot run in the test but can run in here and show the result.
	}

}
