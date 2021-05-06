package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	private int qtyOrdered = 0;
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void addMedia(Media newMedia) {
		
		if(itemsOrdered.contains(newMedia)) {
			System.out.println("This item is already in your cart!");
			return;
		}
		itemsOrdered.add(newMedia);
		System.out.println(newMedia.getTitle() + " has been added!");
		qtyOrdered++;
		return;
	}
	
	public void addMedia(Media...mediaList)
	{
		for(Media medium: mediaList) {
			this.addMedia(medium);
		}
	}
	
	public void removeMedia(Media newMedia) {
		Iterator<Media> itr = itemsOrdered.iterator();
		while(itr.hasNext()) {
			Media tmp = itr.next();
			if(tmp.getTitle().toLowerCase().equals(newMedia.getTitle().toLowerCase())) {
				itr.remove();
				System.out.println("item: "+newMedia.getTitle()+ " has been removed!");
				qtyOrdered--;
				return;
			}
		}
		System.out.println("No match found for item: "+newMedia.getTitle());
		return;
	}
	
	public void removeMedia(Media...mediaList) {
		for(Media medium: mediaList) {
			this.removeMedia(medium);
		}
	}
	
	/*
	public boolean searchByTitle(String title) {
		for (int i = 0; i < qtyOrdered; ++i)
			for(String w: title.split("\\s", 0))
				if(itemsOrdered.get(i).getTitle().toLowerCase().contains(w.toLowerCase()))
				{
				String[] data = itemsOrdered.get(i).getDetails();
				System.out.print(data[0] +" - " + data[1] + " - " + data[2] + " - " + 
						data[3] + ": " + data[4] + "$\n");
				return true;
				}
		System.out.println("No match found!");
		return false;
	}
	public boolean searchById(int id) {
		for (int i = 0; i < qtyOrdered; ++i)
			if(itemsOrdered[i].getId() == id)
			{
				String[] data = itemsOrdered[i].getDetails();
				System.out.print(data[0] +" - " + data[1] + " - " + data[2] + " - " + 
						data[3] + ": " + data[4] + "$\n");
				return true;
			}
		System.out.println("No match found!");
		return false;
	}*/
	public float totalCost()
	{
		float cost = 0f;
		for(Media m: itemsOrdered)
			cost += m.getCost();
		return cost;
	}
	/*
	public void print()
	{
		System.out.println("***********************CART***********************");
		for(int i = 0; i < qtyOrdered; ++i)
		{
			String[] data = itemsOrdered[i].getDetails();
			System.out.print("DVD - "+ data[0] +" - " + data[1] + " - " + data[2] + " - " + 
								data[3] + ": " + data[4] + "$\n");
		}
		System.out.print("Total Cost: ");
		System.out.println(totalCost());
		System.out.println("**************************************************\n");
	}
	*/
}
