import java.util.Scanner;
public class Ex_2_2_5 {
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		double a, b;
		a = s.nextDouble();
		b = s.nextDouble();
		System.out.println("Sum: " + (a+b));
		System.out.println("a - b= " + (a-b));
		System.out.println("a/b = " + (a/b));
		System.out.println("a*b = " + (a*b));
	}
}
