package com.test.fileupload;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@SpringBootTest
class FileuploadApplicationTests {

    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    ;


    @Test
    void contextLoads() throws IOException {
        ResponseEntity<byte[]> responseEntity = restTemplate().exchange("http://127.0.0.1:8082/downloadLocal", HttpMethod.POST, null,
                byte[].class, new HashMap<>());
        byte[] body = responseEntity.getBody();
        Path filePath = Paths.get("D:/download.jpg");
        try {
            // 使用Files类的write方法将数据写入文件
            // 注意：如果文件已存在，此方法会覆盖它
            Files.write(filePath, body);
            System.out.println("文件写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入失败：" + e.getMessage());
        }
        System.out.println(responseEntity.getBody());
    }

    @Test
    void test() throws IOException {
        ResponseEntity<byte[]> responseEntity = restTemplate().exchange("http://127.0.0.1:8082/downloadLocal2", HttpMethod.POST, null,
                byte[].class, new HashMap<>());
        byte[] body = responseEntity.getBody();
//        byte[] body = obj.toString().getBytes();
//        Path filePath = Paths.get("D:/download.jpg");
//        try {
//            // 使用Files类的write方法将数据写入文件
//            // 注意：如果文件已存在，此方法会覆盖它
//            Files.write(filePath, body);
//            System.out.println("文件写入成功！");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("文件写入失败：" + e.getMessage());
//        }
        System.out.println(new String(body));
        for (byte b : body) {
            System.out.println(((char) b));
        }
    }

}
