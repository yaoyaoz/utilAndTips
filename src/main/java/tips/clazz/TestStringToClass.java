package tips.clazz;

import org.junit.Test;

/**
 * 
 * @Description: 通过类名（字符串）转换成类
 * 
 * @author yaoyao
 *
 */
public class TestStringToClass {

	@Test
	public void test() {
		try {
			/**
			 * 只能是全限定类名tips.clazz.AA；
			 * 如果是Class.forName("AA")，就会报错：java.lang.ClassNotFoundException: AA
			 */
			Class<?> clazz = Class.forName("AA");
			System.out.println(clazz);//class tips.clazz.AA
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
}

class AA {}