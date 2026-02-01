import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupingBy {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("John", 12),
                new Person("Aditya", 24),
                new Person("Awadhesh", 40)
        );
        Map<Integer, List<Person>> groupedByAge = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupedByAge);
    }

}
class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        return "Person{name'"+name+"', age"+age+"}";
    }
}
