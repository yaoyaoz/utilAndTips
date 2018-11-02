package proxy.staticAgent;

/**
 * 静态代理类
 *
 * Created by yaoyao on 2018/11/1.
 */
public class MathProxy implements IMath {

    IMath math = new Math();

    @Override
    public int add(int n1, int n2) {
        //开始时间
        long startTime = System.currentTimeMillis();
        int result = math.add(n1, n2);
        long span = System.currentTimeMillis() - startTime;
        System.out.println("共用时：" + span);
        return result;
    }

    @Override
    public int sub(int n1, int n2) {
        //开始时间
        long startTime = System.currentTimeMillis();
        int result = math.sub(n1, n2);
        long span = System.currentTimeMillis() - startTime;
        System.out.println("共用时：" + span);
        return result;
    }
}
