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
}