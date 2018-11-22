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
    public void test() {
//        。。写到这里
    }

}

