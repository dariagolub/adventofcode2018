package com.dgolub.adventofcode.com.dgolub.advenofcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ResourceFileReader {

    public static List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get("/Users/dgolub/Documents/repos/demos/adventofcode2018/src/main/resources/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
