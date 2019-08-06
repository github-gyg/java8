package lambdaUsage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class BehaveParameterization {
    public static void main(String[] args) {
        List<Integer> scoreLs = Arrays.asList(91, 88, 2, 12, 3, 42, 66, 28, 7, 10);

        Predicate<Integer> filterCondition = score -> score < 60;
        List<Integer> scoresLessThan60 = filterByLambda(scoreLs, filterCondition);
        System.out.println(scoresLessThan60);

        System.out.println(Pattern.matches(".*8.*", "8"));

        List<Integer> scoresEven = filterByLambda(scoreLs, score -> score%2 == 0);
        System.out.println(scoresEven);
    }

    public static List<Integer> filterScoreGreaterThan50(List<Integer> scores) {
        ArrayList<Integer> ret = new ArrayList<>(scores.size());
        for (Integer score : scores) {
            if (score > 50) ret.add(score);
        }
        return ret;
    }

    public static List<Integer> filterScore(List<Integer> scores, int min) {
        ArrayList<Integer> ret = new ArrayList<>(scores.size());
        for (Integer score : scores) {
           if (score > min) ret.add(score);
        }
        return ret;
    }

    public static List<Integer> filterByLambda(List<Integer> scores, Predicate<Integer> condition) {
        ArrayList<Integer> ret = new ArrayList<>(scores.size());
        for (Integer score : scores) {
            if (condition.test(score)) ret.add(score);
        }
        return ret;
    }


}


