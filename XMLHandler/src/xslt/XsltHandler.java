package xslt;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.XMLResult;

import java.io.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltHandler {

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

    public static void transformXml(InputStream srcStream, OutputStream destStream, TramsformType type) {
        //InputSteam in=new ByteArrayInputStream(str.getBytes()); �ַ������������
        String xsltFile = "";
        switch (type) {
            case COURSETOC:
                xsltFile = "";
                break;
            case COURSETOM:
                xsltFile = "";
                break;
            case COURSETOS:
                xsltFile = "";
                break;
            case STUDENTTOC:
                xsltFile = "";
                break;
            case STUDENTTOM:
                xsltFile = "";
                break;
            case STUDENTTOS:
                xsltFile = "";
                break;
            case SELECTIONTOC:
                xsltFile = "";
                break;
            case SELECTIONTOM:
                xsltFile = "";
                break;
            case SELECTIONTOS:
                xsltFile = "";
                break;
            case COURSETOUNITE:
                xsltFile = "";
                break;
            case STUDENTTOUNITE:
                xsltFile = "";
                break;
            case SELECTIONTOUNITE:
                xsltFile = "";
                break;
        }
        Source srcSource = new StreamSource(srcStream);
        Result destResult = new StreamResult(destStream);
        Source xsltSource = new StreamSource(xsltFile);

        try {
            TransformerFactory transFact = TransformerFactory.newInstance();
            Transformer trans = transFact.newTransformer(xsltSource);
            trans.transform(srcSource, destResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

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

    public static void main(String[] args) throws Exception {

        String srcXml = "source/xml/CommerceCourses.xml";
        FileReader reader = new FileReader(srcXml);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        System.out.print(str);
        System.out.print(formatXML(str, TramsformType.COURSETOUNITE));
    }
}
