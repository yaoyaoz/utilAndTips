package util.file;

import org.junit.Test;

import java.io.File;

/**
 * 更新文件名
 *
 * Created by yaoyao on 2018/9/13.
 */
public class FileNameUpdateUtils {

    //路径
    static String path = "E:\\test\\测试文件名修改";
    //修改前要修改的名称
    static String modifyBefore="aa";
    //修改后要修改的名称
    static String modifyAfter="";
    public static void main(String[] args){
        File mFile = new File(path);
        String[] fileName = mFile.list();
        for(int i=0;i<fileName.length;i++){
            if(fileName[i].contains(modifyBefore)){
                renameFile(path+ File.separator+fileName[i],fileName[i].replaceAll(modifyBefore,modifyAfter));
            }
        }
    }
    public static void renameFile(String file, String toFile) {
        File toBeRenamed = new File(file);
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
            System.out.println("文件不存在: " + file);
            return;
        }
        File newFile = new File(path+File.separator+toFile);
        //修改文件名
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("------------修改成功--------------");
        } else {
            System.out.println("------------修改失败--------------");
        }

    }

    @Test
    public void test() {
        String s = "dddd()";
        if(s.contains("\\(")) {
            String s1 = s.replaceAll("\\(", "");
            System.out.println(s1);
            System.out.println(s);
        } else {
            System.out.println("不包含");
        }

    }

}
