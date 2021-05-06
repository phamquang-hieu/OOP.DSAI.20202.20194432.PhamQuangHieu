package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compare(Media o1, Media o2) {
		int titleCompare= o1.getTitle().toLowerCase().compareTo(o2.getTitle().toLowerCase());
		int costCompare= Float.compare(o1.getCost(), o2.getCost());
		return (titleCompare==0)? costCompare: titleCompare;
	}

}
