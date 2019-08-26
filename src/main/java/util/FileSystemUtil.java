package util;

import org.apache.commons.io.FileSystemUtils;
import org.junit.Test;
import util.file.FileDeleteUtils;

import java.io.IOException;

/**
 * Created by yaoyao on 2019/8/26.
 */
public class FileSystemUtil {

    @Test
    public void testGetFree() {
        try {
            long total = FileSystemUtils.freeSpaceKb("G:\\");
            long disk = total / 1024 / 1024;//单位：GB
            System.out.println("剩余空间：" + disk + "GB");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
