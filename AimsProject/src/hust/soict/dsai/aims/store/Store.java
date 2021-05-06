package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private int inStockQty=0;
	
	
	public void addMedia(Media newMedia) {
		for(Media m: itemsInStore) {
			if(newMedia.getTitle().toLowerCase().equals(m.getTitle().toLowerCase())) {
				System.out.println("This item is already in your store!");
				return;
			}
		}
		itemsInStore.add(newMedia);
		System.out.println(newMedia.getTitle() + " has been added to the store!");
		inStockQty++;
		return;
	}
	
	public void addMedia(Media...mediaList)
	{
		for(Media medium: mediaList) {
			this.addMedia(medium);
		}
	}
	
	public void removeMedia(Media newMedia) {
		Iterator<Media> itr = itemsInStore.iterator();
		while(itr.hasNext()) {
			Media tmp = itr.next();
			if(tmp.getTitle().toLowerCase().equals(newMedia.getTitle().toLowerCase())) {
				itr.remove();
				System.out.println("item: "+newMedia.getTitle()+ " has been removed from your store!");
				inStockQty--;
				return;
			}
		}
		System.out.println("No match found for item: "+newMedia.getTitle() + " in your store!");
		return;
	}
	
	public void removeMedia(Media...mediaList) {
		for(Media medium: mediaList) {
			this.removeMedia(medium);
		}
	}
	
	

}
