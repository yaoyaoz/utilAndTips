package proxy.mybatis;

import org.junit.Test;

/**
 * Created by yaoyao on 2018/11/5.
 */
public class TestMapperProxy {

    @Test
    public void test01() {
        MapperProxy proxy = new MapperProxy();

        UserMapper mapper = proxy.newInstance(UserMapper.class);
        User user = mapper.getUserById(100);

        System.out.println("ID:" + user.getId());
        System.out.println("Name:" + user.getName());
        System.out.println("Age:" + user.getAge());

        System.out.println(mapper.toString());
    }

    @Test
    public void test2() {
//        MybatisSqlSessionFactory
    }

}
