package com.javacodingagent;

import javacodingagent.ai.DeepSeekAIClient;
import lombok.AllArgsConstructor;

import java.io.IOException;


@AllArgsConstructor
public class CodeGenerator {
    private final DeepSeekAIClient aiClient;

    public String generate(String requirement) throws IOException{
        String prompt = createPrompt(requirement);
        return aiClient.getCodeCompletion(prompt);
    }

    private String createPrompt(String requirement) {
        return String.format("""
            Write a complete Java class that implements the following requirement:
            %s
            
            Requirements:
            1. Use Java 17
            2. Include proper error handling
            3. Add clear documentation
            4. Follow clean code principles
            """, requirement);
    }
}