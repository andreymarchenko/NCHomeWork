package busSchedule.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface DeleteRowEventHandler extends EventHandler {
    void onDeleteRow(DeleteRowEvent deleteRowEvent);
}