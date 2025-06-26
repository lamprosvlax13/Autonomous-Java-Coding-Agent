package preprocessing;

import okhttp3.*;
import com.google.gson.*;
import java.io.IOException;
import java.util.*;

public class HuggingFaceStrategy implements NLPProcessingStrategy {
    private static final String HF_API_URL = "https://api-inference.huggingface.co/models/dslim/bert-base-NER";
    private static final String HF_API_KEY = "your_api_key_here";

    @Override
    public Map<String, List<String>> preprocess(String text) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.get("application/json; charset=utf-8");

        JsonObject payload = new JsonObject();
        payload.addProperty("inputs", text);

        Request request = new Request.Builder()
                .url(HF_API_URL)
                .post(RequestBody.create(JSON, payload.toString()))
                .addHeader("Authorization", "Bearer " + HF_API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String jsonResponse = response.body().string();
            return extractEntities(jsonResponse);
        }
    }

    private Map<String, List<String>> extractEntities(String jsonResponse) {
        Map<String, List<String>> entities = new HashMap<>();
        entities.put("classes", new ArrayList<>());
        entities.put("fields", new ArrayList<>());
        entities.put("methods", new ArrayList<>());

        JsonArray results = JsonParser.parseString(jsonResponse).getAsJsonArray();
        for (JsonElement element : results) {
            JsonObject entity = element.getAsJsonObject();
            String word = entity.get("word").getAsString();
            String entityGroup = entity.get("entity_group").getAsString();

            if (entityGroup.equals("PER")) entities.get("classes").add(word);
            else if (entityGroup.equals("ORG")) entities.get("methods").add(word);
            else if (entityGroup.equals("LOC")) entities.get("fields").add(word);
        }
        return entities;
    }
}