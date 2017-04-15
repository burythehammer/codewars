package com.codewars.challenges;

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
