package busSchedule.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import busSchedule.client.BusScheduleService;

public class BusScheduleServiceImpl extends RemoteServiceServlet implements BusScheduleService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}