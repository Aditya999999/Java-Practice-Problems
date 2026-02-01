import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class sortedLastName {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Aditya Dubey", 99),
                new Student("Shreya Saini", 56),
                new Student("Ishika Chhabra", 90),
                new Student("Bhawna Menghani", 70)
        );
        int marks = 70;
        students.stream().filter(x -> x.getMarks() > marks).sorted(Comparator.comparing(Student::getLastName)).toList().forEach(System.out::println);
    }
}
class Student{
    int marks;
    private String name;

    public Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }
    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
    public String getLastName(){
        String[] nameParts = name.split(" ");
        return nameParts[nameParts.length-1];
    }
    @Override
    public String toString(){
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}
