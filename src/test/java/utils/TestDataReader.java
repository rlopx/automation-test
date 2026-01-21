package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class TestDataReader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode getJsonData(String fileName) {
        try (InputStream is = TestDataReader.class
                .getClassLoader()
                .getResourceAsStream("testdata/" + fileName)) {
            if (is == null) {
                throw new RuntimeException("Test data file not found: " + fileName);
            }
            return mapper.readTree(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read test data file", e);
        }
    }
}
