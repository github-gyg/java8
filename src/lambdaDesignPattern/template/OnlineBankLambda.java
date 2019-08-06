package lambdaDesignPattern.template;

import java.util.function.Consumer;

public class OnlineBankLambda {
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

   public static class Customer {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class Database {
        static Customer getCustomerWithId(int id) {
            switch (id) {
                case 2:
                    return new Customer(){{setName("vip2");}};
                case 1:
                    return new Customer(){{setName("vip1");}};
                default:
                    return new Customer();
            }
        }
    }
}
