
public class Cart {
	private int qtyOrdered = 0;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Your cart is almost full!");
			return;
		}
		itemsOrdered[qtyOrdered++] = disc;
		System.out.println("The disc "+ disc.getTitle()+ " has been added");
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
	
}
