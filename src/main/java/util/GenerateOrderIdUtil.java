package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 生成流水号工具类:
 *
 * 用时间生成流水号的弊端：
 * 如果服务器时间倒退，流水号就有可能会重复
 *
 * Created by yaoyao on 2018/12/6.
 */
public class GenerateOrderIdUtil {

    public static String getOrderId() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");//17位
        String dateString = dateFormat.format(date);
        Random random = new Random();
        return dateString + (random.nextInt(89999) + 10000);
    }

}
