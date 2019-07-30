package util.file;

import java.io.File;
import java.util.Date;

public class FileDeleteTest {
    public static void main(String args[]) {
        System.out.println("deleted开始;" + new Date().toLocaleString());
        delFolder("E:\\yaoyao\\testDelete");
//        delFile("E:\\yaoyao\\testDelete\\channel");
        System.out.println("deleted结束;" + new Date().toLocaleString());
    }

    //删除文件夹
    //param folderPath 文件夹完整绝对路径
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除指定文件夹下所有文件
    //param path 文件夹完整绝对路径
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile() &&
                    (temp.getPath().contains("\\.settings\\") ||
                            temp.getPath().contains("\\target\\") ||
                            temp.getPath().contains("\\resources\\") ||
                            temp.getPath().contains("\\channel\\channel.thrift\\clientTool\\") ||
                            temp.getPath().contains("\\channel\\channel.http\\src\\test\\") ||
                            temp.getPath().contains("channel\\channel.tcp\\src\\test\\java\\xq\\channel\\tcp\\") ||
                            temp.getPath().contains("\\foundation\\foundation.buffer\\src\\test\\java\\xq\\foundation\\buffer\\") ||
                            temp.getPath().contains("\\foundation\\foundation.common\\src\\test\\java\\xq\\foundation\\common\\") ||
                            temp.getPath().contains("\\foundation\\foundation.image\\src\\test\\java\\xq\\foundation\\image\\") ||
                            temp.getPath().contains("\\foundation\\foundation.remoting\\src\\test\\java\\xq\\foundation\\remoting\\") ||
                            temp.getPath().contains("\\foundation\\foundation.serialize\\src\\test\\java\\xq\\foundation\\serialize\\") ||
                            temp.getPath().contains("\\foundation\\foundation.threadpool\\src\\test\\java\\xq\\foundation\\threadpool\\") ||
                            temp.getPath().contains("\\service\\service.internal.dynamic\\service.internal.dynamic.record\\src\\test\\java\\xq\\service\\internal\\dynamic\\record\\") ||
                            temp.getName().equals(".project") ||
                            temp.getName().contains(".iml") ||
                            temp.getName().equals(".classpath") ||
                            temp.getName().equals(".gitignore") ||
                            temp.getName().equals("NettyClientTest.java") ||
                            temp.getName().equals("SerializationFactoryTest.java") ||
                     temp.getName().equals("TransportFactoryTest.java") ||

                    temp.getName().equals("pom.xml"))){
                    temp.delete();
            }
            if (temp.isDirectory()) {
//                if (temp.getName().equals(".settings") ||
//                        temp.getName().equals("target") ||
//                        temp.getName().equals("resources")) {
                    delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                    delFolder(path + "/" + tempList[i]);//再删除空文件夹
                    flag = true;
//                }
            }
        }
        return flag;
    }

    public static boolean delFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                if (temp.getName().equals(".project")) {
                    temp.delete();
                }
            }
        }
        return flag;
    }
}