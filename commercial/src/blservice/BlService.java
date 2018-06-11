package blservice;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public interface BlService {
    /**
     * 选课结果，返回的是三种结果的String
     * @param studentID
     * @param studentName
     * @return
     */
    public String login(String studentID, String studentName);

    /**
     * 返回软件课程列表格式的XML字符串
     * @return
     */
    public String getCourseList();

    /**
     * 返回软件学院选课格式的XML字符串
     * @param studentID
     * @return
     */
    public String getHistorySel(String studentID);

    /**
     * 返回结果，true,false
     * @param studentID
     * @param coureseID
     * @return
     */
    public String select(String studentID, String coureseID);
    /**
     *
     */
    public String deleteCourse(String courseID,String studentID);
}
