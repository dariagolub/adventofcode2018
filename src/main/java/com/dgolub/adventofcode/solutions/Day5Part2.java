package com.dgolub.adventofcode.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class Day5Part2 {

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("/Users/dgolub/Documents/repos/demos/adventofcode2018/src/main/resources/" + "day5_input")));

        System.out.println(input.length());
        System.out.println((int) 'a');
        System.out.println((int) 'A');
        System.out.println((int) 'z');
        System.out.println((int) 'Z');

        boolean modified;

        AtomicInteger minLength = new AtomicInteger(50000);

        for (int x = 65; x < 91; x++) {
            char[] inputArray = input.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < inputArray.length; i++) {
                if ((int) inputArray[i] != x && (int) inputArray[i] != (x + 32)) {
                    sb.append(inputArray[i]);
                }
            }
            inputArray = sb.toString().toCharArray();
            sb = new StringBuilder();
            do {
                modified = false;
                for (int i = 0; i < inputArray.length - 1; i++) {
                    if ((Math.abs((int) inputArray[i] - (int) inputArray[i + 1]) != 32)) {
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

            if (inputArray.length < minLength.get()) {
                minLength.set(inputArray.length);
            }
        }

        System.out.println(minLength.get());

    }
}
