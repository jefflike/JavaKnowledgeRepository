package jtpf.dex.svc;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;

public class Dadi {
    public static void main(String[] args) {
        try {
            File file = new File("b.txt");
            RestTemplate restTemplate = new RestTemplate();
//            File file = new File("D:\\b.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String strLine = null;
            int lineCount = 1;
            while(null != (strLine = bufferedReader.readLine())){
//				System.out.println("第[" + lineCount + "]行数据:[" + strLine + "]");
                String[] split = strLine.split(",");
                String xml = "            <root>\n" +
                        "            <channel>\n" +
                        "                <channelCode>310006</channelCode>\n" +
                        "                <channelComCode></channelComCode>\n" +
                        "                <channelAreaCode>NO</channelAreaCode>\n" +
                        "                <channelTradeCode>0016</channelTradeCode>\n" +
                        "                <channelTradeSerialNo></channelTradeSerialNo>\n" +
                        "                <channelOperateCode>NO</channelOperateCode>\n" +
                        "                <sourceType>0</sourceType>\n" +
                        "            </channel>\n" +
                        "            <main>\n" +
                        "                <policyNo>"+ split[0] +"</policyNo>\n" +
                        "                <endorseType>01</endorseType>\n" +
                        "                <endorseDate>"+ DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") +"</endorseDate>\n" +
                        "                <validDate>"+ split[1] +"</validDate>\n" +
                        "            </main>\n" +
                        "        </root>";
                lineCount++;
                System.out.println(xml);
//               RestTemplate restTemplate = getRestTemplate();
                HttpHeaders headers = new HttpHeaders();
/*                headers.setContentType(MediaType.parseMediaType("text/xml; charset=GBK"));
                headers.add("Accept", "text/xml");*/
                HttpEntity<?> reqEntity =  new HttpEntity<>(xml, headers);
                System.out.println("请求批量注销接口");
                ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://dex-svc.jiangtai.com/tour/text/30190611014/1.0/123456", reqEntity, String.class);
                String body = stringResponseEntity.getBody();
                System.out.println(body);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

