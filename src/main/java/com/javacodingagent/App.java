package com.javacodingagent;


import com.javacodingagent.config.ConfigManager;
import javacodingagent.ai.DeepSeekAIClient;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException{
        // Φόρτωση του API key από το config file
        String apiKey = ConfigManager.getProperty("deepseek.api.key");

        if (apiKey == null || apiKey.isEmpty() || apiKey.equals("your_api_key_here")) {
            throw new IllegalArgumentException("Please set your DeepSeek API key in config.properties");
        }

        DeepSeekAIClient aiClient = new DeepSeekAIClient(apiKey);
        CodeGenerator generator = new CodeGenerator(aiClient);

        String generatedCode = generator.generate(
                "Create a Spring Boot REST controller for User with CRUD operations"
        );

        System.out.println("Generated Code:\n" + generatedCode);
    }
}