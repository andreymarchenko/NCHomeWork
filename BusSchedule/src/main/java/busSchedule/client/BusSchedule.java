package busSchedule.client;

import busSchedule.client.view.View;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class BusSchedule implements EntryPoint {

    public void onModuleLoad() {
        final View view = new View();
        view.createUI();

        view.getNextPage().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                    BusScheduleService.App.getInstance().parse(new MyAsyncCallback(view.getBuses()));
                    view.addData();
            }
        });
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private String[] buses;

        public MyAsyncCallback(String[] buses) {
            this.buses = buses;
        }

        public void onSuccess(String result) {
            this.buses = result.split("/");
        }

        public void onFailure(Throwable throwable) {

        }
    }
}
