
public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", 18.99f);
		
		anOrder.addDigitalVideoDisc(dvd3);
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.removeDigitalVideoDisc(dvd3);
		System.out.println("The number of discs remaining in cart is " + anOrder.getQtyOrdered());
		System.out.println("Total Cost after the removal is " + anOrder.totalCost());
		
		anOrder.removeDigitalVideoDisc(dvd2);
		System.out.println("The number of discs remaining in cart is " + anOrder.getQtyOrdered());
		System.out.println("Total Cost after the removal is " + anOrder.totalCost());
		
		anOrder.removeDigitalVideoDisc(dvd1);
		System.out.println("The number of discs remaining in cart is " + anOrder.getQtyOrdered());
		System.out.println("Total Cost after the removal is " + anOrder.totalCost());
		
		anOrder.removeDigitalVideoDisc(dvd1);
		System.out.println("The number of discs remaining in cart is " + anOrder.getQtyOrdered());
		System.out.println("Total Cost after the removal is " + anOrder.totalCost());
	}

}
