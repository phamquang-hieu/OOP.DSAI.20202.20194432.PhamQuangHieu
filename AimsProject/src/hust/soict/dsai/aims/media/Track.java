package hust.soict.dsai.aims.media;

public class Track implements Playable{

	private String title;
	private int length;
	public Track() {
		// TODO Auto-generated constructor stub
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
	public void play() {
		System.out.println("Playing Track: "+ this.title);
		System.out.println("Track length: "+ this.length);
	}
}
