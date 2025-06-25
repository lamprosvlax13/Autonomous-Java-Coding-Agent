package javacodingagent.ai;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DeepSeekAIClient implements AIClient{
    private final OkHttpClient client;
    private final String apiKey;
    private static String MODEL = "meta-llama/Llama-Vision-Free";
    /*
    public DeepSeekAIClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }*/

    public DeepSeekAIClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public String getCodeCompletion(String prompt) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        // 1. Debug: Εκτύπωση του API Key για επιβεβαίωση
        System.out.println("Using API Key: " + apiKey.trim());

        JSONObject json = new JSONObject();
        json.put("model", MODEL);
        json.put("messages", new JSONObject[]{
                new JSONObject().put("role", "user").put("content", prompt)
        });
        json.put("temperature", 0.7);
        json.put("max_tokens", 1000);

        // 2. Debug: Εκτύπωση του JSON body
        String jsonBody = json.toString();
        System.out.println("Request Body: " + jsonBody);

        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
                .url("https://api.together.xyz/v1/chat/completions") // Δοκιμάστε και με .com
                .addHeader("Authorization", "Bearer " + apiKey) // .trim() για τυχόν κενά
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        // 3. Debug: Εκτύπωση της κλήσης
        System.out.println("Sending request to: " + request.url());

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();

            // 4. Debug: Εκτύπωση ολόκληρης της απάντησης
            System.out.println("API Response: " + responseBody);

            if (!response.isSuccessful()) {
                throw new IOException("API Error: HTTP " + response.code() + " - " + responseBody);
            }
            return new JSONObject(responseBody)
                    .getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");
        }
    }

}