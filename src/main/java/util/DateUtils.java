package util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    /**
     * 获取上(下)周周几的日期
     *
     * @param firstDayOfWeek {@link Calendar} 值范围 <code>SUNDAY</code>,
     *                       <code>MONDAY</code>, <code>TUESDAY</code>,
     *                       <code>WEDNESDAY</code>, <code>THURSDAY</code>,
     *                       <code>FRIDAY</code>, and <code>SATURDAY</code>
     * @param dayOfWeek      {@link Calendar}
     * @param weekOffset     周偏移，上周为-1，本周为0，下周为1，以此类推
     * @return
     */
    public static Date getDayOfWeek(Date date, int firstDayOfWeek, int dayOfWeek, int weekOffset) {
        if (dayOfWeek > Calendar.SATURDAY || dayOfWeek < Calendar.SUNDAY) {
            return null;
        }
        if (firstDayOfWeek > Calendar.SATURDAY || firstDayOfWeek < Calendar.SUNDAY) {
            return null;
        }
//        Calendar cal = Calendar.getInstance(Locale.CHINA);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(firstDayOfWeek);
        // 周数减一，即上周
        cal.add(Calendar.WEEK_OF_MONTH, weekOffset);
        // 天设为周几
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        // 时分秒全部置0
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取上周周几的日期,默认一周从周一开始
     *
     * @param dayOfWeek
     * @param weekOffset
     * @return
     */
    public static Date getDayOfWeek(Date date, int dayOfWeek, int weekOffset) {
        return getDayOfWeek(date, Calendar.MONDAY, dayOfWeek, weekOffset);
    }

    /*
    测试getDayOfWeek
     */
    @Test
    public void testGetDayOfWeek() {
        Date date = getDate1(2020, 8, 30);
        System.out.println(getDayOfWeek(date, Calendar.MONDAY, 0));
    }

}
