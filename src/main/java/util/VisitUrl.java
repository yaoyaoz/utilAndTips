package util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yaoyao   2018-02-08
 * @Description: 在代码里访问url
 */
public class VisitUrl {

    /**
     * 直接访问url，没有参数，或者直接在浏览器链接后面跟参数就能访问的
     */
    public static String getURLContent(String strURL) throws Exception {
        URL url = new URL(strURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        String line;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        httpConn.disconnect();

        return buffer.toString();
    }

    /**
     * 直接访问url，有json参数（直接在浏览器输链接+参数，不能访问的情况，可以试试这种方式）
     */
    public String httpPostWithJSON(String url, String json) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json, "utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            HttpResponse response = httpClient.execute(httpPost);
            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),
                    "UTF-8"));
            String str = br.readLine();
            while (str != null) {
                sb.append(str);
                str = br.readLine();
            }
        } catch (Exception e) {
            System.err.printf("send openApi error", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.printf("br close exception ", e);
                }
            }
        }
        //System.out.println("同步相应"+sb.toString());
        return sb.toString();
    }

    /**
     * 测试直接访问url，没有参数，或者直接在浏览器链接后面跟参数就能访问的
     */
    @Test
    public void testGetURLContent() {
        try {
            String result = getURLContent("https://www.baidu.com/baidu?tn=monline_3_dg&ie=utf-8&wd=王俊凯");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //访问url，没有参数
    @Test
    public void testHttpPostWithJSON() {
        String strURL = "https://www.baidu.com/baidu";

        JSONObject json = new JSONObject();
        json.put("tn", "monline_3_d");
        json.put("ie", "utf-8");
        json.put("wd", "王俊凯");

        String jsonString = json.toString();
        try {
            String result = httpPostWithJSON(strURL, jsonString);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
