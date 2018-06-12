package servlet;

import po.Course;
import po.Selection;

import java.util.ArrayList;

public class Tools {

    public static final boolean judgeIsIn(ArrayList<Selection> selections, Course course) {

        for (Selection s:selections) {
            System.out.println(course.courseId);
            System.out.println(s.courseId);
            if (course.courseId.equals(s.courseId)) {
                return true;
            }
        }

        return false;
    }
}
