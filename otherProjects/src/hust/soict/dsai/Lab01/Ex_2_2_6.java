package hust.soict.dsai.Lab01;

import java.util.Scanner;
class Ex_2_2_6{
	static void firstOrder(double a, double b)
	{
		if(a!= 0) System.out.println((0-b)/a);
		else if (a == 0 && b != 0) System.out.println("a = 0 && b!= 0 -> no solution");
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
				System.out.println("Solving system of equation:");
				System.out.println("ax + by = c");
				System.out.println("dx + ey = f");
				System.out.println("a= ");
				a = s.nextDouble();
				System.out.print("b= ");
				b = s.nextDouble();
				System.out.print("c= ");
				c = s.nextDouble();
				System.out.print("d= ");
				d = s.nextDouble();
				System.out.print("e= ");
				e = s.nextDouble();
				System.out.print("f= ");
				f = s.nextDouble();
				firstOrderSystem(a, b, c, d, e, f);
				break;
			case 3: 
				double a2, b2, c2;
				System.out.println("Solving second order equation: ax^2 +  bx + c = 0");
				System.out.print("a= ");
				a2 = s.nextDouble();
				System.out.print("b= ");
				b2 = s.nextDouble();
				System.out.print("c= ");
				c2 = s.nextDouble();
				if(a2 != 0) secondOrder(a2, b2, c2);
				else firstOrder(b2, c2);
				break;
		}
	}
}