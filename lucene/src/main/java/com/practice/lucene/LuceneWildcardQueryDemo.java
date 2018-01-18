package com.practice.lucene;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.search.uhighlight.UnifiedHighlighter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class LuceneWildcardQueryDemo {
	
	//This contains the lucene indexed documents
		private static final String INDEX_DIR = "indexedFiles";
		
		/*public static final String FILES_TO_INDEX_DIRECTORY = "filesToIndex";
		public static final String INDEX_DIRECTORY = "indexDirectory";

		public static final String FIELD_PATH = "path";
		public static final String FIELD_CONTENTS = "contents";*/

		public static void main(String[] args) throws Exception 
		{
			//Get directory reference
			Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));
			
			//Index reader - an interface for accessing a point-in-time view of a lucene index
			IndexReader reader = DirectoryReader.open(dir);
			
			//Create lucene searcher. It search over a single IndexReader.
			IndexSearcher searcher = new IndexSearcher(reader);
			
			//analyzer with the default stop words
			Analyzer analyzer = new StandardAnalyzer();
			
			
			/**
			 * Wildcard "*" Example
			 * */
			
			//Create wildcard query
			Query query = new WildcardQuery(new Term("contents", "*e*"));
			
			//Search the lucene documents
			TopDocs hits = searcher.search(query, 10, Sort.INDEXORDER);
			
			System.out.println("Search terms found in :: " + hits.totalHits + " files");
			
			UnifiedHighlighter highlighter = new UnifiedHighlighter(searcher, analyzer);
	        String[] fragments = highlighter.highlight("contents", query, hits);
	        
	        for(String f : fragments)
	        {
	        	System.out.println(f);
	        }
	        
	        /**
			 * Wildcard "?" Example
			 * */
	        
	        //Create wildcard query
	  		query = new WildcardQuery(new Term("contents", "s?t"));
	  		
	  		//Search the lucene documents
	  		hits = searcher.search(query, 10, Sort.INDEXORDER);
	  		
	  		System.out.println("Search terms found in :: " + hits.totalHits + " files");
	  		
	  		highlighter = new UnifiedHighlighter(searcher, analyzer);
		    fragments = highlighter.highlight("contents", query, hits);
		      
		    for(String f : fragments)
		    {
		    	System.out.println(f);
		    }
			
	        dir.close();
		}
		
		
		/*public static void createIndex() throws CorruptIndexException, LockObtainFailedException, IOException {
			Analyzer analyzer = new StandardAnalyzer();
			boolean recreateIndexIfExists = true;
			IndexWriter indexWriter = new IndexWriter(INDEX_DIRECTORY, analyzer, recreateIndexIfExists);
			File dir = new File(FILES_TO_INDEX_DIRECTORY);
			File[] files = dir.listFiles();
			for (File file : files) {
				Document document = new Document();

				String path = file.getCanonicalPath();
				document.add(new Field(FIELD_PATH, path, Field.Store.YES, Field.Index.UN_TOKENIZED));

				Reader reader = new FileReader(file);
				document.add(new Field(FIELD_CONTENTS, reader));

				indexWriter.addDocument(document);
			}
			indexWriter.optimize();
			indexWriter.close();
		}*/
		
		
		/*public static void displayHits(Hits hits) throws CorruptIndexException, IOException {
			System.out.println("Number of hits: " + hits.length());

			Iterator<Hit> it = hits.iterator();
			while (it.hasNext()) {
				Hit hit = it.next();
				Document document = hit.getDocument();
				String path = document.get(FIELD_PATH);
				System.out.println("Hit: " + path);
			}
		}*/

}
