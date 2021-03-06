package busSchedule.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BusScheduleServiceAsync {
    void parse(AsyncCallback<String> async);

    void getPageNumber(AsyncCallback<String> async);

    void loadTable(AsyncCallback<String> async);

    void addRow(String str, int number, AsyncCallback<String> async);

    void deleteRow(int number, int pageNumber, AsyncCallback<String> async);

    void pressNextPage(int number, AsyncCallback<String> async);

    void pressPreviousPage(int number, AsyncCallback<String> async);

    void sortByNumber(int number, AsyncCallback<String> async);

    void sortByDeparture(int number, AsyncCallback<String> async);

    void sortByDestination(int number, AsyncCallback<String> async);

    void sortByTime(int number, AsyncCallback<String> async);

    void filterByNumber(int number, String from, String to, AsyncCallback<String> async);

    void filterByDeparture(int number, String from, String to, AsyncCallback<String> async);

    void filterByDestination(int number, String from, String to, AsyncCallback<String> async);

    void filterByTime(int number, String from, String to, AsyncCallback<String> async);
}
