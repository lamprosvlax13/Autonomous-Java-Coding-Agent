package javacodingagent.ai;

import java.io.IOException;

public class GeminiAIClient extends AiServices{

    public GeminiAIClient(String prompt, String apiKey){
        super(prompt, apiKey);
    }

    @Override
    protected void getCodeCompletion(){

    }
}
