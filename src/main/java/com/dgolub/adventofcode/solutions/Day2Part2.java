package com.dgolub.adventofcode.solutions;

import com.dgolub.adventofcode.com.dgolub.advenofcode.utils.ResourceFileReader;

import java.util.List;

public class Day2Part2 {

    public static void main(String[] args) {
        System.out.println(getSequence());
    }

    private static String getSequence() {
        List<String> input = ResourceFileReader.readFromFile("day2_input");
        for (int i = 0; i < input.size(); i++) {
            for (int y = 1; y < input.size(); y++) {
                String first = input.get(i);
                String second = input.get(y);
                int position = 0;
                int differences = 0;
                for (int x = 0; x < first.length(); x++) {
                    if (first.charAt(x) != second.charAt(x)) {
                        position = x;
                        differences++;
                    }
                }
                if (differences == 1) {
                    return first.substring(0, position) + first.substring(position+1, first.length());
                }

            }
        }
        return "";
    }
}
