package util.file;

import org.apache.commons.io.FileSystemUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileStore;

/**
 * 获取磁盘信息
 *
 * Created by yaoyao on 2019/12/31.
 */
public class DiskUtils {

    /**
     * 获取路径所在磁盘的剩余可用空间大小
     */
    @Test
    public void testGetfreeSpaceKb() {
        try {
            String dir = "E:\\yaoyao\\qq";
            long freeSpaceKb = FileSystemUtils.freeSpaceKb(dir);
            System.out.println(freeSpaceKb + "kb");
            System.out.println(freeSpaceKb / 1024 / 1024 + "GB");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
