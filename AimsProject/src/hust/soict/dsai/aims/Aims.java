package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		
		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3};
		anOrder.addDigitalVideoDisc(dvdList);
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost() + "\n");
		
		Cart anotherOrder = new Cart();
		anotherOrder.addDigitalVideoDisc(dvd1, dvd3);
		anotherOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		System.out.println("Total Cost is: "+ anotherOrder.totalCost() + "\n");
		
		
	}
}
