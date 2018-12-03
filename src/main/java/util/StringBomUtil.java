package util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

/**
 * 检测文件头是否带BOM，过滤：
 * 只测了encoding = "UTF-8BOM"这种情况
 *
 * Created by yaoyao on 2018/12/03.
 */
public class StringBomUtil {
	private static Logger logger= LoggerFactory.getLogger(StringBomUtil.class);
	/**
	* @Title: filterBom
	* @Description: TODO 过滤带有bom格式的字符串
	* @param @param str    
	* @return void    
	* @throws
	*/
	public static String filterBom(String str) {
	 try {
		    logger.info("字符串过滤BOM开始，str={}",str);
		 	if(str == null || "".equals(str.trim())) {
		 		return "";
		 	}
		 	str=str.trim();
		 	int n, unread = 0;
		 	n=str.getBytes("UTF-8").length;
		    byte[] bom = new byte[n]; 
		 	ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes("UTF-8"));
		 	stream.read(bom);
			String encoding="UTF-8";
			logger.info("字符流以{} {} {}开始",bom[0],bom[1],bom[2]);
			if ((bom[0] == (byte) 0x00) && (bom[1] == (byte) 0x00)
					&& (bom[2] == (byte) 0xFE) && (bom[3] == (byte) 0xFF)) {
				encoding = "UTF-32BE";
				unread = n - 4;
			} else if ((bom[0] == (byte) 0xFF) && (bom[1] == (byte) 0xFE)
					&& (bom[2] == (byte) 0x00) && (bom[3] == (byte) 0x00)) {
				encoding = "UTF-32LE";
				unread = n - 4;
			} else if ((bom[0] == -17) && (bom[1] == -69 ) && (bom[2] == -65)) {
				encoding = "UTF-8BOM";
				unread = n - 3;
			} else if ((bom[0] == (byte) 0xFE) && (bom[1] == (byte) 0xFF)) {
				encoding = "UTF-16BE";
				unread = n - 2;
			} else if ((bom[0] == (byte) 0xFF) && (bom[1] == (byte) 0xFE)) {
				encoding = "UTF-16LE";
				unread = n - 2;
			}
			if(unread>0) {
				logger.info(" filterBom getEncoding before str={},encoding={},length={}",str,encoding,str.length());
				byte[] bs = new byte[unread];
				System.arraycopy(bom, n-unread, bs, 0, unread);
				str= new String(bs,"UTF-8");
				logger.info(" filterBom getEncoding after newStr={},encoding={},length={}",str,encoding,str.length());
			}
		 } catch (Exception e) {
				// TODO: handle exception
			 logger.error("字符串过滤BOM异常，str={}",str,e);
		 }
		return str;//返回重组转String
    }
//	public static void main(String[] args) {
//		System.out.println(filterBom("RF服装创意工作室1"));
//		System.out.println(filterBom("﻿RF服装创意工作室1"));
//		String s=filterBom("﻿RF服装创意工作室1");
//		System.out.println(s.equalsIgnoreCase(filterBom("﻿RF服装创意工作室1")));
//	}
}
