package parser.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ConstructorInfo {
    private String javadoc;
    private List<String> parameters = new ArrayList<>();
    private List<String> modifiers = new ArrayList<>();


    public List<String> getParameters(){
        return parameters;
    }

    public void setParameters(List<String> parameters){
        this.parameters = parameters;
    }

    public List<String> getModifiers(){
        return modifiers;
    }

    public void setModifiers(List<String> modifiers){
        this.modifiers = modifiers;
    }

    public String getJavadoc(){
        return javadoc;
    }

    public void setJavadoc(String javadoc){
        this.javadoc = javadoc;
    }


}
