package tips.path;

import org.junit.Test;

/**
 * 获取各种路径测试类
 * Created by yaoyao on 2018/6/13.
 */
public class GetPathsTest {

    @Test
    public void testGetUserHome() {
        System.out.println(GetPaths.getUserHome());
        /**
         C:\Users\Administrator
         */
    }

}
