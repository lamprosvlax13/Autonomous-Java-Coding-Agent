package preprocessing;

import okhttp3.*;
import com.google.gson.*;
import java.io.IOException;
import java.util.*;
/*
public class NLPProcessor {
    private static final String HF_API_URL = "https://api-inference.huggingface.co/models/bert-base-multilingual-cased";


    // Todo visit //https://www.geeksforgeeks.org/artificial-intelligence/how-to-access-huggingface-api-key/  - > GET API !!!



    private static final String HF_API_KEY = "your_api_key_here";  // Αντικαταστήστε με το API σας κλειδί

    // Αποστολή κειμένου στο HuggingFace για ανάλυση
    public static String analyzeText(String text) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        // Δημιουργία JSON payload
        JsonObject payload = new JsonObject();
        payload.addProperty("inputs", text);

        RequestBody body = RequestBody.create(JSON, payload.toString());
        Request request = new Request.Builder()
                .url(HF_API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + HF_API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    // Εξαγωγή κλάσεων, μεθόδων και σχέσεων από την απάντηση του μοντέλου
    public static Map<String, List<String>> extractEntities(String jsonResponse) {
        Map<String, List<String>> entities = new HashMap<>();
        entities.put("classes", new ArrayList<>());
        entities.put("methods", new ArrayList<>());
        entities.put("relationships", new ArrayList<>());

        JsonParser parser = new JsonParser();
        JsonArray results = parser.parse(jsonResponse).getAsJsonArray();

        for (JsonElement element : results) {
            JsonObject entity = element.getAsJsonObject();
            String word = entity.get("word").getAsString();
            String entityGroup = entity.get("entity_group").getAsString();

            switch (entityGroup) {
                case "CLASS":
                    entities.get("classes").add(word);
                    break;
                case "METHOD":
                    entities.get("methods").add(word);
                    break;
                case "RELATION":
                    entities.get("relationships").add(word);
                    break;
            }
        }
        return entities;
    }
}*/
public class NLPProcessor {
    private NLPProcessingStrategy strategy;

    public NLPProcessor(NLPProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NLPProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public String analyzeAndGenerateCode(String text) throws IOException {
        Map<String, List<String>> entities = strategy.preprocess(text);
        return generateJavaCode(entities);
    }

    private String generateJavaCode(Map<String, List<String>> entities) {
        StringBuilder code = new StringBuilder();
        if (!entities.getOrDefault("classes", List.of()).isEmpty()) {
            String className = entities.get("classes").get(0);
            code.append("public class ").append(className).append(" {\n\n");

            for (String field : entities.getOrDefault("fields", List.of())) {
                code.append("    private String ").append(field).append(";\n");
            }

            for (String method : entities.getOrDefault("methods", List.of())) {
                code.append("\n    public void ").append(method).append("() {\n")
                        .append("        // TODO\n")
                        .append("    }\n");
            }

            code.append("}");
        }
        return code.toString();
    }
}