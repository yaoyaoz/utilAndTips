package proxy.staticAgent;

/**
 * 被代理的目标对象，真实主题
 *
 * Created by yaoyao on 2018/11/1.
 */
public class Math implements IMath {
    @Override
    public int add(int n1, int n2) {
        int result = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + result);
        return result;
    }

    @Override
    public int sub(int n1, int n2) {
        int result = n1 - n2;
        System.out.println(n1 + " - " + n2 + " = " + result);
        return result;
    }
}
