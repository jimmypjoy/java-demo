package com.demo.lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class LuceneReadIndexExample 
{
	private static final String INDEX_DIR = "c:/temp/lucene6index";

	public static void main(String[] args) throws Exception 
	{
		IndexSearcher searcher = createSearcher();
		
		//Search by ID
		TopDocs foundDocs = searchById(1, searcher);
		
		System.out.println("Total Results searchById(1 :: " + foundDocs.totalHits);
		
		for (ScoreDoc sd : foundDocs.scoreDocs) 
		{
			Document d = searcher.doc(sd.doc);
			System.out.println(String.format(d.get("firstName")));
			System.out.println(d);
		}
		
		//Search by firstName
		TopDocs foundDocs3 = searchByFirstName("Jimmy", searcher);
		for (ScoreDoc sd : foundDocs3.scoreDocs) 
		{
			Document d = searcher.doc(sd.doc);
			System.out.println(String.format(d.get("firstName")));
			System.out.println(d);
		}
		
		System.out.println("Toral Results :: " + foundDocs3.totalHits);
		

	}
	
	private static TopDocs searchByFirstName(String firstName, IndexSearcher searcher) throws Exception
	{
		QueryParser qp = new QueryParser("firstName", new StandardAnalyzer());
		Query firstNameQuery = qp.parse(firstName);
		TopDocs hits = searcher.search(firstNameQuery, 10);
		return hits;
	}

	private static TopDocs searchById(Integer id, IndexSearcher searcher) throws Exception
	{
		QueryParser qp = new QueryParser("id", new StandardAnalyzer());
		Query idQuery = qp.parse(id.toString());
		TopDocs hits = searcher.search(idQuery, 10);
		return hits;
	}

	private static IndexSearcher createSearcher() throws IOException {
		Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);
		return searcher;
	}
}
