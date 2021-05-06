package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Book extends Media {
	private int id;
	private List<String> authors = new ArrayList<String>();

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addAuthor(String authorName) {
		for(String name: this.authors)
			if(name.toLowerCase().equals(authorName.toLowerCase())){
				System.out.println("This author has already been added before!");
				return;
			}
		this.authors.add(authorName);
		System.out.println("Author: " + authorName + " has been added");
	}
	
	public void removeAuthor(String authorName) {
		Iterator<String> itr = this.authors.iterator();
		
		while(itr.hasNext()){
			String tmp = itr.next();
			if(tmp.toLowerCase().equals(authorName.toLowerCase()))
			{
				itr.remove();
				System.out.println("Author: " + authorName + " has been removed!");
				return;
			}
		}
		System.out.println("This author doesn't exist!");
		return;
	}
	
	public StringBuffer getDetails() {
		StringBuffer mes = new StringBuffer("");
		StringBuffer tmpAuthors = new StringBuffer("");
		for(String author: this.authors)
		{
			tmpAuthors.append(author + " ");
		}
		if(this.authors == null)
			tmpAuthors.append("unknown");
		mes.append(super.getDetails());
		mes.append("author: " + tmpAuthors);
		return mes;
	}
	
	
	/*
	public static void main(String[] args) {
		Book b1 = new Book();
		b1.addAuthor("hieu pham");
		b1.addAuthor("Hieu Pham");
		b1.removeAuthor("hieu Pham");
	}
	*/
	
}

