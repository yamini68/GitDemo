package jsonfiles;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class Data {

    public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException {

      String jsoncontent= FileUtils.readFileToString(new File(path),
              StandardCharsets.UTF_8);

       // string to hashmap
        ObjectMapper mapper= new ObjectMapper();

        List<HashMap<String,String>> data= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }
}
