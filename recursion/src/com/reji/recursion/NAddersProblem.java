package com.reji.recursion;

import java.util.*;

/**
 * return set of `n` numbers that can add to the given `sum` from the given set of numbers
 */
public class NAddersProblem {
    public static void main(String[] args){
        int sum = 150;
        int[] numbers = new int[]{10, 140, 120, 30, 45, 45, 60, 10, 10, 10, 10, 10};
        int n = 8;
        List<List<Integer>> result = nsome(sum, numbers, n);
        List<List<Integer>> deDupedList = removeDupSets(result);
        System.out.println(deDupedList);
    }


    /**
     * returns sub-set of n numbers from the given list which adds to sum
     * @param sum - total sum
     * @param numbers - the integer array containing numbers to consider
     * @param n - number of numbers in a result subset
     */
    private static List<List<Integer>> nsome(int sum, int[] numbers, int n) {

        // if the smallest number is greater than the sum, then there is no point proceeding.
        // no solution can be arrived with given numbers
        if(sum == 0 || sum < minElement(numbers) || n==0) {
            return null;
        }

        // initialize the result array
        List<List<Integer>> result = new ArrayList<>();

        // boundary condition when n=1 element, then just collect numbers that equal to sum
        if(n == 1) {
            for(int i = 0; i < numbers.length; i++) {
                if(sum == numbers[i]){
                    List<Integer> singleElementList = new ArrayList<>();
                    singleElementList.add(numbers[i]);
                    result.add(singleElementList);
                }
            }
            return result;
        }


        // regular case
        for(int i = 0; i < numbers.length; i++) {

            if(numbers[i] > sum) {
                continue; // skip numbers that are greater than the sum
            }

            // Here, we start defining the sub-problem to create a recursive call
            // recursively call sub-problem and find the result for sub-problem. we need to find a solution from sub-problem
            // that adds with the numbers[i] to form the sum. the recursion should be patterned as
            // nsome(difference, subset of numbers without number[i], n-1);
            List<List<Integer>> subResult = nsome(sum - numbers[i], subSetWithout(numbers, numbers[i]), n-1);

            // if sub-result found, then create combinations of sub-results items with current number[i] and add to result
            if(subResult!=null && subResult.size() > 0) {
                for(int j = 0; j < subResult.size(); j++) {
                    List<Integer> combinedResult = new ArrayList<>();
                    combinedResult.addAll(subResult.get(j));
                    combinedResult.add(numbers[i]);
                    result.add(combinedResult);
                }
            }
        }
        return result;
    }


    /**
     * creates an integer array excluding the given number from it
     * @param source - input array from which number should be excluded
     * @param number - number to be excluded
     * @return
     */
    private static int[] subSetWithout(int[] source, int number) {
        int[] targetArray = new int[source.length - 1];
        boolean omitted = false;

        for(int i = 0, j = 0; i < source.length; i ++) {
            if(source[i] ==  number && !omitted) {
                omitted = true;
                continue;
            }

            targetArray[j] = source[i];
            j++;
        }

        return targetArray;
    }

    /**
     * returns the smallest number in the given array
     * @param numbers
     * @return
     */
    private static int minElement(int[] numbers) {

        if(numbers.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < numbers.length; i ++) {
            if(numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    /**
     * removes duplicate combinations from the given collection of results
     * @param result
     * @return
     */
    private static List<List<Integer>> removeDupSets(List<List<Integer>> result) {

        Map<String, List<Integer>> deDupedMap = new HashMap<>();

        result.forEach( r -> {
            Collections.sort(r);
            deDupedMap.put(r.toString(), r);
        });

        List<List<Integer>> deDupedList = new ArrayList<>();
        for(Map.Entry entry : deDupedMap.entrySet()) {
            deDupedList.add((List<Integer>)entry.getValue());
        }

        return deDupedList;
    }
}
