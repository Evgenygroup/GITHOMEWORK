import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XFileToJava {

    public static void main(String[] args) throws Exception {


        File file = new File("person.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();

        List<Person> persons = new ArrayList<>();
        NodeList personNodes = document.getElementsByTagName("person");

        for (int i = 0; i < personNodes.getLength(); i++) {
            String name = document.getElementsByTagName("name").item(i).getTextContent();
            String gender = document.getElementsByTagName("gender").item(i).getTextContent();
            String street = document.getElementsByTagName("street").item(i).getTextContent();
            int houseNumber = Integer.parseInt(document.getElementsByTagName("house_number")
                    .item(i).getTextContent());

            persons.add(new Person(name, gender, new Address(street, houseNumber)));

        }
        System.out.println(persons);


    }
}



