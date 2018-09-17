package util.file;

import java.io.File;

/**
 * 遍历文件夹，并修改文件名
 *
 * Created by yaoyao on 2018/9/17.
 */
public class FileNameUpdateByLoopFolderUtils {

    //修改前要修改的名称
    static String modifyBefore="aa";
    //文件名修改后要修改的名称
    static String modifyAfter="";

    public static void main(String[] argv) throws Exception {
        System.out.println("遍历目录开始");
        File dir = new File("E:\\test\\测试文件名修改");  //要遍历的目录
        visitAllDirsAndFiles(dir);
    }

    //用递归法遍历目录
    public static void visitAllDirsAndFiles(File dir) {
        //如果dir是目录
        if (dir.isDirectory()) {
            //获得子目录名
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                //递归子目录
                visitAllDirsAndFiles(new File(dir,children[i]));
            }
        }
        ////如果dir是文件而不是目录
        else{
            //修改文件名
            if(dir.getName().contains(modifyBefore)){//文件名contains的内容，将被替换掉
                renameFile(dir, new File(dir.getParentFile(), dir.getName().replaceAll(modifyBefore,modifyAfter)));
            }
        }
    }

    public static void renameFile(File toBeRenamed, File toFile) {
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
            System.out.println("文件不存在: " + toBeRenamed);
            return;
        }
        //修改文件名
        if (toBeRenamed.renameTo(toFile)) {
            System.out.println("------------修改成功--------------:" + toBeRenamed + ", 修改为" + toFile.getName());
        } else {
            System.out.println("------------修改失败:" + toBeRenamed + ", 修改为" + toFile.getName());
        }

    }

}
