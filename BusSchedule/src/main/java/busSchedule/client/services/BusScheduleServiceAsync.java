package busSchedule.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BusScheduleServiceAsync {
    void parse(AsyncCallback<String> async);
    void addRow(String str, AsyncCallback<String> async);
    void deleteRow(int number, AsyncCallback<String> async);
    void pressNextPage(AsyncCallback<String> async);
    void pressPreviousPage(AsyncCallback<String> async);
}
