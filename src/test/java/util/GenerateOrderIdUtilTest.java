package util;

import org.junit.Test;

/**
 * 生成流水号工具测试类
 *
 * Created by yaoyao on 2018/12/7.
 */
public class GenerateOrderIdUtilTest {

    @Test
    public void testGetOrderId() {
        String orderId = GenerateOrderIdUtil.getOrderId();
        System.out.println(orderId);
    }

}
