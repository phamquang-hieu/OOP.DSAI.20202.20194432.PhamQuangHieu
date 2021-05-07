package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String args[]) {
		Store x = new Store();													
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars", "Science Fiction", 24.95f,"George Lucas", 87);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("abc");
		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3, dvd4};
		x.addMedia(dvdList);
		x.removeMedia(dvd4);
		x.removeMedia(dvd3);
		x.removeMedia(dvd2);
		x.removeMedia(dvd1);
		x.removeMedia(new DigitalVideoDisc("xyz"));
	}
}
