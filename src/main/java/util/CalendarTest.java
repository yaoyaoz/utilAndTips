package util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName: CalendarTest
 * Description: Calendar类简介
 * Date: 2020年08月31日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
@Slf4j
public class CalendarTest {

    /*
    Calendar与Date的转换
     */
    @Test
    public void test1() {
        //Calendar--->Date
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        //Date--->Calendar
        Date d1 = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        log.info("date:[{}]", date);
        log.info("[{}]年[{}]月[{}]日", c1.get(Calendar.YEAR), (c1.get(Calendar.MONTH)+1), c1.get(Calendar.DATE));
    }

    /*
    总结：time与field所代表时间点同步，所有的不同步全部在内部处理完成
     */
    @Test
    public void test2() throws ParseException {
        System.out.println("-------初始情况-------");
        Calendar c = Calendar.getInstance();
        System.out.println("c.getTime:" + c.getTime());
        System.out.println("c.get(Calendar.MONTH):" + c.get(Calendar.MONTH));
        System.out.println("c.get(Calendar.DATE):" + c.get(Calendar.DATE));
        System.out.println("c.get(Calendar.HOUR):" + c.get(Calendar.HOUR));

        System.out.println("\n-------重设置time-------");
        c.setTime(new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse("20170518 19:23:15"));
        System.out.println("c.getTime:" + c.getTime());
        System.out.println("c.get(Calendar.MONTH):" + c.get(Calendar.MONTH));
        System.out.println("c.get(Calendar.DATE):" + c.get(Calendar.DATE));
        System.out.println("c.get(Calendar.HOUR):" + c.get(Calendar.HOUR));

        System.out.println("\n-------重设置field-------");
        c.set(Calendar.MONTH, 2);
        System.out.println("c.getTime:" + c.getTime());
        System.out.println("c.get(Calendar.MONTH):" + c.get(Calendar.MONTH));
        System.out.println("c.get(Calendar.DATE):" + c.get(Calendar.DATE));
        System.out.println("c.get(Calendar.HOUR):" + c.get(Calendar.HOUR));
    }

    /*
    Calendar中的两种解析模式：
    lenient：该模式下可以自动规则化用户赋值给Calendar的不规则值，比如1月32日会被解析为2月1日
    non-lenient：该模式下不会自动解析不规则的输入，而是一旦发现不规则输入，就会报出异常
    true表示开启容错性（默认情况），false表示关闭该功能。
     */
    @Test
    public void test3() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 8);
        c.set(Calendar.DAY_OF_MONTH, 33);
        System.out.println("lenient为true，c.getTime()：" + c.getTime()+"\n");

        c.setLenient(false);
        c.set(Calendar.MONTH, 8);
        c.set(Calendar.DAY_OF_MONTH, 33);
        System.out.println(c.getTime());
    }

    /*
    Calendar的使用

    对比最后两行的输出，可以看出add与roll的运算规则其实是不同的，roll的运算不会影响大规则（这里的大规则指的是月份的改变）的改变，而add会影响。
     */
    @Test
    public void test4() throws ParseException {
        //通过SimpleDateFormat解析日期字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss.SSS");
        Date date = sdf.parse("20200901 13:33:23.433");
        //将Date格式日期转换成Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获取时间值
        System.out.println(cal.getTime());
        System.out.println("年份YEAR为："+cal.get(Calendar.YEAR));
        System.out.println("月份MONTH为："+cal.get(Calendar.MONTH));
        System.out.println("日期DATE为："+cal.get(Calendar.DATE));
        System.out.println("日期DAY_OF_MONTH为："+cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("日期DAY_OF_WEEK为："+cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("日期为DAY_OF_WEEK_IN_MONTH："+cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("日期为DAY_OF_YEAR："+cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("时HOUR为："+cal.get(Calendar.HOUR));
        System.out.println("时HOUR_OF_DAY为："+cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分MINUTE为："+cal.get(Calendar.MINUTE));
        System.out.println("秒SECOND为："+cal.get(Calendar.SECOND));
        System.out.println("毫秒MILLISECOND为："+cal.get(Calendar.MILLISECOND));
        System.out.println("星期WEEK_OF_MONTH为："+cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println("星期WEEK_OF_YEAR为："+cal.get(Calendar.WEEK_OF_YEAR));
        System.out.println("历型ERA为："+cal.get(Calendar.ERA));
        System.out.println("zone ZONE_OFFSET为："+cal.get(Calendar.ZONE_OFFSET));
        //设置
        cal.set(Calendar.MONTH, Calendar.APRIL);
        System.out.println("\n修改后月份为："+cal.get(Calendar.MONTH));
        cal.set(1999, 0, 23);
        System.out.println("修改后时间为：" + cal.getTime());
        cal.set(2000, 1, 12, 13, 33, 14);
        System.out.println("修改后时间为：" + cal.getTime());
        cal.set(2001, 2, 13, 14, 13);
        System.out.println("修改后时间为：" + cal.getTime());
        //运算
        System.out.println("\n-----运算-----");
        cal.add(Calendar.YEAR, 12);
        System.out.println("add YEAR之后的时间为：" + cal.getTime());
        cal.add(Calendar.MONTH, -1);
        System.out.println("add MONTH之后的时间为：" + cal.getTime());
        cal.roll(Calendar.DATE, true);
        System.out.println("roll DATE之后的时间为：" + cal.getTime());
        cal.add(Calendar.DATE, 1);
        System.out.println("add DATE之后的时间为：" + cal.getTime());
        //roll与add运算对比
        cal.set(2000, 1, 29);
        System.out.println("set之后的时间为：" + cal.getTime());
        cal.roll(Calendar.DATE, 1);
        System.out.println("roll DATE之后的时间为：" + cal.getTime());
        cal.set(2000, 1, 29);
        cal.add(Calendar.DATE, 1);
        System.out.println("add DATE之后的时间为：" + cal.getTime());
    }

}
