import java.util.Scanner;
public class Triangle
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int tmp = x;
		for(int i = 1; i<= x; ++i)
		{
			for(int j = 0; j< x - i; ++j)
				System.out.print(" ");
			for(int k = 0; k < 1+ 2*(i-1); ++k)
				System.out.print("*");
			System.out.println();
		}
	}
}