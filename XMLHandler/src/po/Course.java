package po;

public class Course {

    public String courseId;
    public String courseName;
    public String teacher;
    public char isShare;

    public Course() {
    }

    public Course(String courseId, String courseName, String teacher, char isShare) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
        this.isShare = isShare;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public char getIsShare() {
        return isShare;
    }

    public void setIsShare(char isShare) {
        this.isShare = isShare;
    }
}
