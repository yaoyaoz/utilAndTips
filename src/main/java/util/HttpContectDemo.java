package util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;

/**
 * Created by yaoyao on 2019/8/3.
 */
public class HttpContectDemo {

    public static void main(String[] args) {
        String url = "http://localhost:8080/hello.html";
//        String url = "127.0.0.1:8080/demo.html";
//        String url = "http://127.0.0.1:8080/demo.html";
        Map<String, String> map = new HashMap<>();
        map.put("topName", "tottt");
        map.put("key", "啦啦啦空间eee");
        JSONObject json = new JSONObject();
        json.put("time", new Date());
        json.put("description", "错误日志消息噢");
        map.put("msg", json.toString());
        String post = HttpClientUtil.doPost(url, map);
        System.out.println(post);
    }
}

class HttpClientUtil {
    public static String doPost(String url, Map<String, String> param) {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            //创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            //创建参数列表
            if (param != null) {
                List<NameValuePair> pareamList = new ArrayList<>();
                for (String key : param.keySet()) {
                    pareamList.add(new BasicNameValuePair(key, param.get(key)));
                }
                //模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pareamList, "utf-8");
                httpPost.setEntity(entity);
            }
            //执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
}
