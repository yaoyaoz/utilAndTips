package util.zip;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;


/**
 * ClassName: ZipUtil
 * Description: Zip4j压缩文件
 * Date: 2020年11月18日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class Zip4jUtil {

    public static void main(String[] args) {
        try {
            zip("E:\\yaoyao\\杂七杂八", null);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩
     *
     * @param srcFile 源目录
     * @param dest    要压缩的目录
     * @throws ZipException 异常
     */
    public static void zip(String srcFile, String dest) throws ZipException {
        File srcfile = new File(srcFile);

        //创建目标文件
        String destname = buildDestFileName(srcfile, dest);
        ZipFile zipfile = new ZipFile(destname);
        if (srcfile.isDirectory()) {
            zipfile.addFolder(srcfile);
        } else {
            zipfile.addFile(srcfile);
        }
    }

    public static String buildDestFileName(File srcfile, String dest) {
        if (dest == null) {
            if (srcfile.isDirectory()) {
                dest = srcfile.getParent() + File.separator + srcfile.getName() + ".zip";
            } else {
                String filename = srcfile.getName().substring(0, srcfile.getName().lastIndexOf("."));
                dest = srcfile.getParent() + File.separator + filename + ".zip";
            }
        } else {
            createPath(dest);//路径的创建
            if (dest.endsWith(File.separator)) {
                String filename = "";
                if (srcfile.isDirectory()) {
                    filename = srcfile.getName();
                } else {
                    filename = srcfile.getName().substring(0, srcfile.getName().lastIndexOf("."));
                }
                dest += filename + ".zip";
            }
        }
        return dest;
    }

    private static void createPath(String dest) {
        File destDir = null;
        if (dest.endsWith(File.separator)) {
            destDir = new File(dest);//给出的是路径时
        } else {
            destDir = new File(dest.substring(0, dest.lastIndexOf(File.separator)));
        }

        if (!destDir.exists()) {
            destDir.mkdirs();
        }
    }

}
