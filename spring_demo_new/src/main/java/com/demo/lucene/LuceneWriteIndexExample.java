package com.demo.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

public class LuceneWriteIndexExample 
{
	private static final String INDEX_DIR = "c:/temp/lucene6index";

	public static void main(String[] args) throws Exception 
	{
		IndexWriter writer = createWriter();
		List<Document> documents = new ArrayList<>();
		System.out.println("Starting docuemnt indexing......");
		
		Document document1 = createDocument(1, "Firstname1", "Lastname1", "abc.com");
		documents.add(document1);
		
		Document document2 = createDocument(2, "Firstname2", "Lastname2", "abc.com");
		documents.add(document2);
		
		Document document3 = createDocument(3, "Jimmy", "joy", "abc.com");
		documents.add(document3);
		
		writer.deleteAll();
		
		writer.addDocuments(documents);
		writer.commit();
	    writer.close();
	    System.out.println("Finished docuemnt indexing......");
	}

	private static Document createDocument(Integer id, String firstName, String lastName, String website) 
	{
    	Document document = new Document();
    	document.add(new StringField("id", id.toString() , Field.Store.YES));
    	document.add(new TextField("firstName", firstName , Field.Store.YES));
    	document.add(new TextField("lastName", lastName , Field.Store.YES));
    	document.add(new TextField("website", website , Field.Store.YES));
    	return document;
    }

	private static IndexWriter createWriter() throws IOException 
	{
		FSDirectory dir = FSDirectory.open(Paths.get(INDEX_DIR));
		IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
		IndexWriter writer = new IndexWriter(dir, config);
		return writer;
	}
}
