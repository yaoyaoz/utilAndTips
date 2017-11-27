package tips.imprecision;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 
 * @Description: 
 * new BigDecimal(double) 精度不一定准确
 * 
 * jenkis对于new BigDecimal(double)的提示：
 * Because of floating point imprecision, 
 * you're unlikely to get the value you expect from the BigDecimal(double) constructor. 
 * 
 * 解决方式：Use "BigDecimal.valueOf" instead.
 * 
 * @author yaoyao
 *
 */
public class TestValueOf {

	@Test
	public void test() {
		double d = 36.9097;
    	BigDecimal b1 = new BigDecimal(d);
    	BigDecimal b2 = BigDecimal.valueOf(d);
    	System.out.println(b1);//36.9097000000000008412825991399586200714111328125
    	System.out.println(b2);//36.9097
	}
	
}
