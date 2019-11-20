package java_.jdkapi.string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * 截取字符串的某一段内容：
     * 使用正则表达式.
     */
    @Test
    public void test() {
        String filetext = "//@张小名: 25分//@李小花: 43分//@王名: 100分";
        /*
        正则表达式：
        .       任何字符（与行结束符可能匹配也可能不匹配）
        *?      零次或多次
        ()      代表分组
         */
        Pattern p = Pattern.compile("\\@(.*?)(名)\\:");
        Matcher m = p.matcher(filetext);
        System.out.println("分组个数，从0开始计数：" + m.groupCount());
        while(m.find()) {
            System.out.println("[0]=" + m.group(0) + "\t\t\t\t[1]=" + m.group(1) + "\t\t\t\t[2]=" + m.group(2));
        }
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

    /**
     * 字符串补位：
     * String.format("%0" + 3 + "d", 12)
     * 如果12不足3位，则在前面用0补足3位
     */
    @Test
    public void testFormat() {
        String s1 = String.format("%0" + 3 + "d", 12);
        System.out.println(s1);
    }

}
