package javacodingagent.ai;

import com.javacodingagent.config.ConfigManager;

public class AIClientFactory {
    public static AIClient createClient() {
        String provider = ConfigManager.getProperty("ai.provider");
        String apiKey = ConfigManager.getProperty("ai.api.key");

        return switch (provider.toLowerCase()) {
            case "deepseek" -> new DeepSeekAIClient(apiKey);
            case "openai" -> new OpenAIClient(apiKey);
            case "gemini" -> new GeminiAIClient(apiKey);
            case "meta" -> new MetaAIClient(apiKey);
            default -> throw new IllegalArgumentException("Unsupported AI provider: " + provider);
        };
    }
}