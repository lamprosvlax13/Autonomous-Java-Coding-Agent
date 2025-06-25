package parser.output;

import parser.model.ClassInfo;
import com.google.gson.Gson;
import java.util.List;



public class JsonFormatter implements OutputFormatter {
    @Override
    public String format(List<ClassInfo> classes) {
        return new Gson().toJson(classes);
    }
}
