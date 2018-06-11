package sax;


public class test {
    public  static void main(String args[]){
            Dom4jDemo dom4jDemo=new Dom4jDemo();
            dom4jDemo.parserXml("source/xml/CommerceCourses.xml");
            Paser paser=new Paser();
            paser.paserUnitedStudent("source/xml/UnitedStudent1.xml");
            paser.paserSoftwareStudent("source/xml/SoftwareStudent1.xml");
            paser.paserCommerceStudent("source/xml/CommerceStudent1.xml");
            paser.paserMathStudent("source/xml/MathStudent1.xml");
            paser.paserUniteCourse("source/xml/UniteCourses.xml");
            paser.paserCommerceCourse("source/xml/CommerceCourses.xml");
            paser.paserSoftwareCourse("source/xml/SoftwareCourses.xml");
            paser.paserMathCourse("source/xml/MathCourses.xml");
            paser.paserUniteSelection("source/xml/UniteSelectionExam.xml");
            paser.paserSoftwareSelection("source/xml/SoftwareSelectionExam.xml");
            paser.paserCommerceSelection("source/xml/CommerceSelectionExam.xml");
            paser.paserMathSelection("source/xml/MathSelectionExam.xml");
    }
}
