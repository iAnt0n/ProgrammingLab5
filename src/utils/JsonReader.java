package utils;

import collection.City;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import exceptions.InvalidFieldException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class JsonReader {
    private ObjectMapper objectMapper = new ObjectMapper();
    public LinkedHashMap<String, City> read(String path) throws IOException, ValueInstantiationException {
        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            return objectMapper.readValue(in, new TypeReference<LinkedHashMap<String, City>>() {});
        }
    }
}
