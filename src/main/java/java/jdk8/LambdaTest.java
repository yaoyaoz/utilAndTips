package java.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: Lambda表达式
 *
 * @author yaoyao
 */
public class LambdaTest {

    //1、我们经常像这个代码一样写一些匿名内部类
    @Test
    public void test1() {
        List<String> list = Arrays.asList("danae", "lucy", "amy", "emilie");
        Collections.sort(list, new Comparator<String>() {
            //问题：Comparator里面这么多方法，为什么必须要实现compare(T o1, T o2)呢？compare也不是抽象方法呀
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);//问题：这个是按着什么规则来排序的？
            }
        });
        System.out.println(list);//[amy, danae, emilie, lucy]
    }

    //2、在Java 8我们可以通过Lambda来代替这种编程
    @Test
    public void test2() {
        List<String> list = Arrays.asList("danae", "lucy", "amy", "emilie");
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        System.out.println(list);//[amy, danae, emilie, lucy]
    }

}
