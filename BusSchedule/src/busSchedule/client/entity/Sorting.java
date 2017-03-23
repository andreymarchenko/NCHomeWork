package busSchedule.client.entity;

public class Sorting {

    Bus[] buses;

    public Sorting(Bus[] buses) {
        this.buses = buses;
    }

    public void sortByNumber() {
        Bus temp;
        for (int i = 0; i < buses.length; i++) {
            for (int j = 1; j < (buses.length - i); j++) {
                if (buses[j - 1].getNumber() > buses[j].getNumber()) {
                    temp = buses[j - 1];
                    buses[j - 1] = buses[j];
                    buses[j] = temp;
                }
            }
        }
    }

    public void sortByDeparture() {
        Bus temp;
        for (int i = 0; i < buses.length; i++) {
            for (int j = 1; j < (buses.length - i); j++) {
                if (buses[j - 1].getStart().charAt(0) > buses[j].getStart().charAt(0)) {
                    temp = buses[j - 1];
                    buses[j - 1] = buses[j];
                    buses[j] = temp;
                }
            }
        }
    }

    public void sortByDestination() {
        Bus temp;
        for (int i = 0; i < buses.length; i++) {
            for (int j = 1; j < (buses.length - i); j++) {
                if (buses[j - 1].getEnd().charAt(0) > buses[j].getEnd().charAt(0)) {
                    temp = buses[j - 1];
                    buses[j - 1] = buses[j];
                    buses[j] = temp;
                }
            }
        }
    }

    public void sortByTime() {
        Bus temp;
        for (int i = 0; i < buses.length; i++) {
            for (int j = 1; j < (buses.length - i); j++) {

                String[] prevStr = buses[j - 1].getTime().split(":");
                String[] nextStr = buses[j].getTime().split(":");

                String prev = "";
                String next = "";

                prev += prevStr[0] + prevStr[1];
                next += nextStr[0] + nextStr[1];

                if (Integer.parseInt(prev) > Integer.parseInt(next)) {
                    temp = buses[j - 1];
                    buses[j - 1] = buses[j];
                    buses[j] = temp;
                }
            }
        }
    }
}
