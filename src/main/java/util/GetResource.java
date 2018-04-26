package util;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yaoyao   2018-04-26
 * @Description: 获取资源的不同方式
 */
public class GetResource {

    /**
     * new URL放的路径参数
     */
    @Test
    public void testNewURL() {
        try {
            URL url1 = new URL("file:///E:/test/test1.xlsx");
            URL url2 = new URL("http://www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
