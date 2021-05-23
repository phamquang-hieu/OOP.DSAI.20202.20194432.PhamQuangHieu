package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Date;

import hust.soict.dsai.aims.exception.NegativeNumberException;

public abstract class Media {
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	protected String title;
	protected String category;
	protected float cost;
	public Date date = new Date();
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
	
	public Media(String title, String category, String cost) throws NullPointerException, NumberFormatException, NegativeNumberException {
		if(title==null || title.isBlank())
			throw new NullPointerException("Title field is empty!");
		if(category==null || category.isBlank())
			throw new NullPointerException("Category field is empty!");
		if(cost==null || cost.isBlank())
			throw new NullPointerException("Cost field is empty!");
		
		try {
			this.title = title;
			this.cost = Float.parseFloat(cost);
			if(this.cost < 0) {
				throw new NegativeNumberException("Cost must be a positive number");
			}
			this.category = category;
		} catch (NumberFormatException e) {
			System.err.println("Cost must be a positive number!");
			throw new NumberFormatException("Cost must be a positive number!");
		}
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
		mes.append("ID: " + this.getId() + ", ");
		mes.append("title " + this.title);
		if(this.category != null) 
			mes.append(", category: " + this.category);
		else
			mes.append(", category: " + "unknown ");
		if(this.cost != 0f)
			mes.append(", cost: " + this.cost + ", ");
		else
			mes.append(", cost: " + "unknown, ");
		mes.append("Date: " + this.date.toString() + ", ");
		return mes;
	}
	
	public boolean equals(Object x) {
		try {
			if(x instanceof Media) {
				Media tmp = (Media) x;
				return tmp.getTitle().toLowerCase().equals(title.toLowerCase());
			}
		} catch (ClassCastException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.err.println("The class used for comparing is null!");
		}
		
		return false;
	}

}
