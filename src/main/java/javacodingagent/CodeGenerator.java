package javacodingagent;

import javacodingagent.ai.AiServices;
import javacodingagent.ai.IAiServices;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class CodeGenerator {
    private final AiServices aiClient;

    public String generate(String requirement) throws IOException{
        String prompt = createPrompt(requirement);
        aiClient.setPrompt(prompt);
        aiClient.callLlm();
        return aiClient.getResponse();
    }

    private String createPrompt(String requirement) {
        return String.format("""
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
            """, requirement);
    }
}
/*
Write a complete Java class that implements the following requirement:
            %s

            Requirements:
            1. Use Java 17
            2. Include proper error handling
            3. Add clear documentation
            4. Follow clean code principles
            5. Include unit tests
            """
 */

/*
Stage 1 Analysis Class,methods etc

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
            """





 */




/*
Stage 2 Design Class with methods etc

"""
            Based on the following requirement and analysis, create a detailed class design:

            Requirement: %s

            Analysis: %s

            Create a detailed design document including:
            1. Complete class definitions with all fields
            2. Method signatures with parameters
            3. Class relationships (inheritance, composition etc.)
            4. Key interfaces

            Respond with markdown format.
            """
 */