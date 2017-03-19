package busSchedule.client.controller;

import busSchedule.client.events.*;
import busSchedule.client.model.DataModel;
import busSchedule.client.view.View;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;

import javax.inject.Inject;

public class Controller {
    private View view;
    private DataModel dataModel;
    private EventBus eventBus;

    @Inject
    public Controller(DataModel dataModel,
                      EventBus eventBus) {
        this.dataModel = dataModel;
        this.eventBus = eventBus;
        dataModel.setController(this);
    }

    public void setView(View view) {
        this.view = view;
    }

    public HandlerRegistration addRowEventHandler(final AddRowEventHandler handler) {
        return eventBus.addHandler(AddRowEvent.TYPE, handler);
    }

    public HandlerRegistration deleteRowEventHandler(final DeleteRowEventHandler handler) {
        return eventBus.addHandler(DeleteRowEvent.TYPE, handler);
    }

    public HandlerRegistration NextPageEventHandler(final NextPageEventHandler handler) {
        return eventBus.addHandler(NextPageEvent.TYPE, handler);
    }

    public HandlerRegistration PreviousPageEventHandler(final PreviousPageEventHandler handler) {
        return eventBus.addHandler(PreviousPageEvent.TYPE, handler);
    }

    public void addRow() {
        eventBus.fireEvent(AddRowEvent.create());
    }

    public void deleteRow() {
        eventBus.fireEvent(DeleteRowEvent.create());
    }

    public void pressNextPage() {
        eventBus.fireEvent(NextPageEvent.create());
    }

    public void pressPreviousPage() {
        eventBus.fireEvent(PreviousPageEvent.create());
    }

    public void bind() {
        dataModel.bind();
    }
}
