package util;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.nio.file.Files;

public class FileUtil {

	public static void fileCopy(String resource, String target) {
		File folder = new File(target.substring(0, target.lastIndexOf(File.separator)));
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File file = new File(target);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (FileInputStream fis = new FileInputStream(resource);
				FileOutputStream fos = new FileOutputStream(target);) {

			byte[] buf = new byte[1024];
			int by = 0;
			while ((by = fis.read(buf)) != -1) {
				fos.write(buf, 0, by);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String getAppRoot() {
		try {
			return new File("").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void createFileIfExitsDelete(File file) {
		if (file.exists()) {
			file.delete();
		}
		createDirAndFileIfNotExits(file);
	}

	public static void createDirAndFileIfNotExits(File file) {
		File parentFile = file.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String FileToBase64(File file) {
		byte[] dd = file2Byte(file);
//		System.out.println("dd:" + dd.length);
		byte[] encodeBase64 = Base64.encodeBase64(dd);
		String s = new String(encodeBase64);
		return s;
	}

	public static String FileToBase64(String path) {
		byte[] encodeBase64 = Base64.encodeBase64(file2Byte(path));
		String s = new String(encodeBase64);
		return s;
	}

	private static byte[] file2Byte(String filePath) {
		ByteArrayOutputStream bos = null;
		BufferedInputStream in = null;
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException("file not exists");
			}
			bos = new ByteArrayOutputStream((int) file.length());
			in = new BufferedInputStream(new FileInputStream(file));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private static byte[] file2Byte(File file) {
		ByteArrayOutputStream bos = null;
		BufferedInputStream in = null;
		try {
			if (!file.exists()) {
				throw new FileNotFoundException("file not exists");
			}
			bos = new ByteArrayOutputStream((int) file.length());
			in = new BufferedInputStream(new FileInputStream(file));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static String getFileString(String path) {
		FileReader fr = null;
		StringBuffer sb = new StringBuffer();
		try {
			fr = new FileReader(path);
			BufferedReader bufr = new BufferedReader(fr);
			String line = null;
			while((line = bufr.readLine() ) != null) {
//				System.out.println("line:" + line);
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	public static void moveFileTo(File oldFile, String toPath) {
		File newName = new File(toPath);
		System.out.println("是否移动文件成功：" + oldFile.renameTo(newName) + ", 当前时间：" + DateUtils.dateString());
	}

	//未测试
	public static void copeFileTo(File sourceFile, File toFile) {
		try {
			Files.copy(sourceFile.toPath(), toFile.toPath());
		} catch (IOException e) {
			System.out.println("文件复制异常，源文件路径：" + sourceFile.getPath());
			e.printStackTrace();
		}
	}

}
