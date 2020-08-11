package java_.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: GroupList
 * Description:
 * Date: 2020年08月11日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class GroupList {

    /**
     * 集合分组：
     * 对集合list按id+name进行分组，得到map
     */
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(new A(1, "xh", 18));
        list.add(new A(1, "xh", 20));
        list.add(new A(4, "hh", 25));
        list.add(new A(3, "hh", 22));

        Map<String, List<A>> map = new HashMap<>();
        map = (Map<String, List<A>>) list.stream().collect(Collectors.groupingBy(A::idName));
        System.out.println(map);
    }

}

class A {
    private int id;
    private String name;
    private int age;

    public A(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String idName() {
        return id + "_" + name;
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
