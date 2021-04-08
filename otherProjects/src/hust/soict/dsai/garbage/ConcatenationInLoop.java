package hust.soict.dsai.garbage;

public class ConcatenationInLoop {
	public static void main(String args[]) {
		String data = "Each student is expected to turn in his or her own work and not give or receive unpermitted aid. Otherwise,\r\n"
				+ "we would apply extreme methods for measurement to prevent cheating. Please note that you need\r\n"
				+ "to write down answers for all questions into a text file and submit within the folder of the lab";
		String res1 = new String("");
		long startTime = System.currentTimeMillis();
		for(int j = 0; j < 1000; ++j)
			for(int i = 0; i < data.length(); ++i)
				res1 += data.charAt(i);
		long endTime = System.currentTimeMillis();
		System.out.println("running time for concatenation in Loop using \"+\": " + (endTime - startTime));
		
		StringBuffer res2 = new StringBuffer("");
		startTime = System.currentTimeMillis();
		for(int j = 0; j < 1000; ++j)
			for(int i = 0; i < data.length(); ++i)
				res2.append(data.charAt(i));
		endTime = System.currentTimeMillis();
		System.out.println("running time for concatenation in Loop using \"StringBuffer\": " + (endTime - startTime));
	}
}
