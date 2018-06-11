package dataservice;

import format.Format;
import format.TramsformType;
import format.UniteParseXML;
import po.Course;

import java.util.ArrayList;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public class Test {
    public static void main(String []args) {
        String getStr="";//从其他院系获得来的string
        String format= Format.formatXML(getStr, TramsformType.COURSETOUNITE);
        ArrayList<Course> list = UniteParseXML.paserUniteCourse(format);
    }
}
