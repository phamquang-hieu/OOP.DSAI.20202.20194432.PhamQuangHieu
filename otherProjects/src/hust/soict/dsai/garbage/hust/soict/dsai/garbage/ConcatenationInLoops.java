package hust.soict.dsai.garbage;

public class ConcatenationInLoops {
	public static void main(String args[])
	{
		String str = new String("Chúng ta của hiện tại, em dành cả thanh xuân cho anh. "
				+ "Anh dành cả thanh xuân cho em. Chúng ta dành cả thanh xuân cho nhau mà không hề nghĩ suy. "
				+ "Gặp nhau là duyên phận, xa nhau cũng là duyên phận. "
				+ "Chẳng ai biết tương lai sau này. Dù sau này có nhau hay không thể bên nhau cũng đừng quên rằng "
				+ "chúng ta đã dành tất cả điều tuyệt vời nhất cho nhau. Thương em");
		StringBuilder res = new StringBuilder("");
		long startTime, endTime;
		startTime = System.currentTimeMillis();
		int c = 0;
		while(c < 1000)
		{
			for(int i = 0; i< str.length(); ++i)
			{
				res.append(str.charAt(i));
			}
			//System.out.println(res);
			c++;
		}
		endTime = System.currentTimeMillis();
		System.out.println("totaltime: "+ (endTime -startTime));
		
	}
}
