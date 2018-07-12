package com.india;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
public class XMLDomExample {
    List friends;
    Document dom;
    public XMLDomExample() {
        friends = new ArrayList();
    }
public static void main(String[] args)throws IOException {
        //create an instance
        //OCJP: Create object of the same class
        //To access no static methods from static
        XMLDomExample obj = new XMLDomExample();
        obj.run();   //UDF
    }
    public void run() {
        //parse the xml file and get the dom object
        parseXmlFile();  //UDF
        //get each employee element and create a Employee object
        parseDocument();  //UDF
        //Iterate through the list and print the data
        printData();  //UDF
    }
    private void parseXmlFile() {
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //parse using builder to get DOM representation of the XML file
            dom = db.parse("friends.xml");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    private void parseDocument() {
        //get the root elememt
        Element docEle = dom.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Friend");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Element el = (Element) nl.item(i);
                Friend e = getFriend(el);   //UDF
                friends.add(e);  //Add to ArrayList
            }
        }
    }
    private Friend getFriend(Element element) {
        String name = getTextValue(element, "Name");  //UDF
        int age = getIntValue(element, "Age"); //UDF
        Friend f = new Friend(name, age); //Bean PC
        return f;
    }
    private String getTextValue(Element element, String tagName) {
        String textVal = null;
        NodeList nl = element.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }
        return textVal;
    }
    private int getIntValue(Element element, String tagName) {
        //in production application you would catch the exception
        return Integer.parseInt(getTextValue(element, tagName));
    }
    private void printData() {
        System.out.println("No of Friends '" + friends.size() + "'.");
        Iterator it = friends.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
