package hust.soict.dsai.garbage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GarbageCreator {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f = new File("phamhieu.txt");
		Scanner s = new Scanner(f);
		String data = "";
		for(int i = 0; i< 10000000; ++i) {
			while(s.hasNextLine()) {
				data += s.nextLine() + "\n";
			}
			System.out.println(data);
		}
	}
}
