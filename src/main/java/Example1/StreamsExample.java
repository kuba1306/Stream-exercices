package Example1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class StreamsExample {

    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Employee employee1;
        employee1 = new Employee("Butawhiteboy", "Cantbekhan", 25, List.of("Java", "JavaScript", "Angular"));
        Employee employee2 = new Employee("Oscarbait", "Clavichord", 31, List.of("C#"));
        Employee employee3 = new Employee("Syphilis", "Charizard", 23, List.of("Java", "Haskell", "Scala"));
        Employee employee4 = new Employee("Budapes", "Vegemite", 42, List.of("PHP", "JavaStript", "React", "Angular"));
        Employee employee5 = new Employee("Timothy", "Cumbercooch", 38, List.of("Java", "Scala"));
        Employee employee6 = new Employee("Brandenburg", "Cramplesnutch", 30, List.of("C", "C#"));
        Employee employee7 = new Employee("Blubberwhale", "Cragglethatch", 27, List.of("Rust", "Python"));
        Employee employee8 = new Employee("Whippersnatch", "Talisman", 51, List.of("Java", "Spring", "Hibernate", "Java"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
    }

    @Test
    public void firstStream() {
        employees.stream()
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void mapOperation() {
        employees.stream()
                .map(employee -> employee.getFirstName())
                .forEach(System.out::println);
    }

    @Test
    public void mapOperationNameandSurname() {
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .forEach(System.out::println);
    }

    @Test
    public void flatMapOperation() {

        List<List<String>> allSkills = employees.stream()
                .map((Employee::getSkills))
                .collect(Collectors.toList());

        System.out.println(allSkills);

        List<String> allSkills2 = employees.stream()
                .map(Employee::getSkills)
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(allSkills2);
    }

    @Test
    public void filterOperation() {
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .forEach(System.out::println);
    }

    @Test
    public void sortedOperationByAge() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
    }

    @Test
    public void sortedOperationByLastName() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .forEach(System.out::println);
    }

    @Test
    public void limitOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void skipOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .skip(5)
                .forEach(System.out::println);
    }

    @Test
    public void countOperation() {
        long numberOfEmployees = employees.stream()
                .count();

        System.out.println(numberOfEmployees);
    }

    @Test
    public void countOperationStartsWithLetter() {
        long numberOfEmployeesStartsWithLetter = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .count();

        System.out.println(numberOfEmployeesStartsWithLetter);
    }

    @Test
    public void minOperation() {
        Employee youngestEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getAge)).get();

        System.out.println(youngestEmployee);
    }

    @Test
    public void maxOperation() {
        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getAge)).get();

        System.out.println(oldestEmployee);
    }

    @Test
    public void findFirstOperation() {
        Employee employee1 = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .findFirst().get();

        System.out.println(employee1);
    }

    @Test
    public void findAnyOperation() {
        Employee employee2 = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .findAny().get();

        System.out.println(employee2);
    }

    @Test
    public void allMatchOperationStartsWith() {
        boolean b = employees.stream()
                .allMatch(emp -> emp.getFirstName().startsWith("B"));
        System.out.println(b);
    }

    @Test
    public void allMatchOperationContain() {
        boolean c = employees.stream()
                .allMatch(emp -> emp.getFirstName().contains("a"));
        System.out.println(c);
    }

    @Test
    public void anyMatchOperationContain() {
        boolean d = employees.stream()
                .anyMatch(emp -> emp.getFirstName().contains("a"));
        System.out.println(d);
    }

    @Test
    public void noneMatchOperationStartsWith() {
        boolean e = employees.stream()
                .noneMatch(emp -> emp.getFirstName().startsWith("Z"));
        System.out.println(e);
    }

    //    @Test
//    public void reduceOperation() {
//        employees.stream()
//                .map(Employee::getAge)
//                .reduce((age1, age2) -> age1 + age2)
//                .get();
//    }
//
    @Test
    public void reduceOperation() {

        Integer sumOfAllAges = employees.stream()
                .map(Employee::getAge)
                .reduce((age1, age2) -> age1 + age2)
                .get();

        System.out.println(sumOfAllAges);

        int sumOfAllAges2 = employees.stream()
                .map(Employee::getAge)
                .reduce(0,Integer::sum);

        System.out.println(sumOfAllAges2);

        Integer sumAllAges3 = employees.stream()
                .reduce(0, (age, employee) -> age + employee.getAge(), Integer::sum);

        System.out.println(sumAllAges3);

    }

    @Test
    public void takeWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .takeWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test
    public void dropWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .dropWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test
    public void forEachOrdered() {
        String sentence = "Jak nauczyc sie programowania";
        sentence.chars().forEach(s-> System.out.println((char) s ));
    }

}
