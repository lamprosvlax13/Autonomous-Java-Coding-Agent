package javacodingagent.ai;

import java.io.IOException;


public interface IAiServices{
    void callLlm() throws IOException;
    String getResponse() throws IOException;

    //String getCodeCompletion(String prompt) throws IOException;
}

