package parser.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MethodInfo {
    private String name;
    private String javadoc;
    private String returnType;
    private List<String> parameters = new ArrayList<>();
    private List<String> modifiers = new ArrayList<>();

    public String getJavadoc(){
        return javadoc;
    }

    public void setJavadoc(String javadoc){
        this.javadoc = javadoc;
    }

    public List<String> getModifiers(){
        return modifiers;
    }

    public void setModifiers(List<String> modifiers){
        this.modifiers = modifiers;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<String> getParameters(){
        return parameters;
    }

    public void setParameters(List<String> parameters){
        this.parameters = parameters;
    }

    public String getReturnType(){
        return returnType;
    }

    public void setReturnType(String returnType){
        this.returnType = returnType;
    }

}