package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import hust.soict.dsai.aims.exception.NegativeNumberException;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, int length) {
		super(title, length);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, int length, String director) {
		super(title, length, director);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, String director) {
		super(title, category, director);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, String director, int length) {
		super(title, category, director, length);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, float cost, String director) {
		super(title, category, cost, director);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, float cost, String director, int length, String artist, ArrayList<Track> tracks) {
		super(title, category, cost, director, length);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(String title, String category, String cost, String director, String length, String artist) throws NumberFormatException, NullPointerException, NegativeNumberException {
		super(title, category, cost, director, length);
		if(artist==null|| artist.isBlank())
			throw new NullPointerException("Artist field is empty!");			
	}

	public CompactDisc() {

	}
	
	public static CompactDisc initNewCD() {
		// generate new CD for users
		Scanner s = new Scanner(System.in);
		Scanner strScanner = new Scanner(System.in);
		System.out.println("Please enter CD's title");
		String inpTitle = strScanner.nextLine();
		System.out.println("Please enter CD's category");
		String inpCat = strScanner.nextLine();
		System.out.println("Please enter the CD's director name");
		String inpDir = strScanner.nextLine();
		System.out.println("Please enter the length of the CD");
		int inpLen = s.nextInt();
		System.out.println("Please enter the cost of the CD");
		float inpCost = s.nextFloat();
		System.out.println("Please enter the artist name");
		String inpArt = strScanner.nextLine();
		System.out.println("Please enter the number of tracks in this CD");
		int numTrack = s.nextInt();
		System.out.println("Please enter all tracks belonging to the CD");
		ArrayList<Track> inpTracks = new ArrayList<Track>();
		for(int i = 0; i< numTrack; ++i)
			inpTracks.add(Track.initNewTrack());
		return new CompactDisc(inpTitle, inpCat, inpCost, inpDir, inpLen, inpArt, inpTracks);
	}

	
	public String getArtist() {
		return artist;
	}
	
	public int getLength(){
		int s=0;
		for(Track t: this.tracks)
		{
			s+= t.getLength();
		}
		return s;
	}
	
	public boolean addTrack(Track newTrack) {
		for(Track t: this.tracks)
			if(newTrack.getTitle().equals(t.getTitle())) {
				System.out.println("This track existed!");				
				return false;
			}
		this.tracks.add(newTrack);
		return true;
	}
	
	public boolean removeTrack(Track removedTrack) {
		Iterator<Track> itr = this.tracks.iterator();
		while(itr.hasNext())
		{
			Track tmp = itr.next();
			if(tmp.getTitle().equals(removedTrack.getTitle())) {
				itr.remove();
				System.out.println("Track: "+ removedTrack.getTitle()+ " has been removed");
				return true;
			}
		}
		System.out.println("This track doesn't exist!");
		return false;
	}
	
	public StringBuffer play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			System.out.println("Artist: " + this.getArtist());
			StringBuffer s = new StringBuffer("");
			s.append("Playing CD: " + this.getTitle() + "\n" + "CD length: " + this.getLength() + "\n" + "Artist: "
					+ this.getArtist() + "\n");
			for (Track t : this.tracks) {
				try {
					s.append(t.play());
				} catch (PlayerException e) {
					System.err.println(e.getMessage());
					e.printStackTrace();
					throw e;
				}
			}
			return s;
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	
	public StringBuffer getDetails()
	{
		String tmpArtist = this.artist;
		StringBuffer mes = new StringBuffer();
		if(this.artist == null) tmpArtist = "unknown";
		mes.append(super.getDetails());
		mes.append("artist " + tmpArtist);
		return mes;
	}
	
}
