package busSchedule.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("BusScheduleService")
public interface BusScheduleService extends RemoteService {

    String parse();
    String getPageNumber();
    String loadTable();
    String addRow(String row,int number);
    String deleteRow(int number);
    String pressNextPage(int number);
    String pressPreviousPage(int number);

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
