import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class filterAgeThroughSortedLastName {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Aditya Dubey", 97),
                new Student("Awadhesh Pratap Dwivedi", 99),
                new Student("Madhu Dwivedi", 28),
                new Student("Deepika Dwivedi", 25));
        int marks = 29;
        students.stream().filter(x -> x.getMarks() > marks).sorted(Comparator.comparing(Student::lastName)).toList().forEach(System.out::println);
        // Checking for last name of each student
        for(Student s : students){
            System.out.println(s.lastName());
        }
    }
}
class Student{
    int marks;
    private String name;
    public Student(String name,int marks){
        this.marks = marks;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }
    public String lastName(){
        String[] nameParts = name.split(" ");
        return nameParts[nameParts.length -1];

    }
    @Override
    public String toString(){
        return  "Student{name='" + name + "', marks=" + marks + "}";
    }
}
