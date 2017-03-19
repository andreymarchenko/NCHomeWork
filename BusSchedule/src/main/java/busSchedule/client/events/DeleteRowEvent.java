package busSchedule.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class DeleteRowEvent extends GwtEvent<DeleteRowEventHandler> {
    public static Type<DeleteRowEventHandler> TYPE = new Type<DeleteRowEventHandler>();


    public Type<DeleteRowEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(DeleteRowEventHandler handler) {
        handler.onDeleteRow(this);
    }

    public static DeleteRowEvent create() {
        return new DeleteRowEvent();
    }
}