package hust.soict.dsai.Lab01.Exercise66.src;

import java.util.Scanner;

public class AddMatrix
{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n, m;
		System.out.println("Enter the number of rows of the 2 matrix");
		n = s.nextInt();
		System.out.println("Enter the number of column of the 2 matrix");
		m = s.nextInt();
		double mat1[] = new double[(n*m)];
		double mat2[] = new double[(n*m)];
		int i = 0;
		System.out.println("Enter element of mat1 from left ->right, up->down");
		for(i = 0; i < m*n; ++i)
			mat1[i] = s.nextDouble();
		System.out.println("Enter element of mat2 from left ->right, up->down");
		for(i = 0; i< m*n; ++i)
			mat2[i] = s.nextDouble();
		double mat3[] = new double[n*m];
		System.out.println("The sum of the 2 matrix is: ");
		for(i = 0; i< m*n; ++i)
			mat3[i] = mat1[i] + mat2[i];
		for(i = 1; i<=(m*n); ++i)
		{
			System.out.print(mat3[i-1] + " ");
			if(i % m == 0) System.out.println();
		}
	}
}