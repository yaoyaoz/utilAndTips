package mvel;

import org.junit.Test;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：mvel测试类
 * mvel可以比较表达式
 *
 * mvel的执行方式分为两种:
 * 一种解释执行和编译执行.
 * 解释模式是一个无状态的,动态解释执行。不像编译模式需要负载表达式,他不需要就可以执行相应的脚本。
 * 编译模式需要在缓存中产生一个完全规范化表达式之后再执行.表达式通常被称为speed-sensitive应用,第二个选项可能会更好。
 *
 * create by yaoyao 2018.01.11
 */
public class MvelTest {

    /**
     * 解释执行
     */
    @Test
    public void test1() {
        String expression = "foobar > 99";
        Map vars = new HashMap();
        vars.put("foobar", new Integer(120));
//		vars.put("currency", "CNY");
        // We know this expressionshould return a boolean.
        Boolean result = (Boolean) MVEL.eval(expression, vars);
        if (result.booleanValue()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    /**
     * 编译执行
     *
     * 如果expression的参数 变量vars里面没有，就会抛异常
     *
     */
    @Test
    public void test2() {
        String expression = "'CNY'.contains(currency)&&!('USD'.contains(currency))";//问题：mvel表达式的语法还太不熟悉？
        // Compile the expression.
        Serializable compiled = MVEL.compileExpression(expression);
        Map vars = new HashMap();
        vars.put("currency", "3");
        vars.put("d", 8);
        // Now we execute it.
        Boolean result = (Boolean) MVEL.executeExpression(compiled, vars);
        if (result.booleanValue()) {
            System.out.println("true!");
        } else {
            System.out.println("false");
        }
    }

}
