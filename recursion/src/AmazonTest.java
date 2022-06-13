import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class AmazonTest {

    /*
     * Complete the 'countDecreasingRatings' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY ratings as parameter.
     */

    public static long countDecreasingRatings(List<Integer> ratings) {
        // Write your code here
        long result = 0;
        if(ratings.size() == 0) {
            return (long)0;
        }

        if(ratings.size() == 1) {
            return (long)1;
        }

        for(int groupSize = 2; groupSize < ratings.size() - 1; groupSize++) {
            result = result + countDecreasingRatingsByGroupSize(ratings, groupSize);
        }

        return result;

    }

    public static long countDecreasingRatingsByGroupSize(List<Integer> ratings, int groupSize) {

        if(groupSize == 1) {
            return ratings.size();
        }

        long periods = 0;
        int prevRating = ratings.get(0);
        boolean groupStarted = false;

        int counter = 0;
        for(int i = 1 ; i < ratings.size(); i++) {


            if(counter > 0 && counter%groupSize == 0) {
                if(groupStarted) {
                    groupStarted = false;
                    periods++;
                    counter = 0;
                }
            }


            // case of decreased rating
            if(ratings.get(i) < prevRating) {
                if(groupStarted) {
                    counter++;
                    prevRating = ratings.get(i);
                    continue;
                }

                groupStarted = true;
                prevRating = ratings.get(i);
                counter++;
                continue;
            }

            // case of not decreasing
            if(ratings.get(i) > prevRating){
                if(groupStarted) {
                    counter = 0;
                   i--; // a new group could potentially begin from current pos. So to be inclusive, back track by one position
                    groupStarted = false;
                }
            }
        }
        return periods;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> input = Arrays.asList(4,3,5,4,3);
        System.out.print(countDecreasingRatings(input));
    }
}
