package lambdaUsage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.function.*;

public class WhatIsLambda {
    /*@FunctionalInterface
    interface NoParamNoReturnType {
        void func();
    }

    public static void main(String[] args) {
        NoParamNoReturnType helloFunction = () -> System.out.println("hello lambda");
        helloFunction.func();

        NoParamNoReturnType emptyFunction = () -> {};
        emptyFunction.func();
    }*/

    /*@FunctionalInterface
    interface TwoParamOneReturnType {
        int func(int a, int b);
    }

    public static void main(String[] args) {
        // 加法的lambda表示
        TwoParamOneReturnType addFunction = (a, b) -> a+b;
        System.out.println(addFunction.func(1, 2));

        // 减法的lambda表示
        TwoParamOneReturnType reduceFunction = (a, b) -> a-b;
        System.out.println(reduceFunction.func(1, 2));

        // 乘法的lambda表示
        TwoParamOneReturnType multipleFunction = (a, b) -> a*b;
        System.out.println(multipleFunction.func(1, 2));

        // 除法的lambda表示
        TwoParamOneReturnType devideFunction = (a, b) -> a/b;
        System.out.println(devideFunction.func(1, 2));

        // 随意的功能实现，只要符合TwoParamOneReturnType意义，都可以作为TwoParamOneReturnType变量的值
        TwoParamOneReturnType nonsenseFunction = (a, b) -> 666;
        System.out.println(nonsenseFunction.func(1, 2));
    }*/

    /** 方法引用*/
    public static void main(String[] args) {
        List<Integer> score = Arrays.asList(91, 88, 2, 12, 3, 42);
        score.sort((num1, num2) -> num1 - num2);
        score.forEach(num -> System.out.println(num));

        score.sort(Integer::compare);
        score.forEach(System.out::println);
    }

    public static void main02(String[] args) {
        Runnable task = () -> System.out.println("hello lambda");
        new Thread(task).start();

        Comparator<Integer> cmp = (a, b) -> a - b;
        List<Integer> integers = Arrays.asList(91, 88, 2, 12, 3, 42);
        integers.sort(cmp);
        System.out.println(integers);

    }

    public static void main01(String[] args) {
        Predicate<String> pwdValidateFunc = pwd -> (1 <= pwd.length() && pwd.length() <= 6) && !pwd.contains("?");
        System.out.println(pwdValidateFunc.test("123456"));

        Predicate<String> pwdValidateFuncUseAnd = pwd -> (1 <= pwd.length() && pwd.length() <= 6);
        pwdValidateFuncUseAnd.and(pwd -> !pwd.contains("?"));

        BiPredicate<String, String> loginValidateFunc = (name, pwd) -> "admin".equals(name) && "123456".equals(pwd);
        System.out.println(loginValidateFunc.test("admin", "admin"));


        Consumer<String> eatFunc = food -> System.out.println("eat " + food);
        eatFunc.accept("汉堡包");


        Function<Integer, String> toPercentFunc = score -> score+"%";
        System.out.println(toPercentFunc.apply(1));


        Supplier<String> randomNameFunc = () -> Arrays.asList("悟空", "八戒", "沙僧").get((int) (Math.random()*3));
        System.out.println(randomNameFunc.get());

        UnaryOperator<Integer> growTenFunc = num -> num + 10;
        System.out.println(growTenFunc.apply(10));

        BinaryOperator<Integer> numsDiffFunc = (a, b) -> a-b;
        System.out.println(numsDiffFunc.apply(10, 10));

    }
}
