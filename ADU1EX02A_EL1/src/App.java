import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {
    public static void main(String[] args) throws IOException {
        File xmlRuta = new File("resources/llibres.xml");

        String absolutePath = xmlRuta.getAbsolutePath();

        File xml = new File(absolutePath);

        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("llibre");
            System.out.println("Numero de libros " + nList.getLength());

            for(int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nAutor: "  + eElement.getElementsByTagName("autor").item(0).getTextContent());
                    System.out.println("Titol: " + eElement.getElementsByTagName("titol").item(0).getTextContent());
                    System.out.println("Any: " + eElement.getElementsByTagName("any").item(0).getTextContent());
                    System.out.println("Resum: " + eElement.getElementsByTagName("resum").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}