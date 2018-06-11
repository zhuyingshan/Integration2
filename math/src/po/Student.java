package po;

public class Student {

    public String studentId;
    public String name;
    public String department;
    public String sex;
    public Student() {
    }

    public Student(String studentId, String name, String department, String sex) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.sex = sex;
    }

    public Student(String studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
