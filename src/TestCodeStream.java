public class TestCodeStream {

    static class Parent {
        private String a = "p_a";

        // 只在类首次加载执行
        static {
            System.out.println("p_static_statement");
        }

        {
            System.out.println("p_instance_statement");
        }

        public void func() {
            System.out.println(a);
        }

        public Parent() {
            func();
        }
    }

    static class Child extends Parent {
        private String a = "c_a";

        static {
            System.out.println("c_static_statement");
        }

        {
            System.out.println("c_instance_statement");
        }

        public void func() {
            System.out.println(a);
        }

        public Child(){
            // 隐式调用super();
            func();
        }
    }

    public static void main(String[] args) {
//        new Child();
        new Parent();
    }

    public static void main01(String[] args) {
        String s = new String("1") + new String("1");
        // 执行intern()后，s指向常量池中的"11"
        s.intern();
        String s1 = "11";

        System.out.println(s.intern() == s1);
        System.out.println(s == s1);
    }
}
