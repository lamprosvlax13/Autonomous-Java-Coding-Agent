package parser;

import parser.model.ClassInfo;

import java.util.List;

public class RawCodeExtractor implements CodeExtractor {
    @Override
    public List<ClassInfo> extract(String javaCode) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setRawCode(javaCode);  // Προσθήκη πεδίου `rawCode` στο DTO
        return List.of(classInfo);
    }
}