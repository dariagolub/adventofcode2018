package com.dgolub.adventofcode.solutions;

import com.dgolub.adventofcode.com.dgolub.advenofcode.utils.ResourceFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day4Part2 {

    public static void main(String[] args) {
        List<String> input = ResourceFileReader.readFromFile("day4_input");
        Map<String, String> inputMap = input.stream().collect(Collectors.toMap(s -> s.substring(s.indexOf("[") + 1, s.indexOf("]")), s -> s.substring(s.indexOf("]") + 2, s.length())));
        TreeMap<String, String> treeInputMap = new TreeMap<>(inputMap);
        System.out.println(treeInputMap);

        Map<Integer, List<AtomicInteger>> sleeps = new HashMap<>();
        AtomicInteger id = new AtomicInteger();
        AtomicInteger eventBegins = new AtomicInteger(0);


        treeInputMap.forEach((time, event) -> {
            if (event.contains("#")) {
                // begins shift
                id.set(Integer.parseInt(event.substring(event.indexOf("#") + 1, event.indexOf(" b"))));

            } else if (event.startsWith("falls")) {
                //sleep begins
                int begins = Integer.parseInt(time.substring(time.indexOf(":") + 1, time.length()));
                eventBegins.set(begins);
            } else {
                //wake up
                int ends = Integer.parseInt(time.substring(time.indexOf(":") + 1, time.length()));

                if (!sleeps.containsKey(id.get())) {
                    ArrayList<AtomicInteger> newList = new ArrayList<>();
                    for (int i = 0; i < 60; i++) {
                        newList.add(new AtomicInteger(0));
                    }
                    sleeps.put(id.get(), newList);
                }
                List<AtomicInteger> sleepyTimes = sleeps.get(id.get());
                for (int i = eventBegins.get(); i < ends; i++) {
                    sleepyTimes.get(i).incrementAndGet();
                }
            }
        });

        Map.Entry<Integer, List<AtomicInteger>> entry = sleeps.entrySet().stream()
                .max((value1, value2) -> value1.getValue().stream().max((value3, value4) -> value3.get() >
                        value4.get() ? 1 : -1).get().get() >
                        value2.getValue().stream().max((value5, value6) -> value5.get() > value6.get() ? 1 : -1).get().get() ? 1 : -1).get();


        AtomicInteger max = new AtomicInteger(0);
        AtomicInteger maxIndex = new AtomicInteger(0);
        for (int i = 0; i < entry.getValue().size(); i++) {
            int value = entry.getValue().get(i).intValue();
            if (value > max.get()) {
                max.set(value);
                maxIndex.set(i);

            }
        }
        System.out.println(maxIndex);
        long result = entry.getKey().longValue() * maxIndex.get();
        System.out.println(result);

    }

}