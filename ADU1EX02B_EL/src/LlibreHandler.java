import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class LlibreHandler extends DefaultHandler {
    private List<Llibre> llibres = new ArrayList<>();
    private Llibre llibreActual;
    private StringBuilder contingutActual;

    public List<Llibre> getLlibres() {
        return llibres;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        contingutActual = new StringBuilder();
        if (qName.equals("llibre")) {
            llibreActual = new Llibre(null, null, null, null);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (llibreActual != null) {
            switch (qName) {
                case "titol":
                    llibreActual = new Llibre(contingutActual.toString(), llibreActual.getAutor(), llibreActual.getany(), llibreActual.getResum());
                    break;
                case "autor":
                    llibreActual = new Llibre(llibreActual.getTitol(), contingutActual.toString(), llibreActual.getany(), llibreActual.getResum());
                    break;
                case "any":
                    llibreActual = new Llibre(llibreActual.getTitol(), llibreActual.getAutor(), Integer.parseInt(contingutActual.toString()), llibreActual.getResum());
                    break;
                case "resum":
                    llibreActual = new Llibre(llibreActual.getTitol(), llibreActual.getAutor(), llibreActual.getany(), contingutActual.toString());
                    break;
                case "llibre":
                    llibres.add(llibreActual);
                    break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        contingutActual.append(new String(ch, start, length));
    }
}
