package busSchedule.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("BusScheduleService")
public interface BusScheduleService extends RemoteService {

    String parse();
    String getPageNumber();
    String loadTable();
    String addRow(String row, int number);
    String deleteRow(int number, int pageNumber);
    String pressNextPage(int number);
    String pressPreviousPage(int number);
    String sortByNumber(int number);
    String sortByDeparture(int number);
    String sortByDestination(int number);
    String sortByTime(int number);

    public static class App {
        private static BusScheduleServiceAsync ourInstance = GWT.create(BusScheduleService.class);

        public static synchronized BusScheduleServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
