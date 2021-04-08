package hust.soict.dsai.garbage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class NoGarbage {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f = new File("phamhieu.txt");
		Scanner s = new Scanner(f);
		StringBuffer data = new StringBuffer("");
		for(int i = 0; i< 10000000; ++i) {
			while(s.hasNextLine()) {
				data.append(s.nextLine() + "\n");
			}
			System.out.println(data);
		}
	}
}
