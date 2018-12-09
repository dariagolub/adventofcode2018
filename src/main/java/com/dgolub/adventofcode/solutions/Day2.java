package com.dgolub.adventofcode.solutions;

import com.dgolub.adventofcode.com.dgolub.advenofcode.utils.ResourceFileReader;

public class Day2 {

    public static void main(String[] args) {
        int twice = 0;
        int thrice = 0;

        for (String row : ResourceFileReader.readFromFile("day2_input")) {


            char[] chars = row.toCharArray();
            int[] alphabet = new int[130];
            for (char aChar : chars) {
                alphabet[(int) aChar]++;
            }

            int internalTwice = 0;
            int internalThrice = 0;
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == 2) {
                    internalTwice = 1;
                } else if (alphabet[i] == 3) {
                    internalThrice = 1;
                }
            }
            twice += internalTwice;
            thrice += internalThrice;
        }

        System.out.println(twice * thrice);
    }
}
