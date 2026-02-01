import java.util.*;

public class maxMarkFromStudentClass {
    public static void main(String[] args) {
        List<StudentDetail> studentDetails = new ArrayList<>();
            studentDetails.add(new StudentDetail("Aditya Dubey", 23));
                    studentDetails.add(new StudentDetail("Aditya Dubey", 24));
                    studentDetails.add(new StudentDetail("Anamaya Pandey", 32));
                    studentDetails.add(new StudentDetail("Rohit Kataria", 23));
                    studentDetails.add(new StudentDetail("Shubham Singh", 25));
                    studentDetails.add(new StudentDetail("XYZ", 4));
        int maxAge = studentDetails.stream().mapToInt(StudentDetail::getAge).max().orElse(0);
        System.out.println(maxAge);
    }
    }
class StudentDetail{
    private String name;
    private Integer age;
    public StudentDetail(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
