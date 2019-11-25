package util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 * Created by yaoyao on 2018/5/30.
 */
public class DateUtils {

    /**
     * 获取指定年月日的时间
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDate1(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);//设置年
        calendar.set(Calendar.MONTH, month - 1);//这里0是1月..以此向后推
        calendar.set(Calendar.DAY_OF_MONTH, day);//设置天
        Date date = calendar.getTime();
        return date;
    }

    /**
     * 获取指定年月日的时间
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDate2(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date date = calendar.getTime();
        return date;
    }

    @Test
    public void testTimeToDate() {
        long time1 = 1564466861;
        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time1 * 1000));
        System.out.println("10位数的时间戳（秒）--->Date:" + result1);
        Date date1 = new Date(time1*1000);   //对应的就是时间戳对应的Date

        double time2 = 1564468254003d;
        String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time2);
        System.out.println("13位数的时间戳（毫秒）--->Date:" + result2);
    }

    public static String dateString() {
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss:SSS");
        String date = SimpleDateFormat.format(new Date());
        return SimpleDateFormat.format(new Date());
    }

}
