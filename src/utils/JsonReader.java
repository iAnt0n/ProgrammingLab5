package utils;

import collection.City;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * Класс, отвечающий за десериализацию объектов из файла и преобразовывающий их в LinkedHashMap<String, City></String,>
 */
public class JsonReader {
    private ObjectMapper objectMapper = new ObjectMapper();
    public LinkedHashMap<String, City> read(String path) throws IOException {
        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            return objectMapper.readValue(in, new TypeReference<LinkedHashMap<String, City>>() {});
        }
    }
}
