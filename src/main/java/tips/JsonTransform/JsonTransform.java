package tips.JsonTransform;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;

/**
 * Json字符串转换
 * Created by yaoyao on 2018/6/13.
 */
public class JsonTransform {

    /**
     * Json字符串——>HashMap
     */
    @Test
    public void testJsonToHashMap() {
        HashMap map = JSON.parseObject("{\"name\": 'xiaohong', 'age': '18'}", HashMap.class);
        System.out.println(map);
        /**
         {name=xiaohong, age=18}
         */
    }

}
