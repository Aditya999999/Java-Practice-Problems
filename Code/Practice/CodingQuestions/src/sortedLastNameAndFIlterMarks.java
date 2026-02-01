import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class sortedLastNameAndFIlterMarks {
    public static void main(String[] args) {
        List<Employee> employee = Arrays.asList(
                new Employee("Aditya Dubey", 24),
                new Employee("Madhu Dubey", 49),
                new Employee("Asmita Dubey", 28),
                new Employee("Abhishek Pandey", 38),
                new Employee("Michael Clark", 57)
        );
        int age = 25;
        employee.stream().filter(x -> x.getAge() > age).sorted(Comparator.comparing(Employee::getLastName)).toList().forEach(System.out::println);
    }
}
class Employee{
    private int age;
    String name;
    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String getLastName(){
        String[] lastPart = name.split(" ");
        return lastPart[lastPart.length - 1];
    }
    public String toString(){
        return "Employee{name='" + name + "', age=" + age + "}";

    }}
