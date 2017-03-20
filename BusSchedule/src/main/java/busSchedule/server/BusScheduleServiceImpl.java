package busSchedule.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import busSchedule.client.services.BusScheduleService;
import org.jdom2.Content;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class BusScheduleServiceImpl extends RemoteServiceServlet implements BusScheduleService {

    private String path = "C:\\NCHomeWork\\BusSchedule\\src\\main\\resources\\schedule.xml";

    public String loadTable() {
        return showPage(1);
    }

    public String addRow(String str) {
        try {
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

            XMLOutputter out = new XMLOutputter();
            FileWriter writer = new FileWriter(path);

            out.output((List<? extends Content>) rootElement, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parse();
    }

    public String deleteRow(int number) {
        return "";
    }

    public String pressNextPage(int number) {
        return showPage(number);
    }

    public String pressPreviousPage(int number) {
        return showPage(number);
    }

    public String showPage(int number) {
        String str = parse();
        String[] data = str.split("/");
        String result = "";
        if (number * 40 <= data.length) {
            for (int i = (number - 1) * 40; i < number * 40; i++) {
                if (i != number * 40 - 1) {
                    result += data[i] + "/";
                } else {
                    result += data[i];
                }
            }
        } else {
            for (int i = (number - 1) * 40; i < data.length; i++) {
                if (i != data.length - 1) {
                    result += data[i] + "/";
                } else {
                    result += data[i];
                }
            }
        }
        return result;

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