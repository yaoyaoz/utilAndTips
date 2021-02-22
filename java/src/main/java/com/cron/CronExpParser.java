package com.cron;

import org.quartz.CronExpression;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * ClassName: CronExpParser
 * Description:
 * Date: 2021年02月20日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class CronExpParser {

    /**
     * @方法名：parser
     * @方法描述【cron表达式装换成时间格式】
     * @param cronExpression   cron表达式
     * @return
     * @修改描述【修改描述】
     * @版本：1.0
     * @创建人：Administrator
     * @创建时间：2018年8月17日 下午2:46:43
     * @修改人：Administrator
     * @修改时间：2018年8月17日 下午2:46:43
     */
    public static List<String> parser(String cronExpression) {
        List<String> result = new ArrayList<String>();
        if (cronExpression == null || cronExpression.length() < 1) {
            return result;
        } else {
            CronExpression exp = null;
            try {
                exp = new CronExpression(cronExpression);
            } catch (ParseException e) {
                e.printStackTrace();
                return result;
            }
            Calendar calendar = Calendar.getInstance();
            String cronDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE);
            String sStart = cronDate + " 00:00:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dStart = null;
            Date dEnd = null;
            try {
                dStart = sdf.parse(sStart);
                calendar.setTime(dStart);
                calendar.add(Calendar.DATE, 30);
                dEnd = calendar.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date dd = new Date();
            dd = exp.getNextValidTimeAfter(dd);
            while (dd.getTime() < dEnd.getTime()) {
                result.add(sdf.format(dd));
                dd = exp.getNextValidTimeAfter(dd);
            }
            exp = null;
        }
        return result;
    }

    public static void main(String[] args) {
//        String CRON_EXPRESSION = "4 5 6 ? * 2-6 *";
        String CRON_EXPRESSION = "0 0 19~22 ? * 2-6 *";
        System.out.println(CRON_EXPRESSION);
        List<String> lTime = new ArrayList<String>();
        lTime = CronExpParser.parser(CRON_EXPRESSION);
        for (int i = 0; i < lTime.size(); i++) {
            System.out.println(lTime.get(i));
        }

    }

}