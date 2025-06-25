package parser.output;

import parser.model.ClassInfo;

import java.util.List;

public interface OutputFormatter {
    String format(List<ClassInfo> classes);
}