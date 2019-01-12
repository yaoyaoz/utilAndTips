package java.jdkapi.string;

import org.junit.Test;

/**
 * java.lang.String的jdk api方法测试
 *
 * Created by yaoyao on 2018/6/27.
 */
public class TestString {

    /**
     * string.substring[begin, end);
     */
    @Test
    public void testSubString() {
        String s = "123四五678";
        System.out.println(s.length());
        System.out.println(s.substring(0, 4));
        System.out.println(s.substring(0, s.length()));
        /**
         8
         123四
         123四五678
         */
    }

    /**
     * string.lastIndexOf()：
     * 返回当前角标向左第一次出现符号的角标，
     * 如果返回-1，则表示没找到
     */
    @Test
    public void testLastIndexOf() {
        /**
         * abc.de.fgh
         * 0123456789
         */
        String s1 = "abc.de.fgh";
        int flag1 = s1.lastIndexOf(".", 2);//flag1=-1
        int flag2 = s1.lastIndexOf(".", 5);//flag2=3
        int flag3 = s1.lastIndexOf(".", 9);//flag3=6
        System.out.println("flag1=" + flag1);
        System.out.println("flag2=" + flag2);
        System.out.println("flag3=" + flag3);
    }

}
