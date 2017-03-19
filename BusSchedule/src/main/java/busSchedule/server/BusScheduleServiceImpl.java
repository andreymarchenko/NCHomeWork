package busSchedule.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import busSchedule.client.services.BusScheduleService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class BusScheduleServiceImpl extends RemoteServiceServlet implements BusScheduleService {
    // Implementation of sample interface method
    public String addRow(String str) {
        return "";
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
            File inputFile = new File("C:\\NCHomeWork\\BusScheduleEntryPoint\\src\\main\\resources\\schedule.xml");
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