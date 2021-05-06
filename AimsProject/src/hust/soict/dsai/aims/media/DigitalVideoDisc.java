package hust.soict.dsai.aims.media;


public class DigitalVideoDisc extends Disc implements Playable{
	private int id;

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
	

	public void play() {
		System.out.println("Playing DVD: "+ this.getTitle());
		System.out.println("DVD length: "+ this.getLength());
	}

}
