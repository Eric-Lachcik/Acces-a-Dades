import com.howtodoinjava.xml.model.Employee;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.*;


public class XMLReader {

    File xmlFile = new File("resources/llibres.xml");
    JAXBContext jaxbContext;

    try {
        jaxbContext = JAXBContext.newInstance();
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        //Employee employee = (Employee) jaxbUnmarshaller.unmarshal(xmlFile);
        System.out.println(employee);
    } catch (JAXBException e) {
        e.printStackTrace();
    }
}
