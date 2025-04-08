package com.bootcoding.utils.controller;

import com.bootcoding.utils.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prompts")
public class PromptController {

    @Autowired
    private PromptService promptService;

    @PostMapping("/import")
    public String importPrompt(@RequestParam(defaultValue = "prompts") String collection) {
        return promptService.insertPromptJsonToMongo(collection);
    }
}
