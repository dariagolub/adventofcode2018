package com.dgolub.adventofcode.solutions;

import com.dgolub.adventofcode.com.dgolub.advenofcode.utils.ResourceFileReader;

import java.io.IOException;

public class Day1 {

    public static void main(String[] args) throws IOException {

        System.out.println(ResourceFileReader.readFromFile("day1_input").stream().map(Double::valueOf).mapToDouble(Double::doubleValue).sum());
    }
}
