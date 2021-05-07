package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	private int qtyOrdered = 0;
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public Cart() {
		
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public boolean addMedia(Media newMedia) {
		if(itemsOrdered.contains(newMedia)) {
			System.out.println("This item is already in your cart!");
			return false; //fail
		}
		itemsOrdered.add(newMedia);
		System.out.println(newMedia.getTitle() + " has been added!");
		qtyOrdered++;
		System.out.println("Number of items in cart:" + this.qtyOrdered);
		return true; //success
	}
	
	public void addMedia(Media...mediaList)
	{
		for(Media medium: mediaList) {
			this.addMedia(medium);
		}
	}
	
	public boolean removeMedia(Media newMedia) {
		Iterator<Media> itr = itemsOrdered.iterator();
		while(itr.hasNext()) {
			Media tmp = itr.next();
			if(tmp.getTitle().toLowerCase().equals(newMedia.getTitle().toLowerCase())) {
				itr.remove();
				System.out.println("item: "+newMedia.getTitle()+ " has been removed!");
				qtyOrdered--;
				System.out.println("Number of remaining items in cart: " + this.qtyOrdered);
				return true; // success
			}
		}
		System.out.println("No match found for item: "+newMedia.getTitle());
		return false; // fail
	}
	
	public void removeMedia(Media...mediaList) {
		for(Media medium: mediaList) {
			this.removeMedia(medium);
		}
	}
	
	public boolean searchByTitle(String title) {
		for(Media m: itemsOrdered)
			if(m.getTitle().toLowerCase().equals(title)) {
				System.out.println(m.getDetails());
				return true;
			}
		System.out.println("No match found for item: "+title);
		return false;
	}
	
	public boolean searchById(int id) {
		for (Media m: itemsOrdered)
			if(m.getId() == id)
			{
				System.out.println(m.getDetails());
				return true;
			}
		System.out.println("No match found for item with id= " + id);
		return false;
	}
	
	public float totalCost()
	{
		float cost = 0f;
		for(Media m: itemsOrdered)
			cost += m.getCost();
		return cost;
	}

	public boolean showCart()
	{
		if(this.qtyOrdered == 0) {
			System.out.println("Your cart is empty!");
			return false;
		}
		System.out.println("***********************CART***********************");
		for(Media m: itemsOrdered)
		{
			System.out.println(m.getDetails());
		}
		System.out.print("Total Cost: ");
		System.out.println(totalCost());
		System.out.println("**************************************************\n");
		return true;
	}
	
	public void sortMediaByCostTitle() {
		this.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
		System.out.println("Your cart has been sorted by Cost -> Title");
		this.showCart();
	}
	
	public void sortMediaByTitleCost() {
		this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
		System.out.println("Your cart has been sorted by  Title -> Cost");
		this.showCart();
	}
	
	public void placeOrder() {
		// placeOrder function
		this.itemsOrdered.clear();
		System.out.println("An order has been created");
		return;
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
	
	public void playAMedia(){
		// play a media function
		Scanner s = new Scanner(System.in);
		while (true) {
			if (this.showCart()) {
				System.out.println("Please enter the title of the item you want to play");
				String inpTitle = s.nextLine();
				int idInStore = this.itemsOrdered.indexOf(new DigitalVideoDisc(inpTitle));
				if (idInStore != -1) {
					Media tmp = this.itemsOrdered.get(idInStore);
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
			// this.showCart return 1 if the cart is not empty
			// if the cart is empty
			break;
		}
		
	}
	
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("----------------------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a medium");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("----------------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	private void filterInCart() {
		System.out.println("");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		Scanner s = new Scanner(System.in);
		int localOption1 = s.nextInt();
		if (localOption1 == 0){
			// Back
			return;
		}
		Scanner strScanner = new Scanner(System.in);
		if (localOption1 == 1) {
			System.out.println("Please enter media ID to search");
			this.searchById(s.nextInt());
		} else if (localOption1 == 2) {
			System.out.println("Please enter the title to search");
			this.searchByTitle(strScanner.nextLine());
		}
	}
	
	private void sortInCart() {
		System.out.println("1. Sort by Title->Cost");
		System.out.println("2. Sort by Cost ->Title");
		System.out.println("0. Back");
		Scanner s = new Scanner(System.in);
		int localOption1 = s.nextInt();
		if (localOption1 == 0) {
			return;
		}
		if (localOption1 == 1) {
			this.sortMediaByTitleCost();
		} else if (localOption1 == 2) {
			this.sortMediaByCostTitle();
		}
	}
	
	public void removeInCart() {
		Scanner strScanner = new Scanner(System.in);
		System.out.println("Please input the name of the items you want to delete");
		String inpTitle = strScanner.nextLine();
		this.removeMedia(new DigitalVideoDisc(inpTitle)); // instantiated type is not important because we have override equals in Media.
	}
	
	public void cartMenuOption() {
		Scanner s = new Scanner(System.in);
		Scanner strScanner = new Scanner(System.in);
		while(true) {
			if (this.showCart()) {
				Cart.cartMenu();
				int localOption0 = s.nextInt();
				if (localOption0 == 0)
					break;
				if (localOption0 == 1) {
					this.filterInCart(); // filter in cart
				} else if (localOption0 == 2) {
					this.sortInCart(); // sort in cart
				} else if (localOption0 == 3) {
					this.removeInCart(); // remove an item in cart
				} else if (localOption0 == 4) {
					this.playAMedia(); // play a medium in cart
				} else if (localOption0 == 5) {
					this.placeOrder(); // place a new order
				} 
			}
			else break;
		}

	}
	
	
}
