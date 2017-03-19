package busSchedule.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BusScheduleServiceAsync {
    void parse(AsyncCallback<String> async);
    void addRow(AsyncCallback<String> async);
    void deleteRow(AsyncCallback<String> async);
    void pressNextPage(AsyncCallback<String> async);
    void pressPreviousPage(AsyncCallback<String> async);
}
