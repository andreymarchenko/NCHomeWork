package busSchedule.client.entity;

public class Bus {
    private int number;
    private String start;
    private String end;
    private String time;

    public Bus(int number, String start, String end, String time) {
        this.number = number;
        this.start = start;
        this.end = end;
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
