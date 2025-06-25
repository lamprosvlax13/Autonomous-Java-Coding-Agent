package parser;

import parser.model.ClassInfo;

import java.util.List;

public interface CodeExtractor {
    List<ClassInfo> extract(String javaCode);
}