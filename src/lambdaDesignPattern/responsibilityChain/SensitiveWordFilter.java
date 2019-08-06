package lambdaDesignPattern.responsibilityChain;

public class SensitiveWordFilter extends MsgFilter {
    @Override
    public String doFilter(String msg) {
        return msg.replace("敏感字符", "****");
    }
}
