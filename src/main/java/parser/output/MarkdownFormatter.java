package parser.output;

import parser.model.ClassInfo;
import parser.model.MethodInfo;

import java.util.List;

public class MarkdownFormatter implements OutputFormatter{
    @Override
    public String format(List<ClassInfo> classes){
        StringBuilder md = new StringBuilder();
        for(ClassInfo classInfo : classes){
            md.append("# Class `").append(classInfo.getName()).append("`\n")
                    .append(classInfo.getJavadoc()).append("\n\n");
            for(MethodInfo method : classInfo.getMethods()){
                md.append("## `").append(method.getName()).append("`\n")
                        .append(method.getJavadoc()).append("\n");
            }
        }
        return md.toString();
    }
}