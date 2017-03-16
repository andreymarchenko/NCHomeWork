package busSchedule.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("BusScheduleService")
public interface BusScheduleService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use BusScheduleService.App.getInstance() to access static instance of BusScheduleServiceAsync
     */
    public static class App {
        private static BusScheduleServiceAsync ourInstance = GWT.create(BusScheduleService.class);

        public static synchronized BusScheduleServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
