package po;

public class Selection {

    public String studentId;
    public String courseId;
    public double grade;
    public Selection() {
    }

    public Selection(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade=0;
    }

    public Selection(String studentId, String courseId, double grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
