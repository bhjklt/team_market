package team.market.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtil {
    
    private static final int TIMEOUT = 5000;  
    
    /**
     * 向指定 URL 发送GET方法的请求 
     * @param url 发送请求的 URL  
     * @return 返回远程资源的响应结果的字符串
     */
    public static String doGet(String url){
        InputStream input = null;
        ByteArrayOutputStream output = null;
        HttpURLConnection httpCon = null;
        try {
            URL realUrl = new URL(url);
            httpCon = (HttpURLConnection) realUrl.openConnection();
            httpCon.setReadTimeout(TIMEOUT);
            httpCon.setConnectTimeout(TIMEOUT);
            httpCon.setRequestMethod("GET");
            httpCon.setRequestProperty("accept", "*/*");  
            httpCon.setRequestProperty("connection", "Keep-Alive"); 
            if(httpCon.getResponseCode() == 200){
                input = httpCon.getInputStream();
                output = new ByteArrayOutputStream();
                int len = 0;
                byte[] buff = new byte[1024];
                while((len = input.read(buff)) != -1){
                    output.write(buff, 0, len);
                }
                output.flush();
                return output.toString();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
                httpCon.disconnect();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        
        return null;
    }
    
    
    
    /**
     * 向指定 URL 发送POST方法的请求 
     * @param url 发送请求的 URL  
     * @param params 请求参数
     * @return 返回远程资源的响应结果的字符串
     */
    public static String doPost(String url,Map<String,String> params){
        PrintWriter out = null;  
        BufferedReader in = null;
        HttpURLConnection httpCon = null;
        StringBuilder result = new StringBuilder();  
        try {
            URL realUrl = new URL(url);
            httpCon = (HttpURLConnection) realUrl.openConnection();
            httpCon.setRequestProperty("accept", "*/*");  
            httpCon.setRequestProperty("connection", "Keep-Alive");  
            httpCon.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
            httpCon.setRequestProperty("charset", "utf-8");  
            httpCon.setUseCaches(false);  
            httpCon.setRequestMethod("POST");  
            httpCon.setDoOutput(true);  
            httpCon.setDoInput(true);  
            httpCon.setReadTimeout(TIMEOUT);  
            httpCon.setConnectTimeout(TIMEOUT);  
            if(params != null){
                StringBuilder sb = new StringBuilder();
                for (String key : params.keySet()) {
                    String param = params.get(key);
                    sb.append(key + "=" + param).append("&");
                }
                out = new PrintWriter(httpCon.getOutputStream());
                out.print(sb.toString().substring(0, sb.toString().length() - 1));
                out.flush();
            }
            in = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            String line = "";
            while((line = in.readLine()) != null){
                result.append(line);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
                httpCon.disconnect();
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        
        return result.toString();
    }

}
