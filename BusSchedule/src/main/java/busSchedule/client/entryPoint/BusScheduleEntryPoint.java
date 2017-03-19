package busSchedule.client.entryPoint;

import busSchedule.client.modules.Injector;
import busSchedule.client.services.BusScheduleService;
import busSchedule.client.controller.LifeCycle;
import busSchedule.client.view.View;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class BusScheduleEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        Injector injector = GWT.create(Injector.class);
        LifeCycle lifeCycle = injector.getLifeCycle();
        lifeCycle.start();
    }
}
