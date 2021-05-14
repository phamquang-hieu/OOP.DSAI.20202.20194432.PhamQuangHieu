package hust.soict.dsai.aims.media;

import java.util.Scanner;

public class Track implements Playable{

	private String title;
	private int length;
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public static Track initNewTrack() {
		// create new track // for user
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter track's name");
		String inpTitle = s.nextLine();
		System.out.println("Please enter track's length");
		int inpLen = s.nextInt();
		return new Track(inpTitle, inpLen);
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public boolean equals(Object x) {
		if(x instanceof Track) {
			Track tmp = (Track) x;
			return tmp.getTitle().toLowerCase().equals(this.title.toLowerCase()) && tmp.getLength()== this.length;
		}
		return false;
	}
	
	public StringBuffer play() {
		System.out.println("Playing Track: "+ this.title);
		System.out.println("Track length: "+ this.length);
		StringBuffer s = new StringBuffer("");
		s.append("Playing Track: "+ this.title + "\n" + "Track length: "+ this.length);
		return s;
	}
}
