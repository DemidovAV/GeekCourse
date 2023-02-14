import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson8Main {


    public static void main(String[] args) {
        String[] array = {"dog", "cat", "bull", "cat", "dog", "fish", "dog", "bull", "bird"};


        String result = Arrays.stream(array).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .max(Comparator.comparingLong(Map.Entry::getValue))
                        .get().getKey();
        System.out.println(result);

        Employee[] employees = {new Employee("Vasiliy", 25, 70000),
                new Employee("Victor", 28, 89000),
                new Employee("Roman", 29, 95000),
                new Employee("Svetlana", 25, 75000),
                new Employee("Zinaida", 50, 84000),
                new Employee("Vladimir", 50, 150000)};

        OptionalDouble avSalary = Arrays.stream(employees).mapToInt(Employee::getSalary).average();
        if (avSalary.isPresent()) {
            System.out.println("—редн€€ зарплата сотрудника: " + Math.round(avSalary.getAsDouble()) + " руб.");
        }

        oldFarts(employees);

        oldestEmployees(employees, 3);


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
        int numberOfOldFarts = (int) Arrays.stream(array)
                .filter(n -> n.getAge() == (Arrays.stream(array).mapToInt(Employee::getAge).max().getAsInt())).count();

        System.out.println(Arrays.stream(array)
                .filter(n -> n.getAge() == (Arrays.stream(array).mapToInt(Employee::getAge).max().getAsInt()))
                .map(Employee::getName).collect(Collectors.joining(", ", numberOfOldFarts + " старейших сотрудников зовут: ", ";")));

    }
    public static void oldestEmployees(Employee[] array, int N){
        System.out.println(Arrays.stream(array).sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(N).map(Employee::getName)
                .collect(Collectors.joining(", ",  N + " самых старших сотрудников зовут: ", ";")));
    }
}
