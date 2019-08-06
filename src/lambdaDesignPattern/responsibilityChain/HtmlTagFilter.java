package lambdaDesignPattern.responsibilityChain;

public class HtmlTagFilter extends MsgFilter {
    @Override
    public String doFilter(String msg) {
        return msg.replaceAll("<", "*").replaceAll(">", "*");
    }
}
