package javacodingagent.ai;

import java.io.IOException;

public class OpenAIClient extends AiServices{

    public OpenAIClient(String prompt, String apiKey){
        super(prompt, apiKey);
    }

    @Override
    protected void getCodeCompletion(){

    }
}
