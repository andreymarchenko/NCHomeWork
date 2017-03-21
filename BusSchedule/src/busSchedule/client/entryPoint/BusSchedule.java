package busSchedule.client.entryPoint;

import busSchedule.client.controller.LifeCycle;
import busSchedule.client.modules.Injector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class BusSchedule implements EntryPoint {

    public void onModuleLoad() {
        Injector injector = GWT.create(Injector.class);
        LifeCycle lifeCycle = injector.getLifeCycle();
        lifeCycle.start();
    }
}
