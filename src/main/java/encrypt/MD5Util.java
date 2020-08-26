package encrypt;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * ClassName: MD5Util
 * Description:
 * Date: 2020年08月13日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class MD5Util {

    @Test
    public void test() {
        String s = DigestUtils.md5Hex("123456");
        System.out.println("s:" + s);
    }

}
