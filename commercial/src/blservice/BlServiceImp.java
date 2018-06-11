package blservice;

import dataUtils.CreateXML;
import dataservice.CommerceService;
import dataservice.CommerceServiceImp;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public class BlServiceImp implements BlService {
    CommerceService commerceService=new CommerceServiceImp();

    @Override
    public String login(String studentID, String studentName) {
        return  commerceService.login(studentID,studentName).toString();
    }

    @Override
    public String getCourseList() {
        return CreateXML.CoursesXML(commerceService.getCourseList());
    }

    @Override
    public String getHistorySel(String studentID) {
        return CreateXML.SelectionXML(commerceService.getHistorySel(studentID));
    }

    @Override
    public String select(String studentID, String coureseID) {
        return commerceService.select(studentID,coureseID)==true?"true":"false";
    }

    /**
     * @param courseID
     * @param studentID
     */
    @Override
    public String deleteCourse(String courseID, String studentID) {
        return commerceService.deleteCourse(courseID,studentID)==true?"true":"false";
    }
}
