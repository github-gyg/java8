package lambdaDesignPattern.template;

public class Test {
    public static void main(String[] args) {
        new OasisBank().processCustomer(1);

        new OasisBankLambda().processCustomer(2);
    }
}
