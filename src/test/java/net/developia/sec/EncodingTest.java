package net.developia.sec;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class EncodingTest {

	@Test
	public void sha512hexTest() {
		String str = "abcd111";
		System.out.println(DigestUtils.sha512Hex(str));
		System.out.println(DigestUtils.sha512Hex(str).length());
		
	}
}
