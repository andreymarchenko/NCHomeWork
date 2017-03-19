package busSchedule.client.events;


import com.google.gwt.event.shared.EventHandler;

public interface NextPageEventHandler extends EventHandler {
    void onNextPage(NextPageEvent nextPageEvent);
}