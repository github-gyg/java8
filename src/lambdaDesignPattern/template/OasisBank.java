package lambdaDesignPattern.template;

public class OasisBank extends OnlineBanking{
    @Override
    void makeCustomerHappy(Customer c) {
        System.out.println("尊敬的" + c.getName() + "绿洲银行祝您万事如意");
    }
}
