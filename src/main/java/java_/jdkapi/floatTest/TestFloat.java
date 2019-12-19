package java_.jdkapi.floatTest;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by yaoyao on 2019/12/19.
 */
public class TestFloat {

    /**
     * 测试精度损失
     */
    @Test
    public void test21() {

        float d = Float.parseFloat("0.123456789");
        System.out.println("d_Float.parseFloat:" + d);

        String var1 = "330371.39";
        double var2 = 330371.39;
        float var3 = (float) var2;
        String var4 = "330371.39f";
        String var5 = "30371.39f";
        String var6 = "303715555.39";

        System.out.println("var1_Float.parseFloat(var1): " + Float.parseFloat(var1));
        System.out.println("var1_Double.parseDouble(var1): " + Double.parseDouble(var1));
        System.out.println("var6_Double.parseDouble(var6): " + Double.parseDouble(var6));
        System.out.println("var6_new BigDecimal(var6): " + new BigDecimal(var6).toString());
        System.out.println("var2: " + var2);
        System.out.println("var3: " + var3);
        System.out.println("var4: " + Float.parseFloat(var4));
        System.out.println("var5: " + Float.parseFloat(var5));
    }

}
