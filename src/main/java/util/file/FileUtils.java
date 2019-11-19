package util.file;

import org.junit.Test;

import java.io.File;

/**
 * Created by yaoyao on 2019/11/19.
 */
public class FileUtils {

    //遍历本目录下所有的文件(包括目录的目录里的文件)
    @Test
    public void testGetFolders() {
        String path = "E:\\yaoyao\\test\\python\\haha";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        func(file);
    }

    private static void func(File file) {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f);
            if (f.isFile())        //若是文件，直接打印
                System.out.println(f);
        }
    }

}
