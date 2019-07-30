package util.file;

import java.io.File;

/**
 * Created by yaoyao on 2019/7/22.
 */
public class FileDeleteUtils {

    public static void main(String[] args) {
        System.out.println("遍历目录开始");
        File dir = new File("E:\\yaoyao\\testDelete\\test\\copy.bat");  //要遍历的目录
        boolean flag = dir.delete();
        System.out.println(flag);
//        visitAllDirsAndFiles(dir);
        System.out.println("遍历目录结束");
    }

}
