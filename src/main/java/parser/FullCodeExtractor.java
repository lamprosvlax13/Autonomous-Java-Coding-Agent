package parser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.javadoc.Javadoc;
import parser.model.ClassInfo;
import parser.model.ConstructorInfo;
import parser.model.FieldInfo;
import parser.model.MethodInfo;

import java.util.*;

public class FullCodeExtractor extends AbstractCodeAnalyzer {
    @Override
    public List<ClassInfo> extract(String javaCode) {
        CompilationUnit cu = parseCode(javaCode);
        List<ClassInfo> classes = new ArrayList<>();

        // Εξαγωγή imports
        List<String> imports = new ArrayList<>();
        cu.getImports().forEach(imp -> imports.add(imp.getNameAsString()));

        // Εξαγωγή κλάσεων
        cu.findAll(ClassOrInterfaceDeclaration.class).forEach(classDecl -> {
            ClassInfo classInfo = new ClassInfo();
            classInfo.setName(classDecl.getNameAsString());
            classInfo.setJavadoc(extractJavadoc(classDecl.getJavadoc()));

            // Προσθήκη imports
            imports.forEach(classInfo::addImport);

            // Fields
            classDecl.getFields().forEach(field -> {
                FieldInfo fieldInfo = new FieldInfo();
                fieldInfo.setName(field.getVariable(0).getNameAsString());
                fieldInfo.setType(field.getElementType().asString());
                fieldInfo.setJavadoc(extractJavadoc(field.getJavadoc()));
                field.getModifiers().forEach(mod ->
                        fieldInfo.getModifiers().add(mod.toString())
                );
                classInfo.addField(fieldInfo);
            });

            // Constructors
            classDecl.getConstructors().forEach(constructor -> {
                ConstructorInfo constructorInfo = new ConstructorInfo();
                constructorInfo.setJavadoc(extractJavadoc(constructor.getJavadoc()));
                constructor.getParameters().forEach(param ->
                        constructorInfo.getParameters().add(param.getNameAsString())
                );
                constructor.getModifiers().forEach(mod ->
                        constructorInfo.getModifiers().add(mod.toString())
                );
                classInfo.addConstructor(constructorInfo);
            });

            // Methods
            classDecl.getMethods().forEach(method -> {
                MethodInfo methodInfo = new MethodInfo();
                methodInfo.setName(method.getNameAsString());
                methodInfo.setJavadoc(extractJavadoc(method.getJavadoc()));
                methodInfo.setReturnType(method.getType().asString());
                method.getParameters().forEach(param ->
                        methodInfo.getParameters().add(param.getNameAsString())
                );
                method.getModifiers().forEach(mod ->
                        methodInfo.getModifiers().add(mod.toString())
                );
                classInfo.addMethod(methodInfo);
            });

            classes.add(classInfo);
        });

        return classes;
    }

    private String extractJavadoc(Optional<Javadoc> javadoc) {
       return null;
    }
}