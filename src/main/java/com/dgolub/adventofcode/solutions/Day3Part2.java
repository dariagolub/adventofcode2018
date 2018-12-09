package com.dgolub.adventofcode.solutions;


import com.dgolub.adventofcode.com.dgolub.advenofcode.utils.ResourceFileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3Part2 {

    public static void main(String[] args) {
        List<String> input = ResourceFileReader.readFromFile("day3_input");


        System.out.println(getId(input));
    }

    private static int getId(List<String> input) {
        int[][] matrix = new int[1000][1000];

        Set<Integer> exclude = new HashSet<>();
        for (String row : input) {
            int id = Integer.parseInt(row.substring(row.indexOf("#") + 1, row.indexOf(" ")));
            int left = Integer.parseInt(row.substring(row.indexOf("@") + 2, row.indexOf(",")));
            int wide = Integer.parseInt(row.substring(row.indexOf(":") + 2, row.indexOf("x")));

            int top = Integer.parseInt(row.substring(row.indexOf(",") + 1, row.indexOf(":")));
            int tall = Integer.parseInt(row.substring(row.indexOf("x") + 1, row.length()));


            for (int i = left; i < left + wide; i++) {
                for (int y = top; y < top + tall; y++) {
                    int oldId = matrix[i][y];
                    if (oldId != 0) {
                        exclude.add(oldId);
                        exclude.add(id);
                    }
                    matrix[i][y] = id;
                }
            }
        }

        for (int i = 1; i < input.size() + 1; i++) {
            if (!exclude.contains(i)) {
                return i;
            }
        }

        return 0;
    }
}
