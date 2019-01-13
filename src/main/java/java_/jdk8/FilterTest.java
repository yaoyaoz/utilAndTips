package java_.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 集合过滤
 *
 * @author yaoyao
 */
public class FilterTest {

    /**
     * 一个集合移除另一个集合
     * list:[apple, grape, watermelon, pear] 移除 AnotherEnum的所有code:[apple, pear],
     * 得到：afterFilterlist:[grape, watermelon]
     */
    @Test
    public void testListFilterAnotherEnum() {
        List<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("grape");
        list.add("watermelon");
        list.add("pear");

        List<String> afterFilterlist = list.stream().filter(string -> !AnotherEnum.getAllEnumCode().contains(string)).collect(Collectors.toList());
        System.out.println("afterFilterlist:" + afterFilterlist);
    }

}

enum AnotherEnum {
    apple1("apple", "苹果"),
    pear1("pear", "梨")
    ;

    /** 枚举值 */
    private String code;

    /** 描述值 */
    private String message;

    private AnotherEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static List<String> getAllEnumCode() {
        List<String> list = new ArrayList<String>(values().length);
        for(AnotherEnum _enum : values()) {
            list.add(_enum.getCode());
        }
        return list;
    }

}
