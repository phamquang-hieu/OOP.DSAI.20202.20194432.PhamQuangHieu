import java.util.Scanner;

public class Ex_6_2{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("What's your name?");
		String strName = s.nextLine();
		System.out.println("How old are you?");
		int iAge = s.nextInt();
		System.out.println("How tall are you?");
		double dHeight = s.nextDouble();
		
		System.out.println("Mr/Mrs. " + strName + ", " + iAge + " years old. " +
		"Your height is " + dHeight + ".");
	}

}
