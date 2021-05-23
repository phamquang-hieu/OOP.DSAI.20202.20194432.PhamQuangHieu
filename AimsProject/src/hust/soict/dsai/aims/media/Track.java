package hust.soict.dsai.aims.media;

import java.util.Scanner;

import hust.soict.dsai.aims.exception.NegativeNumberException;
import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{

	private String title;
	private int length;
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public Track(String title, String length) throws NullPointerException, NumberFormatException, NegativeNumberException{
		if(title==null || title.isBlank()) {
			throw new NullPointerException("Title field is empty!");
		}
		if(length == null)
			throw new NullPointerException("Length of a track must be a positive integer!");
		try {
			this.length = Integer.parseInt(length);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Length of a track must be a positive integer!");
		}
		if(this.length < 0)
			throw new NegativeNumberException("Track's length must be a positive integer!");
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
	
	public StringBuffer play() throws PlayerException{
		if (this.getLength() >0) {
			System.out.println("Playing Track: " + this.title);
			System.out.println("Track length: " + this.length);
			StringBuffer s = new StringBuffer("");
			s.append("Playing Track: " + this.title + "\n" + "Track length: " + this.length);
			return s;
		}
		else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
}
