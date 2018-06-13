package util;

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

}
