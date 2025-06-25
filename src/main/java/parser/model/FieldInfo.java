package parser.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FieldInfo {
    private String name;
    private String javadoc;
    private String type;
    private List<String> modifiers = new ArrayList<>();

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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
