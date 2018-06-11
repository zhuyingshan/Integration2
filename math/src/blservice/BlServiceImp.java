package blservice;

import dataUtils.CreateXML;
import dataservice.MathService;
import dataservice.MathServiceImp;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public class BlServiceImp implements BlService {
    MathService mathService=new MathServiceImp();

    @Override
    public String login(String studentID, String studentName) {
        return  mathService.login(studentID,studentName).toString();
    }

    @Override
    public String getCourseList() {
        return CreateXML.CoursesXML(mathService.getCourseList());
    }

    @Override
    public String getHistorySel(String studentID) {
        return CreateXML.SelectionXML(mathService.getHistorySel(studentID));
    }

    @Override
    public String select(String studentID, String coureseID) {
        return mathService.select(studentID,coureseID)==true?"true":"false";
    }
}
