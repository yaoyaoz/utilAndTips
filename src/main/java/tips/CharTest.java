package tips;

import org.junit.Test;

public class CharTest {

	@Test
	public void charTest() {
		String certNo = "440524188001010014";
		char[] certNoArr = certNo.toCharArray();
		
		int a = (certNoArr[0] - 48) * 7;
		System.out.println("a:" + a);//a:28
		
		int b = certNoArr[0] * 7;
		System.out.println("b:" + b);//b:364=52*7
		
		int c = (char)48 * 7;
		System.out.println("c:" + c);//c:336=48*7
		System.out.println("(char)48:" + (char)48);//(char)48:0
		
		char char52 = 52;
		System.out.println("char52:" + char52);//char52:4
	}

}
/**
 ���⣺
1��Ϊʲô(char)48=0����(char)48 * 7ȴ=48*7=336�أ�
 */
