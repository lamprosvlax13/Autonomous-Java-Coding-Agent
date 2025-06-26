package preprocessing;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AIStrategy implements NLPProcessingStrategy {
    @Override
    public Map<String, List<String>> preprocess(String text) throws IOException{
        // Υλοποίηση για DeepSeek API (παρόμοια με HuggingFace)
        Map<String, List<String>> entities = new HashMap<>();

        // Παράδειγμα χρήσης DeepSeek API (ψευδοκώδικας)
        // String apiResponse = callDeepSeekAPI(text);
        // entities = parseDeepSeekResponse(apiResponse);

        return entities;
    }
}