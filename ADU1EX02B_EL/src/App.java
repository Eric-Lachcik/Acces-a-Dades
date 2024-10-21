import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            LlibreHandler handler = new LlibreHandler();
            saxParser.parse(new File("resources/llibres.xml"), handler);

            List<Llibre> llibres = handler.getLlibres();
            for (Llibre llibre : llibres) {
                System.out.println("\r");
                System.out.println(llibre);
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
