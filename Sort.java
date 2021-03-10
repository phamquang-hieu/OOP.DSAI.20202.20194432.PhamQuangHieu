import java.util.Scanner;

public class Sort{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("enter the number of element:");
		int n = s.nextInt();
		int i;
		int arr[] = new int[n];
		for(i = 0; i<n; ++i)
		{
			arr[i] = s.nextInt();
		}
		for(i = 0; i<n; ++i)
			for(int j = i+1; j<n; ++j)
				if(arr[i] > arr[j])
				{
					int tmp;
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
		for(i = 0; i<n; ++i)
			System.out.print(arr[i] + " ");
	}
}