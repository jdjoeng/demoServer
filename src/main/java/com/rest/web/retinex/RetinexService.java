package com.rest.web.retinex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class RetinexService {

    @Value("${server.retinex}") private String retinexUrl;

    public void callTemp(HttpServletRequest request) {

        // request url
        String url = "http://3.36.24.230:8000/";

        RestTemplate temp = new RestTemplate();

        Map<String, String> map = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<Map> reslt = temp.exchange(url,HttpMethod.GET, entity, Map.class);

        System.out.println("END");

    }

    public Map<String, String> callRetinex(MultipartHttpServletRequest file) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", file.getFile("file").getResource());

        HttpEntity<MultiValueMap<String, Object>> he = new HttpEntity<>(body, headers);

        ResponseEntity<Map> resultMsg = restTemplate.postForEntity(retinexUrl, he, Map.class);

        HashMap<String, String> map = (HashMap<String, String>) resultMsg.getBody();

        return map;
    }
}
