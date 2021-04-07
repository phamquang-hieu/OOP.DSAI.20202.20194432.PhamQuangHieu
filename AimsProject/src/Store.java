
public class Store {
	private final int STORE_CAPACITY = 10000;
	DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[STORE_CAPACITY];
	private int inStockQty;
	public void addDVD(DigitalVideoDisc...dvdList)
	{
		int remainQty = dvdList.length;
		int i = 0;
		while(remainQty != 0)
		{
			itemsInStore[inStockQty++] = dvdList[i++];
			System.out.println("The disc "+ dvdList[i-1].getTitle()+ " has been added to your store." + " Id= " + dvdList[i-1].getId());
			remainQty--;
		}
		
		if(remainQty > 0)
		{
			System.out.println("Maximum capacity is " + STORE_CAPACITY + " discs");
			System.out.println("The following dvd hasn't been added due to a lack of space:");
			for(;i < dvdList.length; ++i)
			{
				System.out.println("\t+ "+ dvdList[i].getTitle());
			}
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		if (inStockQty == 0) {
			System.out.println("Your cart is empty!");
			return;
		}
		for (int i = 0; i < inStockQty; ++i) {
			if (itemsInStore[i].getId() != disc.getId()) {
				for (int j = i + 1; j < inStockQty; j++)
					itemsInStore[j - 1] = itemsInStore[j];
				System.out.println("The disc "+ disc.getTitle()+ " has been removed");
				inStockQty--;
				return;
			}
		}
		System.out.println("The disc given does not exist in your cart!");
	}
	
}
