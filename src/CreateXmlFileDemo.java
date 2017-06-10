import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by esephak on 6/7/2017.
 */
public class CreateXmlFileDemo {
    public static void main(String[] args){

        try{
            File myFile = new File("car.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();


            Element rootElement = document.createElement("cars");
            document.appendChild(rootElement);

            Element superClass = document.createElement("supercars");
            rootElement.appendChild(superClass);

            Attr attr = document.createAttribute("company");
            attr.setValue("Ferrari");

            superClass.setAttributeNode(attr);

            //Car name Elements
            Element carName = document.createElement("carname");
            carName.setAttribute("type", "formula one");
            carName.appendChild(document.createTextNode("formula one"));
            superClass.appendChild(carName);

            Element carName1 = document.createElement("carname");
            carName1.setAttribute("type", "formula one");
            carName1.appendChild(document.createTextNode("formula one"));
            superClass.appendChild(carName1);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("cars.xml");
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
            transformer.transform(source, result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

