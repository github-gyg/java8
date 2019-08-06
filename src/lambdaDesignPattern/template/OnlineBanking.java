package lambdaDesignPattern.template;

public abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);

    protected static class Customer {
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
                case 1:
                    return new Customer(){{setName("vip1");}};
                case 2:
                    return new Customer(){{setName("vip2");}};
                default:
                    return new Customer();
            }
        }
    }
}
