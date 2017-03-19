package busSchedule.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class AddRowEvent extends GwtEvent<AddRowEventHandler> {
    public static Type<AddRowEventHandler> TYPE = new Type<AddRowEventHandler>();


    public Type<AddRowEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(AddRowEventHandler handler) {
        handler.onAddRow(this);
    }

    public static AddRowEvent create() {
        return new AddRowEvent();
    }
}
