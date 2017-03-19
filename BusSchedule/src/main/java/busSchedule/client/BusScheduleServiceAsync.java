package busSchedule.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BusScheduleServiceAsync {
    void parse(AsyncCallback<String> async);
}
