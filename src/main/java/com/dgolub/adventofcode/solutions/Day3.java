package com.dgolub.adventofcode.solutions;


import com.dgolub.adventofcode.com.dgolub.advenofcode.utils.ResourceFileReader;

import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        List<String> input = ResourceFileReader.readFromFile("day3_input");

        int[][] matrix = new int[1000][1000];

        for (int r = 0; r < input.size(); r++) {
            String row = input.get(r);
            int left = Integer.parseInt(row.substring(row.indexOf("@") + 2, row.indexOf(",")));
            int wide = Integer.parseInt(row.substring(row.indexOf(":") + 2, row.indexOf("x")));

            int top = Integer.parseInt(row.substring(row.indexOf(",") + 1, row.indexOf(":")));
            int tall = Integer.parseInt(row.substring(row.indexOf("x") + 1, row.length()));

            for (int i = left; i < left + wide; i++) {
                for (int y = top; y < top + tall; y++) {
                    matrix[i][y]++;
                }
            }
        }

        int squareMeters = 0;
        for (int i = 0; i < 1000; i++) {
            for (int y = 0; y < 1000; y++) {
                if (matrix[i][y] >= 2) {
                    squareMeters++;
                }
            }
        }

        System.out.println(squareMeters);
    }
}
