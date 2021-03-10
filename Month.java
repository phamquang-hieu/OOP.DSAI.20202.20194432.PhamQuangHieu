import java.util.Scanner;
public class Month{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String arr[] = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String arr_1[] = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String arr_2[] = {"", "Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
		int numMonth;
		boolean flag = false;
		int year;
		String month;
		while (true)
		{
			System.out.println("Enter value in the format \"year month\": ");
			year = s.nextInt();
			month = s.nextLine();
			month = month.trim();
			if(year < 0){
				System.out.println("Reinput");
				continue;
			}
			if(month.length() != 1)
			{
				for(numMonth = 0; numMonth< arr.length; ++numMonth)
					if(month.equals(arr[numMonth]))
					{
						flag = true;
						break;
					}
				if(flag) break;
				for(numMonth = 0; numMonth< arr_1.length; ++numMonth)
					if(month.equals(arr_1[numMonth]))
					{
						flag = true;
						break;
					}
				if(flag) break;
				for(numMonth = 0; numMonth< arr_2.length; ++numMonth)
				{
					if(month.equals(arr_2[numMonth]))
					{
						flag = true;
						break;
					}
				}
				if (flag) break;
				System.out.println("Reinput");
			}
			else{
				numMonth = Integer.parseInt(month);
				if(numMonth<= 12 && numMonth >= 1) break;
				else System.out.println("Reinput");
			}
		}
		int dayNum[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(numMonth == 2)
		{
			if(year %4 == 0 && year % 100 != 0)
			{
				System.out.println(dayNum[2] + 1);
			}
			else if(year % 4 == 0 && year % 100 == 0)
				if(year % 400 != 0) System.out.println(dayNum[2]);
				else System.out.println(dayNum[2] + 1);
			else
			{
				System.out.println(dayNum[numMonth]);
			}
		}
		else
		{
			System.out.println(dayNum[numMonth]);
		}
	}
}
