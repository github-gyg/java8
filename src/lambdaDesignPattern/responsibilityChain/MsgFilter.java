package lambdaDesignPattern.responsibilityChain;

public abstract class MsgFilter {

    private MsgFilter successor;

    public void setSuccessor(MsgFilter successor) {
        this.successor = successor;
    }

    public String startfilter(String msg) {
        return successor == null ? doFilter(msg) : successor.startfilter(doFilter(msg));
    }

    protected abstract String doFilter(String msg);
}
