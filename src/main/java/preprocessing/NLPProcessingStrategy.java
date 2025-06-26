package preprocessing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface NLPProcessingStrategy {
    Map<String, List<String>> preprocess(String text) throws IOException;
}