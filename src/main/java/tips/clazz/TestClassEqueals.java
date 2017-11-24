package tips.clazz;

import org.junit.Test;

/**
 * 
 * @Description: 看实例化的类是不是自己期望的类
 * 
 * new A() instanceof B:如果A继承B，也会返回true
 * 
 * new A().getclass().equeals(B.class):如果A继承B，会返回false（）
 * 
 * @author yaoyao
 *
 */
public class TestClassEqueals {

	@Test
	public void test() {
		A a = new A();
		Zi zi = new Zi();
		Fu fu = new Fu();
		
		System.out.println(a instanceof A);//true
		System.out.println(zi instanceof Fu);//true
		
		System.out.println(a.getClass().equals(A.class));//true
		System.out.println(new A().getClass().equals(Fu.class));//false
		
	}
	
}

class A {}

class Zi extends Fu {}

class Fu {}
