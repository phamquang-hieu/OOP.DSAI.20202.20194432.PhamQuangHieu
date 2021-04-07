package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String args[]) {
		Store x = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("abc");
		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3, dvd4};
		x.addDVD(dvdList);
		x.removeDVD(dvd4);
		x.removeDVD(dvd3);
		x.removeDVD(dvd2);
		x.removeDVD(dvd1);
		x.removeDVD(new DigitalVideoDisc("xyz"));
	}
}
