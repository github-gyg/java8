package lambdaDesignPattern.responsibilityChain;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Test {
    public static void main(String[] args) {
        MsgFilter filter01 = new SensitiveWordFilter();
        MsgFilter filter02 = new HtmlTagFilter();

        filter01.setSuccessor(filter02);
        System.out.println(filter01.startfilter("<h1>这是敏感字符串</h1>"));

        UnaryOperator<String> sentitiveWordFilter = (String msg) -> msg.replace("敏感字符", "**lambda**");
        UnaryOperator<String> htmlTagFilter = (String msg) -> msg.replaceAll("<", "λ").replaceAll(">", "λ");

        Function<String, String> filterChain = sentitiveWordFilter.andThen(htmlTagFilter);
        System.out.println(filterChain.apply("<h1>这是敏感字符串</h1>"));
    }
}
