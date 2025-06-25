package com.javacodingagent;

import javacodingagent.ai.AIClient;
import javacodingagent.ai.AIClientFactory;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        AIClient aiClient = AIClientFactory.createClient();
        CodeGenerator generator = new CodeGenerator(aiClient);

        String generatedCode = generator.generate(
                "Create a Spring Boot REST controller for User with CRUD operations"
        );

        System.out.println("Generated Code:\n" + generatedCode);
    }
}