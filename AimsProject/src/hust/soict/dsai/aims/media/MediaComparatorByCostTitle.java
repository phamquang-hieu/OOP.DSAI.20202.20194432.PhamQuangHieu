package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media o1, Media o2) {
		int titleCompare= o1.getTitle().toLowerCase().compareTo(o2.getTitle().toLowerCase());
		int costCompare= Float.compare(o1.getCost(), o2.getCost());
		return (costCompare==0)? titleCompare: costCompare;
	}

}
