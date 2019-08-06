package lambdaDesignPattern.observe;

import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        CCTV1 cctv1 = new CCTV1();
        cctv1.registerPeople(new Teacher()).registerPeople(new Athlete()).registerPeople(new Programmer());
        cctv1.notifyPeople("爱学习，爱运动，远离BUG");


        CCTV1Lambda cctv1Lambda = new CCTV1Lambda();

        cctv1Lambda.registerConsumer(news -> {
            if (news.contains("学习"))
                System.out.println("活到老，学到老 lambda");
        });

        cctv1Lambda.registerConsumer(news -> {
            if (news.contains("运动")) {
                System.out.println("生命在于运动 lambda");
            }
        });

        cctv1Lambda.registerConsumer(news -> {
            if (news.contains("相亲")) {
                System.out.println("用不着，我可以自己new对象 lambda");
            }
        });

        cctv1Lambda.notifyPeople("爱学习，爱运动，远离BUG");
    }

    static class Teacher implements People {
        @Override
        public void accept(String news) {
            if (news.contains("学习")) {
                System.out.println("活到老，学到老");
            }
        }
    }

    static class Athlete implements People {
        @Override
        public void accept(String news) {
            if (news.contains("运动")) {
                System.out.println("生命在于运动");
            }
        }
    }

    static class Programmer implements People {
        @Override
        public void accept(String news) {
            if (news.contains("相亲")) {
                System.out.println("用不着，我可以自己new对象");
            }
        }
    }
}
