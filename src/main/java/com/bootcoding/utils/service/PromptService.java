package com.bootcoding.utils.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;

@Service
public class PromptService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String insertPromptJsonToMongo(String collectionName) {
        try {

            InputStream inputStream = new ClassPathResource("prompt.json").getInputStream();


            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> jsonMap = mapper.readValue(inputStream, Map.class);


            Document document = new Document(jsonMap);


            mongoTemplate.insert(document, collectionName);

            return "Prompt data inserted successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to insert prompt data: " + e.getMessage();
        }
    }
}

