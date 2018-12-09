package com.dgolub.adventofcode.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day5 {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("/Users/dgolub/Documents/repos/demos/adventofcode2018/src/main/resources/" + "day5_input")));

        System.out.println(input.length());
        StringBuilder sb = new StringBuilder();

        boolean modified;

        char[] inputArray = input.toCharArray();

        do {
            modified = false;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (Math.abs((int) inputArray[i] - (int) inputArray[i + 1]) != 32) {
                    sb.append(inputArray[i]);
                    if (i == inputArray.length - 2) {
                        sb.append(inputArray[i + 1]);
                    }
                } else {
                    modified = true;
                    i++;
                }
            }
            inputArray = sb.toString().toCharArray();
            sb = new StringBuilder();
        } while (modified);

        System.out.println(inputArray.length);

    }
}
