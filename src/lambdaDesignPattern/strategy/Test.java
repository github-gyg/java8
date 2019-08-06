package lambdaDesignPattern.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        Validator numericValidator = new Validator(new ValidationStrategy() {
            @Override
            public boolean apply(String s) {
                return s.matches("\\d+");
            }
        });
        boolean isNumeric = numericValidator.validate("123");


        Validator lowerCaseValidator = new Validator(new ValidationStrategy() {
            @Override
            public boolean apply(String s) {
                return s.matches("[a-z]+");
            }
        });
        boolean isLowerCase = lowerCaseValidator.validate("abc");




        Validator numericLambdaValidator = new Validator(s -> s.matches("\\d+"));

        Validator lowerCaseLambdaValidator = new Validator(s -> s.matches("[a-z]+"));

        Validator numericAndlowerCaseLambdaValidator = new Validator(s -> s.matches("[a-z]+") && s.matches("\\d+"));













       /* List<Integer> integers = Arrays.asList(2,4,67,1,54,1,8712,24);
        Comparator<Integer> comparator = (x, y) -> (x < y) ? -1 : ((x.equals(y)) ? 0 : 1);
        integers.sort(comparator.reversed());
        System.out.println(integers);

        // 多字段排序
        List<Apple> apples = Arrays.asList(new Apple(1, "red"), new Apple(2, "red"),
                new Apple(3, "green"), new Apple(4, "green"), new Apple(5, "yellow"));
        List<Apple> collect = apples.stream().sorted(Comparator.comparing(Apple::getColor).thenComparing(Apple::getWeight)).collect(Collectors.toList());
        System.out.println(collect);*/
    }

    private static class Apple {
        private int weight;
        private String color;

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}