package java_.jdk8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName: DateApi
 * Description: jdk8 时间处理工具
 * Date: 2021年01月21日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class DateApi {

    /**
     * 获取日期区间
     *
     * @param start
     * @param end
     * @return
     */
    public static List<Integer> getBetweenDays(long start, long end) {
        List<Integer> dayList = new ArrayList<>();
        LocalDate startDate = millToDate(start).toLocalDate();
        LocalDate endDate = millToDate(end).toLocalDate();

        long betweenDays = endDate.toEpochDay() - startDate.toEpochDay();

        for (long i = 0; i <= betweenDays; i++) {
            LocalDate localDate = startDate.plusDays(i);
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            String monthStr = month + "";
            if (month < 10) {
                monthStr = "0" + month;
            }
            String dayStr = day + "";
            if (day < 10) {
                dayStr = "0" + day;
            }
            dayList.add(Integer.parseInt(year + monthStr + dayStr));
        }
        return dayList;
    }

    /**
     * 获取月份区间
     *
     * @param start
     * @param end
     * @return
     */
    public static List<Integer> getBetweenMonths(long start, long end) {
        List<Integer> dayList = new ArrayList<>();
        LocalDate startDate = millToDate(start).toLocalDate();
        LocalDate endDate = millToDate(end).toLocalDate();

        int result = endDate.getMonthValue() - startDate.getMonthValue();
        int month = (endDate.getYear() - startDate.getYear()) * 12;
        int betweenMonths = month + result;
        for (int i = 0; i <= betweenMonths; i++) {
            LocalDate localDate = startDate.plusMonths(i);
            int year = localDate.getYear();
            int monthValue = localDate.getMonthValue();
            String monthStr = monthValue + "";
            if (monthValue < 10) {
                monthStr = "0" + monthValue;
            }
            dayList.add(Integer.parseInt(year + monthStr));
        }
        return dayList;
    }

    /**
     * 时间类型转化
     *
     * @param mill
     * @return
     * @see LocalDateTime
     * 转
     * @see Date
     */
    public static LocalDateTime millToDate(Long mill) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(mill), ZoneOffset.ofHours(8));
    }

    /**
     * 获取 年月日 时分秒
     */
    @Test
    public void queryDate() {
        Long timeStamp = 1614238651000L;
        LocalDateTime localDateTime = millToDate(timeStamp);
        int year = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println("year:" + year);
        System.out.println("monthValue:" + monthValue);
        System.out.println("dayOfMonth:" + dayOfMonth);
        System.out.println("dayOfWeek:" + dayOfWeek.getValue());
        System.out.println("hour:" + hour);
        System.out.println("minute:" + minute);
        System.out.println("second:" + second);
    }

    /**
     * 判断当前时间是否在[start, end]区间
     *
     * @param now    当前时间
     * @param start  开始时间
     * @param end    结束时间
     * @param format 时间格式
     * @return
     */
    public static boolean timeIsInRound(String now, String start, String end, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date nowTime = null;
        Date beginTime = null;
        Date endTime = null;

        try {
            nowTime = df.parse(now);
            beginTime = df.parse(start);
            endTime = df.parse(end);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (nowTime.getTime() >= beginTime.getTime() && nowTime.getTime() <= endTime.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        List<Integer> dayList = getBetweenDays(1607043633000L, 1612400433000L);
        List<Integer> dayList = getBetweenDays(1612248752000L, 1612454400000L);
        List<Integer> monthList = getBetweenMonths(1607043633000L, 1612400433000L);
        log.info("dayList: [{}]", dayList);
        log.info("monthList: [{}]", monthList);

        //比较一个 HH:mm:ss 是否在一个时间段内
        System.out.println(timeIsInRound("15:10:02", "13:00:00", "21:30:00", "HH:mm:ss"));
    }

}
