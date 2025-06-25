package parser;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;


public abstract class AbstractCodeAnalyzer implements CodeExtractor {
    protected CompilationUnit parseCode(String javaCode) {
        return null;
    }
}