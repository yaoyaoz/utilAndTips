package util;

/**
 * Created by HOME on 2017-10-02.
 */
public class ClassLocationUtilsTest {
    public static void main(String[] args) {
        String jarPath = ClassLocationUtils.where(ClassLocationUtils.class);
        System.out.println(jarPath);//file:/F:/workspaces/github/utilAndTips/target/classes/util/ClassLocationUtils.class
    }
}
