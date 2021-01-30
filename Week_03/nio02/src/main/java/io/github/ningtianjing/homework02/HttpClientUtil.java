package io.github.ningtianjing.homework02;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * description：
 * author：ningtianjing
 * date: 2021/1/27  16:00
 */

public class HttpClientUtil {

    private static Logger log = LoggerFactory.getLogger("nio-test");

    public static String doGet(String url ) throws Exception{
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = "no response.";
        try {
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = "Get Response Success, body : " + EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            log.error("httpClient doGet got exception: {}", e.getStackTrace());
            throw e;
        } finally {
            try {
                if (httpGet != null) {
                    httpGet.releaseConnection();
                }
                if (httpClient != null){
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error("httpClient doGet got exception: {}", e.getStackTrace());
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        String response = HttpClientUtil.doGet("http://127.0.0.1:8808");
        log.info("Response : {} ", response);
    }

}
