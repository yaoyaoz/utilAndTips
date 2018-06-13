package util;

import org.junit.Test;

import java.util.Date;

/**
 * 时间工具测试类
 * Created by yaoyao on 2018/5/30.
 */
public class DateUtilsTest {

    /**
     * 测试获取指定年月日的时间
     */
    @Test
    public void testGetDate() {
        Date date1 = DateUtils.getDate1(2018, 5, 30);
        System.out.println(date1.toLocaleString());
        /**
         2018-5-30 14:24:48
         */

        Date date2 = DateUtils.getDate2(2018,5,30);
        System.out.println(date2.toLocaleString());
        /**
         2018-5-30 14:24:48
         */
    }

}
