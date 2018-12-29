package pku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws IOException {
		sun.misc.BASE64Decoder d = new sun.misc.BASE64Decoder();
		String userName = new String(d.decodeBuffer("bGlkdWFu"));
		System.out.println(userName);
		
		sun.misc.BASE64Encoder e = new sun.misc.BASE64Encoder();
		System.out.println(e.encodeBuffer("liduan".getBytes()));
	}

}
