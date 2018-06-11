package format;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentSource;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Created by 朱应山 on 2018/6/11.
 */
public class Format {
    public static String formatXML(String srcXML, TramsformType type) {
        String dst = "";
        String xsltFile = "";
        switch (type) {
            case COURSETOUNITE:
                xsltFile = "source/xsl/UniteCourses.xsl";
                break;
            case STUDENTTOUNITE:
                xsltFile = "source/xsl/UnitedStudent.xsl";
                break;
            case SELECTIONTOUNITE:
                xsltFile = "source/xsl/UniteSelectionList.xsl";
                break;
        }
        try {
            Document xmldoc = DocumentHelper.parseText(srcXML);
            Source srcSource = new DocumentSource(xmldoc);
            Source xsltSource = new StreamSource(xsltFile);
            TransformerFactory transFact = TransformerFactory.newInstance();
            Transformer trans = transFact.newTransformer(xsltSource);
            ByteArrayOutputStream destResult = new ByteArrayOutputStream();
            trans.transform(srcSource, new StreamResult(destResult));
            dst = destResult.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return dst;
    }
/*
    public static void transformXmlByXslt(String srcXml, String dstXml, String xslt) {

        TransformerFactory tf = TransformerFactory.newInstance();

        try {
            Transformer transformer = tf.newTransformer(new StreamSource(xslt));
            transformer.transform(new StreamSource(srcXml),
                    new StreamResult(new FileOutputStream(dstXml)));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public  static void transformXml(InputStream srcStream, OutputStream destStream, TramsformType type){
        //InputSteam in=new ByteArrayInputStream(str.getBytes()); �ַ������������
        String xsltFile="";
        switch (type){
            case COURSETOC:xsltFile="";break;
            case COURSETOM:xsltFile="";break;
            case COURSETOS:xsltFile="";break;
            case STUDENTTOC:xsltFile="";break;
            case STUDENTTOM:xsltFile="";break;
            case STUDENTTOS:xsltFile="";break;
            case SELECTIONTOC:xsltFile="";break;
            case SELECTIONTOM:xsltFile="";break;
            case SELECTIONTOS:xsltFile="";break;
            case COURSETOUNITE:xsltFile="";break;
            case STUDENTTOUNITE:xsltFile="";break;
            case SELECTIONTOUNITE:xsltFile="";break;
        }
        Source srcSource = new StreamSource(srcStream);
        Result destResult = new StreamResult(destStream);
        Source xsltSource = new StreamSource(xsltFile);


    }
    public static void main(String[] args) {
        String srcXml = "source/xml/UniteCourses.xml";
        String dstXml = "source/targetxml/CommerceCourses.xml";
        String xslt = "source/xsl/CourseToC.xsl";
        transformXmlByXslt(srcXml,dstXml,xslt);
    }

    */


}
