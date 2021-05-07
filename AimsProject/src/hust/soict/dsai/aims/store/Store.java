package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private int inStockQty=0;
	
	//Store menu
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("-------------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("-------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	
	// Store functions
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
		System.out.println("Number of items in store: " + this.inStockQty);
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
				System.out.println("Number of items in store: " + this.inStockQty);
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
	
	public boolean showStore() {
		// view store
		if(this.inStockQty == 0) {
			System.out.println("");
			System.out.println("Your store is empty");
			return false; // the store is empty
		}
		System.out.println("----------------------------------------------");
		System.out.println("Items in store:");
		int storeId = 0;
		for(Media m: this.itemsInStore) {
			storeId++;
			System.out.println(Integer.toString(storeId)+". " + m.getTitle());
		}
		return true; // the store is not empty
	}
	
	private int checkPlayable(Media m) {
		// 0: DVD
		// 1: CD
		if(m instanceof DigitalVideoDisc)
			return 0;
		if(m instanceof CompactDisc) 
			return 1;
		return -1;
	}
	
	public void viewMedia(Cart userCart) {
		while (true) {
			// see a media's details
			// return true if the user wants to continue viewing items
			// return false if he/she wants to go back
			if(this.showStore())
			{
				Scanner s = new Scanner(System.in);
				System.out.println("");
				System.out.println("Please enter the id number of the item you want to see");
				System.out.println("0. Back");
				int storeId = s.nextInt();
				
				if(storeId == 0) break;
				if (storeId < 0 || storeId > this.inStockQty) {
					System.out.println("you have input a wrong Id!");
					continue;
				}
				
				while (true) {
					Media tmp = this.itemsInStore.get(storeId - 1);
					System.out.println(tmp.getDetails());
					System.out.println("0. back");
					System.out.println("1. Add this items to my cart");
					int playType = checkPlayable(tmp);
					if (playType != -1) {
						System.out.println("2. Play");
						System.out.println("Please choose a number: 0-1-2");
					} else {
						System.out.println("Please choose a number: 0-1");
					}
					int localOption = s.nextInt();
					if (localOption == 0)
						break;
					if (localOption == 1) {
						userCart.addMedia(tmp);
						break;
					}
					if (localOption == 2 && playType != -1) {
						if (playType == 0) {
							DigitalVideoDisc x = (DigitalVideoDisc) tmp;
							x.play();
							break;
						}
						CompactDisc x = (CompactDisc) tmp;
						x.play();
						break;
					}
					System.out.println("You have input wrong option!");
					continue;
				}
			}
			break;
		}
		
	}
	
	public void addMediaToCart(Cart userCart) {
		Scanner s = new Scanner(System.in);
		while (true) {
			// add a media to cart from current store
			if (this.showStore()) {
				System.out.println("Please enter the title of the item you want to add");
				String inpTitle = s.nextLine();
				int idInStore = this.itemsInStore.indexOf(new DigitalVideoDisc(inpTitle));
				if (idInStore != -1)
					userCart.addMedia(this.itemsInStore.get(idInStore));
				else
				{
					System.out.println("You have input a wrong name!");
					continue; // still want to add more items
				}
			}
			else break;
			
			System.out.println("");
			System.out.println("Do you want to continue adding items?");
			System.out.println("input: 'y': continue, anycase: stop");
			String inpOption = s.nextLine();
			if(inpOption.equals("y")) continue;
			break;
		}
	}
	
	public void playAMedia(){
		// play a media in store
		Scanner s = new Scanner(System.in);
		while (true) {
			if (this.showStore()) {
				System.out.println("Please enter the title of the item you want to play");
				System.out.println("0. Back");
				String inpTitle = s.nextLine();
				if(inpTitle.equals("0")) break;
				int idInStore = this.itemsInStore.indexOf(new DigitalVideoDisc(inpTitle));
				if (idInStore != -1) {
					Media tmp = this.itemsInStore.get(idInStore);
					int playType = checkPlayable(tmp);
					if (playType == 0) {
						DigitalVideoDisc x = (DigitalVideoDisc) tmp;
						x.play();
					} else if (playType == 1) {
						CompactDisc x = (CompactDisc) tmp;
						x.play();
					} else {
						System.out.println("This item is not playable!");
						continue;
					}
				} else {
					System.out.println("You have input a wrong name!");
					continue;
				}
				System.out.println("Do you want to continue?");
				System.out.println("Input: 'y' to continue, any other key to stop");
				String inp = s.nextLine();
				if (inp.equals("y")) {
					continue;
				}
				break;
			}
			// showStore return 1 if the store is not empty
			break;
		}
		
	}
	
	public void updateStoreMenu() {
		while (true) {
			// add a media to cart 
			// menu
			System.out.println("Please enter your option: ");
			System.out.println("1. Insert an item");
			System.out.println("2. Remove an item");
			System.out.println("0. Back");
			Scanner s = new Scanner(System.in);
			int localOption0 = s.nextInt();
			if (localOption0 == 1) {
				while (true) {
					System.out.println("Which kind of items do you want to insert?");
					System.out.println("1. Digital Video Disc");
					System.out.println("2. Compact Disc");
					System.out.println("3. Book");
					System.out.println("0. Back");
					System.out.println("Please enter your option: 0-1-2-3");
					int localOption = s.nextInt();
					if (localOption == 0)
						break;
					if (localOption == 1) {
						this.addMedia(DigitalVideoDisc.initNewDVD());
						continue;
					} else if (localOption == 2) {
						this.addMedia(CompactDisc.initNewCD());
						continue;
					} else if (localOption == 3) {
						this.addMedia(Book.initNewBook());
						continue;
					}
					System.out.println("you have input a wrong option!");
				}
			} else if (localOption0 == 2) {
				if(this.showStore())
					while (true) {
						System.out.println("Please enter the storeID of the item you want to delete");
						System.out.println("0. Back");
						int localOption = s.nextInt();
						if (localOption == 0)
							break;
						if (localOption < 0 || localOption > this.inStockQty) {
							System.out.println("You have input a wrong ID");
							continue;
						}
						this.itemsInStore.remove(localOption - 1);
						this.inStockQty--;
					}
			} else if (localOption0 == 0) {
				break;
			} else {
				System.out.println("You have input a wrong option!");
			}
		}
		
	}	

}
