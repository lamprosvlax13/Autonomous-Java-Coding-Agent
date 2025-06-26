package javacodingagent.ai;

public abstract class AiServices implements IAiServices {

    protected String response;
    protected String prompt;
    protected final String apiKey;
    //private static String MODEL = "meta-llama/Llama-Vision-Free";


    public AiServices(String prompt, String apiKey){
        this.apiKey = apiKey;
        this.response = new String("");
        this.prompt = prompt;
    }

    protected abstract void getCodeCompletion();

    @Override
    public void callLlm(){
        getCodeCompletion();
    }

    @Override
    public String getResponse() {
        return this.response;
    }

    public void setPrompt(String prompt){
        this.prompt =  prompt;
    }
}
