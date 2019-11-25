package util;

import org.junit.Test;

import java.io.*;
import java.util.Base64;

/**
 * Created by yaoyao on 2019/11/25.
 */
public class Base64Utils {

    //源文件路径
    public String sourcePath = "E:\\yaoyao\\研究院-引擎组\\（04）日常支撑\\20191125-活体dat转图片\\1125(1)\\1125";

    //生成图片路径
    public String targetPath = "E:\\yaoyao\\研究院-引擎组\\（04）日常支撑\\20191125-活体dat转图片\\1125(1)\\base64转图片";

    @Test
    public void testBase64ToImg() {

        File file = new File(sourcePath);
        if (file.isFile() || (0 == file.list().length)) {
            return;
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                String base64Dat = FileUtil.getFileString(f.getPath());

                String[] datArray = base64Dat.split("_");
                String base641 = datArray[0].split(",")[0];
                String base642 = datArray[1].split(",")[0];

                base64ToImg(base641, f.getName() + "_1", ".jpg");
                base64ToImg(base642, f.getName() + "_2", ".jpg");
            }
        }
    }

    /**
     * base64转文件
     */
    public void base64ToImg(String base64, String fileName, String suffix) {
        byte[] img = base64ToByte(base64);
        doSave(img, fileName, suffix);
    }

    public byte[] base64ToByte(String imageBase64) {
        byte[] img = null;
        if (imageBase64 != null) {
            try {
                img = decode(imageBase64);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return img;
    }

    /**
     * base64解码<br>
     * 说明:源字符串可能带有换行符,解码前先去掉换行符
     *
     * @param base64 源base64字符串
     * @return byte[]
     */
    public static byte[] decode(String base64) {
        String dst = "";
        dst = base64.replace(" ", "");
        dst = dst.replace("\n", "");
        dst = dst.replace("\r", "");
        System.out.println("测试dst.length()：" + dst.length());
        return Base64.getDecoder().decode(dst);
    }

    private boolean doSave(byte[] img, String fileName, String suffix) {
        String filePath = targetPath + File.separator + fileName + suffix;

        FileOutputStream fs = null;
        BufferedOutputStream bs = null;
        DataOutputStream out = null;

        try {
            fs = new FileOutputStream(filePath);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return false;
        }
        bs = new BufferedOutputStream(fs);
        out = new DataOutputStream(bs);

        try {
            out.write(img);
            out.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                out.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            try {
                bs.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            try {
                fs.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
