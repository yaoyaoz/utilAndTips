package map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaoyao on 2018/6/27.
 */
public class MapTest {

    /**
     * map.get和map.containsKey的区别：
     *
     * map.get方法返回null有两种情况：
     * 1、map里面没有该键
     * 2、map里面该键的value为null
     *
     * 所以，如果要判断map里面是否有某键，应该用map.containsKey
     */
    @Test
    public void test() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("b", null);

        System.out.println(map.get("b"));
        System.out.println(map.get("c"));

        System.out.println(map.containsKey("b"));
        System.out.println(map.containsKey("c"));

        /**
         null
         null
         true
         false
         */
    }

}
