package util;

import org.junit.Test;

/**
 * 检测文件头是否带BOM，过滤测试类
 *
 * 问题：copy的别人的代码StringBomUtil，有空研究下字符串转码
 *
 * Created by yaoyao on 2018/12/3.
 */
public class StringBomUtilTest {

    @Test
    public void testFilterBom() {
        String s1 = "RF服装创意工作室1";
        byte[] b1 = s1.getBytes();//b1.length=24
        String s2 = "\uFEFFRF服装创意工作室1";
        byte[] b2 = s2.getBytes();//b2.length=27    b2比b1前面多了3个头：-17 -69 -65

        if (s1.equals(s2)) {
            System.out.println("过滤BOM前，s1和s2编码一致");
        } else {
            System.out.println("过滤BOM前，s1和s2编码不一致");
        }

        if (StringBomUtil.filterBom(s1).equals(StringBomUtil.filterBom(s2))) {
            System.out.println("过滤BOM后，s1和s2编码一致");
        } else {
            System.out.println("过滤BOM后，s1和s2编码不一致");
        }
    }

}
/**
 过滤BOM前，s1和s2编码不一致
 过滤BOM后，s1和s2编码一致
 */
