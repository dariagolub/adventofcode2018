package com.dgolub.adventofcode.solutions;

import com.dgolub.adventofcode.com.dgolub.advenofcode.utils.ResourceFileReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day4 {

    public static void main(String[] args) {
        List<String> input = ResourceFileReader.readFromFile("day4_input");
        Map<String, String> inputMap = input.stream().collect(Collectors.toMap(s -> s.substring(s.indexOf("[") + 1, s.indexOf("]")), s -> s.substring(s.indexOf("]") + 2, s.length())));
        TreeMap<String, String> treeInputMap = new TreeMap<>(inputMap);
        System.out.println(treeInputMap);

        int[][] schedule = new int[61][300];
        AtomicInteger rowNum = new AtomicInteger(-1);
        AtomicInteger eventBegins = new AtomicInteger(0);

        treeInputMap.forEach((time, event) -> {
            if (event.contains("#")) {
                // begins shift
                rowNum.incrementAndGet();
                int id = Integer.parseInt(event.substring(event.indexOf("#") + 1, event.indexOf(" b")));
                schedule[0][rowNum.get()] = id;
            } else if (event.startsWith("falls")) {
                //sleep begins
                int begins = Integer.parseInt(time.substring(time.indexOf(":") + 1, time.length()));
                eventBegins.set(begins);
            } else {
                //wake up
                int ends = Integer.parseInt(time.substring(time.indexOf(":") + 1, time.length()));

                for (int i = eventBegins.get() + 1; i < ends + 1; i++) {
                    schedule[i][rowNum.get()]++;
                }
            }
        });

        Map<Integer, AtomicInteger> sleepingTimes = new HashMap<>();
        int sleepyGuard = 0;
        int mostSleepyTime = 0;

        for (int y = 0; y < 300; y++) {

            int timeAsleep = 0;
            for (int x = 1; x < 61; x++) {
                if (schedule[x][y] > 0) {
                    timeAsleep++;
                }
            }
            int overallTimeSleep;
            if (sleepingTimes.containsKey(schedule[0][y])) {
                overallTimeSleep = sleepingTimes.get(schedule[0][y]).addAndGet(timeAsleep);
            } else {
                overallTimeSleep = timeAsleep;
                sleepingTimes.put(schedule[0][y], new AtomicInteger(timeAsleep));
            }

            if (overallTimeSleep > mostSleepyTime) {
                mostSleepyTime = overallTimeSleep;
                sleepyGuard = schedule[0][y];
            }

        }


        int[] sleepyTime = new int[60];
        for (int y = 0; y < 300; y++) {

            if (schedule[0][y] == sleepyGuard) {
                for (int x = 1; x < 61; x++) {
                    if (schedule[x][y] > 0) {
                        sleepyTime[x - 1]++;
                    }
                }
            }
        }

        int maxTime = 0;
        int index = 0;

        for (int x = 0; x < 60; x++) {
            int time = sleepyTime[x];
            if (time > maxTime) {
                maxTime = time;
                index = x;
            }
        }
        System.out.println(maxTime);


        System.out.println(sleepyGuard);
        System.out.println(index);

        System.out.println(sleepyGuard * index);

    }
}
