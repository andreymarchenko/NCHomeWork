package busSchedule.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BusScheduleServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
