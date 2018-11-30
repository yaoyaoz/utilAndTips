package compileAndRunTime;

import org.junit.Test;

/**
 * 编译时、运行时
 *
 * Created by yaoyao on 2018/11/22.
 */
public class CompileAndRunTimeTest {

    static final int number1 = 5;
    static final int number2 = 6;

    static int number3 = 5;
    static int number4 = 6;

    @Test
    /**
     * 常亮是在编译期计算的
     *
     * 总结：
     * 常量折叠是一种 Java 编译器使用的优化技术。
     * 由于 final 变量的值不会改变，因此就可以对它们优化。
     * 问题：可以兑它们做什么优化呢？
     *
     * 除了代码优化外，在什么情况下，查看编译过的代码是很有帮助的：
     * Java 里的泛型是在编译时构造的，可以通过查看编译后的 class 文件来理解泛型，
     * 也可以通过查看它来解决泛型相关的问题。
     * 问题：泛型也是在编译时构造的么？空了试试
     */
    public void testConstantFolding() {

        /**
         * product1的值是在编译期计算的
         * 利用反编译器查看ConstantFolding.class文件：
         * int product1 = 30;
         */
        int product1 = number1 * number2;

        /**
         * product2的值是在运行时计算的
         * 利用反编译器查看ConstantFolding.class文件：
         * int product2 = number3 * number4;
         */
        int product2 = number3 * number4;

        /**
         * 利用反编译器查看ConstantFolding.class文件：
         * int product3 = number3 * 5;
         */
        int product3 = number3 * number1;
    }

    /**
     * 方法重载：这个是发生在编译时的。
     * 方法重载也被称为编译时多态，因为编译器可以根据参数的类型来选择使用哪个方法。
     */
    @Test
    public void testMethodOverload () {
        evaluate("string1");
        /**
         * 它会根据传入的参数是字符串常量，生成调用 #1 方法的字节码。
         * 问题：生成的调用 #1 方法的字节码可以在哪看呢？反正在.class文件里面看不出来
         */
    }

    public void evaluate(String param) {    //method #1
        System.out.println("evaluate(String param):param=" + param);
    }

    public void evaluate(int param) {    //method #2
        System.out.println("evaluate(int param):param=" + param);
    }

    /**
     * 看到"方法覆盖" 链接：https://mp.weixin.qq.com/s/iX1b6ML1onT6Q8KOFf8LQQ
     * 后面的没有太理解，就没有细看了。后面对jvm理解一下了，再来看吧
     */
    @Test
    public void test() {

    }

}

