package util;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ClassName: PathUtil
 * Description:
 * Date: 2020年12月04日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class PathUtil {

    @Test
    public void dd() throws IOException {
        Path zipDir = Paths.get("/download" + File.separator + "346");
        Path directories = Files.createDirectories(zipDir);
        System.out.println("end...");
    }

}
