package stream;

import java.util.*;
import java.util.stream.Collectors;

public class WhatIsStream {
    // 筛选出低热量菜肴名称，并按照卡路里排序

    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("猪肉", false, 800, Dish.Type.MEAT),
                new Dish("牛肉", false, 700, Dish.Type.MEAT),
                new Dish("鸡肉", false, 400, Dish.Type.MEAT),
                new Dish("薯条", true, 530, Dish.Type.OTHER),
                new Dish("米饭", true, 350, Dish.Type.OTHER),
                new Dish("水果", true, 120, Dish.Type.OTHER),
                new Dish("披萨", true, 550, Dish.Type.OTHER)
        );

        System.out.println(findLowCaloryDish(dishes));
        System.out.println(findLowCaloryDishLambda(dishes));
    }

    //java7
    public static List<String> findLowCaloryDish(List<Dish> dishList) {
        List<Dish> lowCaloryDishLs = new ArrayList<>(dishList.size());
        for (Dish d : dishList) {
            if (d.getCalories() < 400) {
                lowCaloryDishLs.add(d);
            }
        }

        Collections.sort(lowCaloryDishLs, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloryDishNameLs = new ArrayList<>(lowCaloryDishLs.size());
        for (Dish d : lowCaloryDishLs) {
            lowCaloryDishNameLs.add(d.getName());
        }

        return lowCaloryDishNameLs;
    }

    // java8
    public static List<String> findLowCaloryDishLambda(List<Dish> dishList) {
        List<String> lowCaloryDishNameLs = dishList.stream() // 将数据源转为一个流+++++++
                .filter(d -> {
                    System.out.println("筛选操作：" + d.getName());
                    return d.getCalories() > 300;
                }) // 声明要筛选出卡路里低于400的菜肴
                .map(d -> {
                    System.out.println("提取操作：" + d.getName());
                    return d.getName();
                }) //声明提取菜肴的名称
                .limit(3)
                .collect(Collectors.toList());  //将满足要求的元素收集到一个list

        return lowCaloryDishNameLs;
    }

    static class Dish {
        private String name;
        private boolean vegerarian;
        private int calories;
        private Type type;

        enum Type {MEAT, FISH, OTHER}

        public Dish(String name, boolean vegerarian, int calories, Type type) {
            this.name = name;
            this.vegerarian = vegerarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isVegerarian() {
            return vegerarian;
        }

        public void setVegerarian(boolean vegerarian) {
            this.vegerarian = vegerarian;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }


    }
}
