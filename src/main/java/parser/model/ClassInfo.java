package parser.model;
import java.util.ArrayList;
import java.util.List;

public class ClassInfo {
    private String name;
    private String javadoc;
    private String rawCode;
    private List<MethodInfo> methods = new ArrayList<>();
    private List<FieldInfo> fields = new ArrayList<>();
    private List<ConstructorInfo> constructors = new ArrayList<>();
    private List<String> imports = new ArrayList<>();

    // Getters & Setters
    public void addMethod(MethodInfo method) {
        this.methods.add(method);
    }
    public void addField(FieldInfo field) {
        this.fields.add(field);
    }
    public void addConstructor(ConstructorInfo constructor) {
        this.constructors.add(constructor);
    }
    public void addImport(String importStr) {
        this.imports.add(importStr);
    }
    //get-Set
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getJavadoc(){
        return javadoc;
    }

    public void setJavadoc(String javadoc){
        this.javadoc = javadoc;
    }

    public MethodInfo[] getMethods(){
        return methods.toArray(new MethodInfo[methods.size()]);
    }

    public void setRawCode(String rawCode){
        this.rawCode = rawCode;
    }
}