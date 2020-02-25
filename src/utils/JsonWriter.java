package utils;

import collection.City;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;


public class JsonWriter {
    private ObjectMapper objectMapper = new ObjectMapper();

    public void write(String path, LinkedHashMap<String, City> collection) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(path));
        printWriter.print(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(collection));
        printWriter.flush();
        printWriter.close();
    }
}