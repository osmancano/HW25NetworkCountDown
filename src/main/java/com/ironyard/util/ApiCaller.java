package com.ironyard.util;

import com.ironyard.data.TIYResponse;
import io.swagger.models.auth.In;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by osmanidris on 2/23/17.
 */
public class ApiCaller extends Thread{
    RestTemplate restTemplate;
    String url;
    Integer number;
    public static final String[] nodes = {
            "192.168.2.99", //Wail
            //"192.168.2.53", // Rohan
            "192.168.2.144", //Luiz
            "192.168.2.90",  //Matt
            "192.168.2.42"};  //CJ

    public ApiCaller(Integer number){
        restTemplate = new RestTemplate();
        this.number = number;
        url = "http://"+nextNode()+":8080/rest/call/"+this.number;
    }

    private HttpEntity getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity headersEntity = new HttpEntity(headers);
        return headersEntity;
    }

    public TIYResponse callNext(){
        System.out.println(url);
        TIYResponse resp = restTemplate.exchange(url, HttpMethod.GET,getHeaders(),TIYResponse.class).getBody();
        return resp;
    }

    public String nextNode(){
        Random random = new Random();
        return nodes[random.nextInt(nodes.length)];
        //return "192.168.2.53";
    }
    @Override
    public void run() {
        callNext();
    }
}
