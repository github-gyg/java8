package lambdaDesignPattern.template;

public class OasisBankLambda{
    public void processCustomer(int id) {
        new OnlineBankLambda().processCustomer(id,
                (OnlineBankLambda.Customer c) -> System.out.println("尊敬的" + c.getName() + "绿洲银行教你使用Lambda"));
    }
}
