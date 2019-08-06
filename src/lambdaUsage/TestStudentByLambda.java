package lambdaUsage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class TestStudentByLambda {
    public static void main(String[] args) {
        List<Student> stuList = Arrays.asList(
                new Student("张三","001",19),
                new Student("李四","005",22),
                new Student("王五","180",14),
                new Student("赵六","004",18),
                new Student("小七","006",12),
                new Student("八戒","201",66)
        );
        sortByNo(stuList);
        //筛选所有年龄大于15的学生
        System.out.println("年龄大于15的学生:");
        filterCondition(stuList, stu -> stu.getAge()>15);
        //筛选所有姓张的学生
        System.out.println("所有姓张的学生:");
        filterCondition(stuList, stu -> stu.getName().startsWith("张"));
        //筛选所有学号是6结尾的学生
        System.out.println("所有学号是6结尾的学生:");
        filterCondition(stuList, stu -> stu.getNo().endsWith("6"));
        //筛选任意属性带8的学生（全文搜索）
        System.out.println("任意属性带8的学生:");
        filterCondition(stuList, stu -> Pattern.matches(".*[8八].*", stu+""));
        //筛选所有学生（每一个学生条件为true）
        System.out.println("筛选所有学生:");
        filterCondition(stuList, stu -> true);
    }

    //根据学号排序
    public static void sortByNo(List<Student> list) {
        Collections.sort(list, (s1, s2) -> s1.getNo().compareTo(s2.getNo()));
    }

    public static void filterCondition(List<Student> stuList, Condition<Student> c) {
        for(Student stu:stuList) {
            if(c.test(stu)) {
                System.out.println(stu);
            }
        }
    }

    // 如果感觉jdk8自带的Predidate<T>不够简明实意，可以自己写
    interface Condition<T> {
        public boolean test(T t);
    }

    static class Student {
        private String name;
        private String no;
        private int age;

        public Student() {
        }

        public Student(String name, String no, int age) {
            super();
            this.name = name;
            this.no = no;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", no='" + no + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
