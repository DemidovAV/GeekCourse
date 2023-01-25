import java.util.Arrays;
import java.util.stream.Stream;

public class Lesson8Main {


    public static void main(String[] args) {
        String[] array = {"dog", "cat", "bull", "cat", "dog", "fish", "dog", "bull", "bird"};


        Employee[] employees = {new Employee("Vasiliy", 25, 70000),
                new Employee("Victor", 28, 89000),
                new Employee("Roman", 29, 95000),
                new Employee("Svetlana", 25, 75000),
                new Employee("Zinaida", 50, 84000)
                new Employee("Vladimir", 50, 150000)};


        System.out.println(Arrays.stream(employees).mapToInt(Employee::getSalary).average());

    }
    static class Employee {
        private String name;
        private int age;
        private int salary;

        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getSalary() {
            return salary;
        }
    }

    public static void oldFarts(Employee[] array) {
    }
}
