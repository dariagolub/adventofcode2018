package com.dgolub.adventofcode.solutions;

import com.dgolub.adventofcode.com.dgolub.advenofcode.utils.ResourceFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day1Part2 {

    public static void main(String[] args) throws IOException {

        getFirstFreq();

    }

    private static void getFirstFreq() throws IOException {
        List<Double> frequencies = ResourceFileReader.readFromFile("day1_input").stream().map(Double::valueOf).collect(Collectors.toList());
        Set<Double> results = new HashSet<>();
        System.out.println(getTwice(frequencies, 0D, results));
    }

    private static Double getTwice(List<Double> frequencies, Double current, Set<Double> results) throws IOException {
        for (int i = 0; i < frequencies.size(); i++) {
            current += frequencies.get(i);
            boolean isAlreadyThere = results.add(current);
            if (!isAlreadyThere) {
                return current;
            }
        }

        return getTwice(frequencies, current, results);

    }
}
