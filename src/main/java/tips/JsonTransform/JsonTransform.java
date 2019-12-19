package tips.JsonTransform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Json字符串转换
 * Created by yaoyao on 2018/6/13.
 */
public class JsonTransform {

    /**
     * Json字符串——>HashMap 方式一
     */
    @Test
    public void testJsonToHashMap() {
        HashMap map = JSON.parseObject("{\"name\": 'xiaohong', 'age': '18'}", HashMap.class);
        System.out.println(map);
        /**
         {name=xiaohong, age=18}
         */
    }

    /**
     * Json字符串——>HashMap 方式二
     */
    @Test
    public void testJsonToHashMapByTypeReference() {
        String s1 = "{\n" +
                "\t\"registerNum\":\t\"32058\",\n" +
                "\t\"businessType\":\t\"有限责任公司(自然人独资)\",\n" +
                "}";
//        Map<String, Object> object = JSONObject.parseObject(s1);

        Map<String, String> userMap = JSON.parseObject(s1, new TypeReference<HashMap<String, String>>(){});

        System.out.println(userMap);
    }

}
