package string;

import org.junit.Test;

/**
 * Created by yaoyao on 2018/6/27.
 */
public class StringTest {

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

}
