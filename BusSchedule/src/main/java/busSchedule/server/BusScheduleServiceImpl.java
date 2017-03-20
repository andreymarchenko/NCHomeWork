package busSchedule.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import busSchedule.client.services.BusScheduleService;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class BusScheduleServiceImpl extends RemoteServiceServlet implements BusScheduleService {

    private String path = "C:\\NCHomeWork\\BusScheduleEntryPoint\\src\\main\\resources\\schedule.xml";

    public String addRow(String str) {
        return "ПРИВЕТИКИ";
    /*    try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            String bus[] = str.split("/");
            Element rootElement = doc.createElement("class");
            doc.appendChild(rootElement);

            Element newBus = doc.createElement("bus");
            rootElement.appendChild(newBus);

            Attr attr = doc.createAttribute("number");
            attr.setValue(bus[0]);
            newBus.setAttributeNode(attr);

            Element departure = doc.createElement("departure");
            departure.setTextContent(bus[1]);
            newBus.appendChild(departure);

            Element destination = doc.createElement("destination");
            destination.setTextContent(bus[2]);
            newBus.appendChild(destination);

            Element time = doc.createElement("time");
            time.setTextContent(bus[3]);
            newBus.appendChild(time);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parse();*/
    }

    public String deleteRow(int number) {
        return "";
    }

    public String pressNextPage() {
        return "";
    }

    public String pressPreviousPage() {
        return "";
    }

    public String parse() {
        String result = "";
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("bus");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (temp == nList.getLength() - 1) {
                        result += separateLine(eElement);
                    } else {
                        result += separateLine(eElement) + "/";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String separateLine(Element eElement) {
        return eElement.getAttribute("number") + "/"
                + eElement.getElementsByTagName("departure")
                .item(0)
                .getTextContent()
                + "/"
                + eElement.getElementsByTagName("destination")
                .item(0)
                .getTextContent()
                + "/" + eElement.getElementsByTagName("time")
                .item(0)
                .getTextContent();

    }
}