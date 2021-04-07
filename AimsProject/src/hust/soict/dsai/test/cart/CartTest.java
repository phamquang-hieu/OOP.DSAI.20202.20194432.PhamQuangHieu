package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
	public static void main(String args[])
	{
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		
		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3};
		anOrder.addDigitalVideoDisc(dvdList);
		
		anOrder.print();
		anOrder.searchById(0);
		anOrder.searchById(-1);
		anOrder.searchByTitle("hieupham");
		anOrder.searchByTitle("Stars Wars");
	}
}
