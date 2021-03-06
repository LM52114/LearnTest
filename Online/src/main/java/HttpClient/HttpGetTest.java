package HttpClient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author Li Hao
 * @Date 2021/1/7 8:56
 * @Version 1.0
 */
public class HttpGetTest {
    public static void main(String[] args) throws IOException {
        String urlSymbol = "https://www.supermapol.com/web/datas/1256823635/download?token=";

        String cookie = "JSESSIONID=34426F0747F189A33829B608E97465B5-n1";
        String cookieMy = "JSESSIONID=B2BA7402AA3A38992F9101A115C41FFE-n2";
        //创建client
        CloseableHttpClient client = HttpClients.createDefault();
        //get方法
        HttpGet httpGet = new HttpGet(urlSymbol);
        httpGet.setHeader("Cookie", cookieMy);

        //执行请求
        CloseableHttpResponse response = client.execute(httpGet);
        String string = EntityUtils.toString(response.getEntity(), "utf-8");


        //获取打印结果
        //查看状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(string);
        //打印内容
        //获取响应实体
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "utf-8");

        System.out.println(str);
        response.close();
        client.close();
    }
}
