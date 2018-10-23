package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class Controller {

    @Value("classpath:json/test.json")
    private org.springframework.core.io.Resource resourceFile;


    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/currency/BTC")
    JsonNode home() throws IOException {
        JsonNode jsonNode = objectMapper.readTree(resourceFile.getFile());
        return jsonNode.get("BTC_KRW").get("bithumb").get("last");

    }
}
