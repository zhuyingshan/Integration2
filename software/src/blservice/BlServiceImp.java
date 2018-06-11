package blservice;

import dataUtils.CreateXML;
import dataservice.SoftwareService;
import dataservice.SoftwareServiceImp;
import po.Course;
import po.LoginResult;
import po.Selection;

import java.util.ArrayList;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public class BlServiceImp implements  BlService{
    SoftwareService softwareService=new SoftwareServiceImp();

    @Override
    public String login(String studentID, String studentName) {
        System.out.println(studentID);
        return  softwareService.login(studentID,studentName).toString();
    }

    @Override
    public String getCourseList() {
        String str=CreateXML.CoursesXML(softwareService.getCourseList());

        return str;
    }

    @Override
    public String getHistorySel(String studentID) {
        return CreateXML.SelectionXML(softwareService.getHistorySel(studentID));
    }

    @Override
    public String select(String studentID, String coureseID) {
        System.out.println(studentID);
        System.out.println(coureseID);
        return softwareService.select(studentID,coureseID)==true?"true":"false";
    }
    /**
     * @param courseID
     * @param studentID
     */
    @Override
    public String deleteCourse(String courseID, String studentID) {
        return softwareService.deleteCourse(courseID,studentID)==true?"true":"false";
    }
}
