package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.disc.WrapperDigitalVideoDisc;

public class TestPassingParameter {

	public static void swap(Object o1, Object o2){
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	public static void realSwap(WrapperDigitalVideoDisc o1, WrapperDigitalVideoDisc o2)
	{
		DigitalVideoDisc tmp = o1.dvd;
		o1.dvd = o2.dvd;
		o2.dvd = tmp;
	}
	public static void main(String[] args) {

		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		swap(jungleDVD, cinderellaDVD);
		System.out.println(jungleDVD.getTitle());
		System.out.println(cinderellaDVD.getTitle());
		
		WrapperDigitalVideoDisc wJungleDVD = new WrapperDigitalVideoDisc(jungleDVD);
		WrapperDigitalVideoDisc wCinderellaDVD = new WrapperDigitalVideoDisc(cinderellaDVD);
		realSwap(wJungleDVD, wCinderellaDVD);
		System.out.println(jungleDVD.getTitle());
		System.out.println(cinderellaDVD.getTitle());
	}
	
}
