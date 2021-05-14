package hust.soict.dsai.aims.media;

import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable{

	public DigitalVideoDisc() {
		super();
	}

	public DigitalVideoDisc(String title, int length, String director) {
		super(title, length, director);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, int length) {
		super(title, length);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
		super(title, category, cost, director, length);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, float cost, String director) {
		super(title, category, cost, director);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, String director, int length) {
		super(title, category, director, length);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, String director) {
		super(title, category, director);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public static DigitalVideoDisc initNewDVD() {
		// generate new DVD for user
		Scanner s = new Scanner(System.in);
		Scanner strScanner = new Scanner(System.in);
		System.out.println("Please enter DVD's title");
		String inpTitle = strScanner.nextLine();
		System.out.println("Please enter DVD's category");
		String inpCat = strScanner.nextLine();
		System.out.println("Please enter the DVD's director name");
		String inpDir = strScanner.nextLine();
		System.out.println("Please enter the length of the DVD");
		int inpLen = s.nextInt();
		System.out.println("Please enter the cost of the DVD");
		float inpCost = s.nextFloat();
		return new DigitalVideoDisc(inpTitle, inpCat, inpCost, inpDir, inpLen);
	}

	public StringBuffer play() {
		System.out.println("Playing DVD: "+ this.getTitle());
		System.out.println("DVD length: "+ this.getLength());
		StringBuffer s = new StringBuffer("");
		s.append("Playing DVD: "+ this.getTitle() + "\n" + "DVD length: "+ this.getLength());
		
		return s;
	}

}
