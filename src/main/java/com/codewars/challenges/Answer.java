package com.google.challenges;

/*
Commander Lambda has had an incredibly successful week: she completed the first test run of her LAMBCHOP doomsday device, she captured six key members of the Bunny Rebellion, and she beat her personal high score in Tetris. To celebrate, she's ordered cake for everyone - even the lowliest of minions! But competition among minions is fierce, and if you don't cut exactly equal slices of cake for everyone, you'll get in big trouble.

The cake is round, and decorated with M&Ms in a circle around the edge. But while the rest of the cake is uniform, the M&Ms are not: there are multiple colors, and every minion must get exactly the same sequence of M&Ms. Commander Lambda hates waste and will not tolerate any leftovers, so you also want to make sure you can serve the entire cake.

To help you best cut the cake, you have turned the sequence of colors of the M&Ms on the cake into a string: each possible letter (between a and z) corresponds to a unique color, and the sequence of M&Ms is given clockwise (the decorations form a circle around the outer edge of the cake).

Write a function called answer(s) that, given a non-empty string less than 200 characters in length describing the sequence of M&Ms, returns the maximum number of equal parts that can be cut from the cake without leaving any leftovers.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Answer {
    public static int answer(String s) {

        final char[] colours = s.toCharArray();
        final List<Integer> factors = getFactorsOf(colours.length);
        Collections.sort(factors, Collections.<Integer>reverseOrder()); // start from the highest

        for (int i = 0; i < factors.size(); i++) {

            int slices = factors.get(i);
            int sliceSize = colours.length/slices;

            char[] previousSlice = getNthSlice(colours, sliceSize, 0);

            for(int j = 1; j <= slices; j++){ // lazy eval - save ourselves some time
                char[] slice = getNthSlice(colours, sliceSize, j);
                if (!Arrays.equals(slice, previousSlice)) break;
                if (j + 1 == slices) return slices;
                previousSlice = slice;
            }
        }

        return 1; // if we haven't found anything by one point, whole cake is only answer

    }

    private static char[] getNthSlice(char[] colours, int sliceSize, int n) {
        return Arrays.copyOfRange(colours, sliceSize * n, (sliceSize * (n + 1)));
    }


    // we only care about factors
    private static List<Integer> getFactorsOf(final int n) {
        final List<Integer> factors = new ArrayList<>(Collections.singletonList(n)); // n always a factor
        for (int factorNumber = 2; factorNumber < n; factorNumber++){
            if(n % factorNumber == 0) factors.add(factorNumber);
        }
        return factors;
    }


}
