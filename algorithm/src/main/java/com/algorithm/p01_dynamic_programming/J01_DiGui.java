package com.algorithm.p01_dynamic_programming;

import org.junit.Test;

/**
 * ClassName: J01_DiGui
 * Description: 动态规划（递归）
 * Date: 2021年02月26日
 * <p>
 * 例子：一个楼梯有 10 级台阶，你从下往上走，每跨一步只能向上迈 1 级或者 2 级台阶，请问一共有多少种走法？
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J01_DiGui {

    /**
     * 楼梯阶数
     */
    int n = 10;

    /**
     * 法1：通过递归来解决
     * <p>
     * 复杂度太高了，是 O(2^n)
     */
    @Test
    public void test1() {
        int getWays1Result = getWays1(n);
        System.out.println("getWays1Result: " + getWays1Result);
    }

    //法2：还没写完
    @Test
    public void test2() {
        int getWays2Result = getWays2(n);
        System.out.println("getWays2Result: " + getWays2Result);
    }

    public int getWays1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return getWays1(n - 1) + getWays1(n - 2);
        }

    }

    public int getWays2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int temp = 0;

        for (int i = 3; i <= n; i++) {
            temp = a + b;
        }
        return temp;
    }

}