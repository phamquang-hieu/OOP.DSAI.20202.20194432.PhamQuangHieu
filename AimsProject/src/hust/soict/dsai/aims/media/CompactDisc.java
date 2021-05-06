package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

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

	public CompactDisc(String title, String category, float cost, String director, int length) {
		super(title, category, cost, director, length);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc() {
		// TODO Auto-generated constructor stub
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
	
	public void addTrack(Track newTrack) {
		for(Track t: this.tracks)
			if(newTrack.getTitle().equals(t.getTitle())) {
				System.out.println("This track existed!");				
				return;
			}
		this.tracks.add(newTrack);
	}
	
	public void removeTrack(Track removedTrack) {
		Iterator<Track> itr = this.tracks.iterator();
		while(itr.hasNext())
		{
			Track tmp = itr.next();
			if(tmp.getTitle().equals(removedTrack.getTitle())) {
				itr.remove();
				System.out.println("Track: "+ removedTrack.getTitle()+ " has been removed");
				return;
			}
		}
		System.out.println("This track doesn't exist!");
		return;
	}
	
	public void play(){
		System.out.println("Playing CD: "+ this.getTitle());
		System.out.println("CD length: "+ this.getLength());
		System.out.println("Artist: "+ this.getArtist());
		
		for(Track t: this.tracks) {
			t.play();
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
