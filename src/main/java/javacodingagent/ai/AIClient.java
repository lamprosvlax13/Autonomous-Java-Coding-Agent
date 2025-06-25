package javacodingagent.ai;

import java.io.IOException;


public interface AIClient{
    String getCodeCompletion(String prompt) throws IOException;
}

