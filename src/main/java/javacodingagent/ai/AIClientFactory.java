package javacodingagent.ai;

import config.ConfigManager;

public class AIClientFactory {
    private String inputPrompt;

    public AIClientFactory(String inputPrompt){
        this.inputPrompt = inputPrompt;
    }

    public AiServices createClient() {
        String provider = ConfigManager.getProperty("ai.provider");
        String apiKey = ConfigManager.getProperty("ai.api.key");
        return switch (provider.toLowerCase()) {
            case "deepseek" -> new DeepSeekAIClient(inputPrompt,apiKey);
            case "openai" -> new OpenAIClient(inputPrompt,apiKey);
            case "gemini" -> new GeminiAIClient(inputPrompt,apiKey);
            default -> throw new IllegalArgumentException("Unsupported AI provider: " + provider);
        };
    }
}