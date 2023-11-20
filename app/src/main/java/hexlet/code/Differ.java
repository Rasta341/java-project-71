package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Differ {
    public static String generate(Path filepath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(String.valueOf(filepath));
        Map<String, Object> map
                = objectMapper.readValue(file, new TypeReference<HashMap<String,Object>>(){});
        return map.toString();
    }

    public static Object genDiff(Path filepath1, Path filepath2, String format) throws IOException {
        String mapAsString1 = generate(filepath1);
        String mapAsString2 = generate(filepath2);
        String result;

    //результаты сравнения добавлять в новую Мапу?
        //сравнивать по ключам?
        return null;
    }
}
