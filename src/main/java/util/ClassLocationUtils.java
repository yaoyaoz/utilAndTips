package util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * tools to find which jar does the class come from 
 * @author : chenxh
 * @date: 16-04-0
 *
 */

/**
 * 功能:
 * 获知入参类是从哪个包JAR中加载的
 *
 * 使用方法:
 * String jarPath = ClassLocationUtils.where(<类名>.class);
 *
 * 或者：
 * 在idea断点调试时，按alt+F8，弹出Evaluate Expression对话框，输入“ClassLocationUtils.where(<类名>.class)”
 *
 * @author yaoyao
 * 
 */
public class ClassLocationUtils {

    /**
     * find the location of the class come from
     * @param cls
     * @return
     */
    public static String where(final Class cls) {
        if (cls == null)throw new IllegalArgumentException("null input: cls");
        URL result = null;
        final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
        final ProtectionDomain pd = cls.getProtectionDomain();
        if (pd != null) {
            final CodeSource cs = pd.getCodeSource();
            if (cs != null) result = cs.getLocation();
            if (result != null) {
                if ("file".equals(result.getProtocol())) {
                    try {
                        if (result.toExternalForm().endsWith(".jar") ||
                                result.toExternalForm().endsWith(".zip"))
                            result = new URL("jar:".concat(result.toExternalForm())
                                    .concat("!/").concat(clsAsResource));
                        else if (new File(result.getFile()).isDirectory())
                            result = new URL(result, clsAsResource);
                    }
                    catch (MalformedURLException ignore) {}
                }
            }
        }
        if (result == null) {
            final ClassLoader clsLoader = cls.getClassLoader();
            result = clsLoader != null ?
                    clsLoader.getResource(clsAsResource) :
                    ClassLoader.getSystemResource(clsAsResource);
        }
        return result.toString();
    }

}
