package busSchedule.server;

import busSchedule.client.entity.Bus;
import busSchedule.client.entity.Sorting;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import busSchedule.client.services.BusScheduleService;
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
import java.io.IOException;
import java.util.ArrayList;

public class BusScheduleServiceImpl extends RemoteServiceServlet implements BusScheduleService {

    ClassLoader classLoader = getClass().getClassLoader();

    private String path = classLoader.getResource("schedule.xml").getFile();

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
        String bus[] = str.split("/");
        String string = parse();
        String data[] = string.split("/");

        try {
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

        if ((data.length % 40 == 0)) {
            return showPage(number + 1) + "-" + (number + 1);
        } else {
            return showPage(number) + "-" + number;
        }
    }

    public String deleteRow(int number, int pageNumber) {

        String str = parse();
        String[] data = str.split("/");

        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            Node busToDelete = null;
            NodeList buses = doc.getElementsByTagName("bus");

            for (int count = 0; count < buses.getLength(); count++) {

                Node currBus = buses.item(count);
                String busNumber = currBus.getAttributes().getNamedItem("number").getNodeValue();

                if (busNumber.equals(Integer.toString(number))) {
                    busToDelete = currBus;
                }
            }

            doc.getFirstChild().removeChild(busToDelete);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult resultFile = new StreamResult(inputFile);
            transformer.transform(source, resultFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if ((data.length - 4) % 40 == 0 && (data.length - 4) != 0) {
            return showPage(pageNumber - 1) + "-" + (pageNumber - 1);
        } else {
            return showPage(pageNumber) + "-" + pageNumber;
        }
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

    public String showPage(int number, String str) {
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

    public String busesToString(Bus[] buses) {
        String result = "";
        for (int i = 0; i < buses.length; i++) {
            if (i == buses.length - 1) {
                result += buses[i].getNumber() + "/" + buses[i].getStart() + "/" + buses[i].getEnd() + "/" + buses[i].getTime();
            } else {
                result += buses[i].getNumber() + "/" + buses[i].getStart() + "/" + buses[i].getEnd() + "/" + buses[i].getTime() + "/";
            }
        }
        return result;
    }

    public String busListToString(ArrayList<Bus> buses) {
        String result = "";
        for (int i = 0; i < buses.size(); i++) {
            if (i == buses.size() - 1) {
                result += buses.get(i).getNumber() + "/" + buses.get(i).getStart() + "/" + buses.get(i).getEnd() + "/" + buses.get(i).getTime();
            } else {
                result += buses.get(i).getNumber() + "/" + buses.get(i).getStart() + "/" + buses.get(i).getEnd() + "/" + buses.get(i).getTime() + "/";
            }
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

    public String sortByNumber(int number) {
        String str = showPage(number);
        String[] data = str.split("/");

        Bus[] buses = new Bus[data.length / 4];

        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        Sorting sorting = new Sorting(buses);

        sorting.sortByNumber();

        String result = busesToString(buses);
        return result;
    }

    public String sortByDeparture(int number) {
        String str = showPage(number);
        String[] data = str.split("/");
        Bus[] buses = new Bus[data.length / 4];

        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        Sorting sorting = new Sorting(buses);

        sorting.sortByDeparture();

        String result = busesToString(buses);
        return result;
    }

    public String sortByDestination(int number) {
        String str = showPage(number);
        String[] data = str.split("/");
        Bus[] buses = new Bus[data.length / 4];

        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        Sorting sorting = new Sorting(buses);

        sorting.sortByDestination();

        String result = busesToString(buses);
        return result;
    }

    public String sortByTime(int number) {
        String str = showPage(number);
        String[] data = str.split("/");
        Bus[] buses = new Bus[data.length / 4];

        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        Sorting sorting = new Sorting(buses);

        sorting.sortByTime();

        String result = busesToString(buses);
        return result;
    }

    public String filterByNumber(int number, String from, String to) {
        String str = showPage(number);
        String[] data = str.split("/");

        Bus[] buses = new Bus[data.length / 4];
        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        ArrayList<Bus> filteredBuses = new ArrayList<>();
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getNumber() >= Integer.parseInt(from) &&
                    buses[i].getNumber() <= Integer.parseInt(to)) {
                filteredBuses.add(buses[i]);
            }
        }

        if (filteredBuses.size() != 0) {
            return busListToString(filteredBuses);
        } else {
            String s = "0/Not Found/Not Found/Not Found";
            return s;
        }
    }

    public String filterByDeparture(int number, String from, String to) {
        String str = showPage(number);
        String[] data = str.split("/");

        Bus[] buses = new Bus[data.length / 4];
        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        ArrayList<Bus> filteredBuses = new ArrayList<>();
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getStart().charAt(0) >= from.charAt(0) &&
                    buses[i].getStart().charAt(0) <= to.charAt(0)) {
                filteredBuses.add(buses[i]);
            }
        }

        if (filteredBuses.size() != 0) {
            return busListToString(filteredBuses);
        } else {
            String s = "0/Not Found/Not Found/Not Found";
            return s;
        }
    }

    public String filterByDestination(int number, String from, String to) {
        String str = showPage(number);
        String[] data = str.split("/");

        Bus[] buses = new Bus[data.length / 4];
        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        ArrayList<Bus> filteredBuses = new ArrayList<>();
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getEnd().charAt(0) >= from.charAt(0) &&
                    buses[i].getEnd().charAt(0) <= to.charAt(0)) {
                filteredBuses.add(buses[i]);
            }
        }

        if (filteredBuses.size() != 0) {
            return busListToString(filteredBuses);
        } else {
            String s = "0/Not Found/Not Found/Not Found";
            return s;
        }
    }

    public String filterByTime(int number, String from, String to) {
        String str = showPage(number);
        String[] data = str.split("/");

        Bus[] buses = new Bus[data.length / 4];
        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        ArrayList<Bus> filteredBuses = new ArrayList<>();
        for (int i = 0; i < buses.length; i++) {

            String[] numArray = buses[i].getTime().split(":");
            String time = "";
            time += numArray[0] + numArray[1];

            String[] fromArray = from.split(":");
            String fromTime = "";
            fromTime += fromArray[0] + fromArray[1];

            String[] toArray = to.split(":");
            String toTime = "";
            toTime += toArray[0] + toArray[1];

            if (Integer.parseInt(time) >= Integer.parseInt(fromTime) &&
                    Integer.parseInt(time) <= Integer.parseInt(toTime)) {
                filteredBuses.add(buses[i]);
            }
        }

        if (filteredBuses.size() != 0) {
            return busListToString(filteredBuses);
        } else {
            String s = "0/Not Found/Not Found/Not Found";
            return s;
        }
    }
}