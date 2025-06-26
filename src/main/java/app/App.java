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