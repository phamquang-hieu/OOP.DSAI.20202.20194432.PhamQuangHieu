package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
//import hust.soict.dsai.aims.media.Media;
//import java.util.*;
public class CartTest {
	public static void main(String args[])
	{
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars", "Science Fiction", 24.95f, "George Lucas", 87);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		
		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3};
		anOrder.addMedia(dvdList);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("the lion king", "Animation", 19.95f, "Roger Allers", 87);
		anOrder.addMedia(dvd4);
		anOrder.addMedia(dvd1);
		//anOrder.sortMediaByCostTitle();
		//anOrder.sortMediaByTitleCost();
		System.out.println(anOrder.itemsOrdered.indexOf(new CompactDisc("he lion king")));
		/*
		System.out.println(anOrder.totalCost());
		
		anOrder.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
		for(Media m: anOrder.itemsOrdered)
		{
			System.out.println(m.getDetails());
		}
		*/
		/*
		anOrder.print();
		anOrder.searchById(0);
		anOrder.searchById(-1);
		anOrder.searchByTitle("hieupham");
		anOrder.searchByTitle("hieu pham sta");
		anOrder.searchByTitle("lio Hieu");
		*/
	}
}
