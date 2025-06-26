package app;

import javacodingagent.CodeGenerator;
import javacodingagent.ai.AiServices;
import javacodingagent.ai.IAiServices;
import javacodingagent.ai.AIClientFactory;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Give requirements about java project:");
        Scanner scanner = new Scanner(System.in);
        String inputPrompt = scanner.nextLine();
        AIClientFactory aiClientFactory = new AIClientFactory(inputPrompt);
        AiServices aiClient = aiClientFactory.createClient();
        CodeGenerator generator = new CodeGenerator(aiClient);
        String generatedCode = generator.generate(inputPrompt);
        // Todo Add-ons

        // Todo 0. Use nlp -> recognize Class, methods, from text
            // Todo: 1. call Java Parser
            //   Todo: 2. call Optimizer
            //      Todo 3. find Bugs + risks memory leeks
            //       Todo 4. Check if code run
            //        Todo 5. Create Junit Test
        System.out.println("Generated Code:\n" + generatedCode);
    }
}
/*
"""
            Analyze the following software requirement and identify:
            1. Main entities/classes needed
            2. Key fields for each class
            3. Main operations/methods
            4. Relationships between classes

            Requirement: %s

            Respond with JSON format:
            {
                "classes": [
                    {
                        "name": "ClassName",
                        "fields": [
                            {"name": "fieldName", "type": "fieldType"}
                        ],
                        "methods": [
                            {"name": "methodName", "returnType": "returnType"}
                        ]
                    }
                ],
                "relationships": [
                    {"from": "ClassA", "to": "ClassB", "type": "relationshipType"}
                ]
            }
            """*/

/*
Stage 3 Code imple

"""
            Write complete Java 17 code implementing the following requirement:

            Requirement: %s

            Analysis: %s

            Design: %s

            Requirements:
            1. Use Java 17
            2. Include proper Lombok annotations where appropriate
            3. Add Spring Boot annotations if needed
            4. Include proper error handling
            5. Add clear documentation
            6. Follow clean code principles
            7. Include basic unit tests

            Respond ONLY with the Java code in a single markdown code block.
            """

 */