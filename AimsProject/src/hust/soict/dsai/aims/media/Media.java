package hust.soict.dsai.aims.media;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public abstract class Media {
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	protected String title;
	protected String category;
	protected float cost;
	protected Date date = new Date();
    protected DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
    protected int id;
    protected static int nbMedia = 0;
	
    public Media(String title) {
		super();
		this.title = title;
		this.id = ++nbMedia;
		
	}
    
	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		nbMedia++;
		this.id = ++nbMedia;
	}

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++nbMedia;
	}
	
	public Media(String title, float cost) {
		super();
		this.title = title;
		this.cost = cost;
		this.id = ++nbMedia;
	}
	
	public Media() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public float getCost()
	{
		return this.cost;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public StringBuffer getDetails()
	{
		StringBuffer mes = new StringBuffer("");
		
		mes.append("title " + this.title);
		if(this.category != null) 
			mes.append(", category: " + this.category);
		else
			mes.append(", category: " + "unknown ");
		if(this.cost != 0f)
			mes.append(", cost: " + this.cost + ", ");
		else
			mes.append(", cost: " + "unknown, ");
		return mes;
	}
	
	public boolean equals(Object x) {
		if(x instanceof Media) {
			Media tmp = (Media) x;
			return tmp.getTitle().toLowerCase().equals(title.toLowerCase());
		}
		
		return false;
	}

}
