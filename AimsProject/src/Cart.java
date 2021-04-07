
public class Cart {
	private int qtyOrdered = 0;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	private boolean fullyLoaded(){
		if (qtyOrdered != MAX_NUMBERS_ORDERED) return false;
		System.out.println("Your cart is almost full!");
		return true;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(fullyLoaded()) return;
		itemsOrdered[qtyOrdered++] = disc;
		System.out.println("The disc "+ disc.getTitle()+ " has been added" + " Id = " + disc.getId());
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc...dvdList)
	{
		if (fullyLoaded()) return;
		int remainQty = dvdList.length;
		int i = 0;
		while(qtyOrdered < MAX_NUMBERS_ORDERED && remainQty != 0)
		{
			itemsOrdered[qtyOrdered++] = dvdList[i++];
			System.out.println("The disc "+ dvdList[i-1].getTitle()+ " has been added." + " Id= " + dvdList[i-1].getId());
			remainQty--;
		}
		
		if(remainQty > 0)
		{
			System.out.println("Maximum capacity is " + MAX_NUMBERS_ORDERED + " discs");
			System.out.println("The following dvd hasn't been added due to a lack of space:");
			for(;i < dvdList.length; ++i)
			{
				System.out.println("\t+ "+ dvdList[i].getTitle());
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
	{
		if(fullyLoaded()) return;
		if(MAX_NUMBERS_ORDERED - qtyOrdered == 1) this.addDigitalVideoDisc(dvd1);
		else
		{
			this.addDigitalVideoDisc(dvd1);
			this.addDigitalVideoDisc(dvd2);
		}
	}
	
	public boolean searchByTitle(String title) {
		for (int i = 0; i < qtyOrdered; ++i)
			if(itemsOrdered[i].getTitle() == title)
			{
				String[] data = itemsOrdered[i].getDetails();
				System.out.print("DVD - "+ data[0] +" - " + data[1] + " - " + data[2] + " - " + 
						data[3] + ": " + data[4] + "$\n");
				return true;
			}
		System.out.println("No match DVD found!");
		return false;
	}
	public boolean searchById(int id) {
		for (int i = 0; i < qtyOrdered; ++i)
			if(itemsOrdered[i].getId() == id)
			{
				String[] data = itemsOrdered[i].getDetails();
				System.out.print("DVD - "+ data[0] +" - " + data[1] + " - " + data[2] + " - " + 
						data[3] + ": " + data[4] + "$\n");
				return true;
			}
		System.out.println("No match DVD found!");
		return false;
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("Your cart is empty!");
			return;
		}
		for (int i = 0; i < qtyOrdered; ++i) {
			if (itemsOrdered[i].getTitle() == disc.getTitle() && itemsOrdered[i].getDirector() == disc.getDirector()) {
				for (int j = i + 1; j < qtyOrdered; j++)
					itemsOrdered[j - 1] = itemsOrdered[j];
				System.out.println("The disc "+ disc.getTitle()+ " has been removed");
				qtyOrdered--;
				return;
			}
		}
		System.out.println("The disc given does not exist in your cart!");
	}
	public float totalCost()
	{
		float cost = 0f;
		for(int i = 0; i < qtyOrdered; ++i)
			cost += itemsOrdered[i].getCost();
		return cost;
	}
	
	public void print()
	{
		System.out.println("***********************CART***********************");
		for(int i = 0; i < qtyOrdered; ++i)
		{
			String[] data = itemsOrdered[i].getDetails();
			System.out.print("DVD - "+ data[0] +" - " + data[1] + " - " + data[2] + " - " + 
								data[3] + ": " + data[4] + "$\n");
		}
		System.out.print("Total Cost: ");
		System.out.println(totalCost());
		System.out.println("**************************************************\n");
	}
	
	
}
