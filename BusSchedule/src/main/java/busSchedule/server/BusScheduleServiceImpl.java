package busSchedule.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import busSchedule.client.services.BusScheduleService;
import org.jdom2.Content;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BusScheduleServiceImpl extends RemoteServiceServlet implements BusScheduleService {

    private String path = "C:\\NCHomeWork\\BusSchedule\\src\\main\\resources\\schedule.xml";

    public String loadTable() {
        return showPage(1);
    }

    public String getPageNumber() {
        String str[] = parse().split("/");
        if (str.length % 40 == 0) {
            return Integer.toString(str.length / 40);
        } else {
            return Integer.toString((str.length / 40) + 1);
        }
    }

    public String addRow(String str, int number) {
        try {
            String bus[] = str.split("/");
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            Element newBus = doc.createElement("bus");
            newBus.setAttribute("number", String.valueOf(bus[0]));

            Element departure = doc.createElement("departure");
            departure.setTextContent(bus[1]);
            Element destination = doc.createElement("destination");
            destination.setTextContent(bus[2]);
            Element travelTime = doc.createElement("time");
            travelTime.setTextContent(bus[3]);

            newBus.appendChild(departure);
            newBus.appendChild(destination);
            newBus.appendChild(travelTime);

            Element root = doc.getDocumentElement();
            root.appendChild(newBus);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(inputFile);
            transformer.transform(source, result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return showPage(number);
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