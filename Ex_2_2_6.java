import java.util.Scanner;
class Ex_2_2_6{
	static void firstOrder(double a, double b)
	{
		if(a!= 0) System.out.println((-b)/a);
		else if (a == 0 && b != 0) System.out.println("a = 0 -> no solution");
		else System.out.println("infinitely many solution");
	}
	static void firstOrderSystem(double a, double b, double c, 
								double d, double e, double f)
	{
		double d1 = a*e - b*d;
		double dx = c*e - b*f;
		double dy = a*f - d*c;
		if(d1 != 0)
		{
			System.out.println("x = "+(dx/d1));
			System.out.println("y = "+(dy/d1));
		}
		else if((a/d) == (b/e) && (b/e) == (c/f))
		{
			System.out.println("infinitely many solution");
		}
		else
		{
			System.out.println("no solution");
		}
	}
	static void secondOrder(double a, double b, double c)
	{
		double delta = b*b - 4*a*c;
		if(delta > 0)
		{
			double x1 = (-b - Math.sqrt(delta))/(2*a);
			double x2 = (-b + Math.sqrt(delta))/(2*a);
			System.out.println("x1 = " + (x1) + " " + "x2= " + (x2));
		}
		else if(delta == 0)
		{
			double x = (-b/(2*a));
			System.out.println("x= " + x);
		}
		else
		{
			System.out.println("no solution");
		}
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int x;
		System.out.println("input: 1: first order; 2: system of firsr order ; 3: 2nd order");
		x = s.nextInt();
		switch(x)
		{
			case 1:
				double a1, b1;
				System.out.println("equation form: ax + b = 0");
				System.out.println("enter a: ");
				a1 = s.nextDouble();
				System.out.println("enter b: ");
				b1 = s.nextDouble();
				firstOrder(a1, b1);
				break;
			case 2:
				double a, b, c, d, e, f;
				a = s.nextDouble();
				b = s.nextDouble();
				c = s.nextDouble();
				d = s.nextDouble();
				e = s.nextDouble();
				f = s.nextDouble();
				firstOrderSystem(a, b, c, d, e, f);
				break;
			case 3: 
				double a2, b2, c2;
				a2 = s.nextDouble();
				b2 = s.nextDouble();
				c2 = s.nextDouble();
				secondOrder(a2, b2, c2);
				break;
		}
	}
}