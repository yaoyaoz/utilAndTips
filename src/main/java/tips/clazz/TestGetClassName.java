package tips.clazz;

import org.junit.Test;

/**
 * 
 * @Description: 通过类得到类的名字
 * 
 * @author yaoyao
 *
 */
public class TestGetClassName {

	@Test
	public void test() {
		System.out.println(AAA.class.getName());//tips.clazz.AAA
		System.out.println(AAA.class.getSimpleName());//AAA
	}
	
}

class AAA {}
