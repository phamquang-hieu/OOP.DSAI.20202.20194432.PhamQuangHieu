package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	public Book(String title, String category, float price, ArrayList<String> authors) {
		// TODO Auto-generated constructor stub
		super(title, category, price);
		this.authors = authors;
	}
	
	public static Book initNewBook() {
		// generate new book for user
		Scanner s = new Scanner(System.in);
		Scanner strScanner = new Scanner(System.in);
		System.out.println("Please enter book's title");
		String inpTitle = strScanner.nextLine();
		System.out.println("Please enter book's category");
		String inpCat = strScanner.nextLine();
		System.out.println("Please enter the cost of the book");
		float inpCost = s.nextFloat();
		System.out.println("Please enter the number of authors");
		int authNum = s.nextInt();
		ArrayList<String> inpAuthors = new ArrayList<String>();
		for(int i = 0; i< authNum; ++i)
			inpAuthors.add(strScanner.nextLine());
		return new Book(inpTitle, inpCat, inpCost, inpAuthors);
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

