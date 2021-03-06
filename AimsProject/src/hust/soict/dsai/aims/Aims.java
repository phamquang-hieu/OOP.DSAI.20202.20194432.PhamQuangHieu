package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("-------------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store ");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("-------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void main(String[] args) {
		Store newStore = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars", "Science Fiction", 24.95f,"George Lucas", 87);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("abc");
		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3, dvd4};
		newStore.addMedia(dvdList);
		Cart newCart = new Cart();
		new StoreScreen(newStore, newCart);
		while(true){
			Aims.showMenu();
			Scanner s = new Scanner(System.in);
			int option0 = s.nextInt();
			
			if(option0 == 0) break;
			if(option0 == 1){
				// View store
				while(true) {
					newStore.showStore();
					Store.storeMenu();				
					
					
					int option1 = s.nextInt();
					
					if(option1 == 0) break;
					else if(option1 == 1) {
						// See a media's details
						newStore.viewMedia(newCart); // in take the newCart in case user want to add this media to their cart.
					}
					else if(option1 == 2) {
						// Add a media to cart
						newStore.addMediaToCart(newCart);
					}
					else if(option1 == 3) {
						// play a media
						newStore.playAMedia();
					}
					else if(option1 == 4) {
						//new CartScreen(newCart);
						newCart.cartMenuOption();
					}
				}
				continue; // continue showMenu() of Aims;
			}
			else if (option0 == 2) {
				newStore.updateStoreMenu();
			}
			else if (option0 == 3) {
				// see Current cart
				newCart.cartMenuOption();
				//new CartScreen(newCart);
			}
		}
	
	
	
	
	}
}
