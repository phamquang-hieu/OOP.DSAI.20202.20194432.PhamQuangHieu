package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
	
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
	
	
	public StringBuffer getDetails()
	{
		
		StringBuffer mes = new StringBuffer("");
		String tmplength = Integer.toString(this.length);
		String tmpdirector = this.director;
		if(this.director == null)
			tmpdirector = "Unknown";
		if(this.length == 0)
			tmplength = "Unknown";
		mes.append(super.getDetails());
		mes.append("length: " + tmplength + ", director: " + tmpdirector + ", ");
		
		return mes;
	}
	
	public Disc(String title) {
		super(title);
	}

	public Disc(String title, int length) {
		super(title);
		this.length = length;
	}
	
	public Disc(String title, int length, String director) {
		super(title);
		this.length = length;
		this.director = director;
	}
	
	public Disc(String title, String category) {
		super(title, category);
	}

	public Disc(String title, String category, String director) {
		super(title, category);
		this.director = director;
		
	}
	
	public Disc(String title, String category, String director, int length) {
		super(title, category);
		this.length = length;
		this.director = director;
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc(String title, String category, float cost, String director) {
		super(title, category, cost);
		this.director = director;
	}

	public Disc(String title, String category, float cost, String director, int length) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}

	public Disc() {
		// TODO Auto-generated constructor stub
	}
	
	
}
