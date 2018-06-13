package tips.path;

import org.junit.Test;

/**
 * 获取各种路径
 * Created by yaoyao on 2018/6/13.
 */
public class GetPaths {

    /**
     * 获取用户的主目录
     */
    public static String getUserHome() {
        String path = System.getProperty("user.home");
        return path;
    }

}
