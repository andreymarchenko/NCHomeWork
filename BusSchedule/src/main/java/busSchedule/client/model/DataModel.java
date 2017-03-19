package busSchedule.client.model;

import busSchedule.client.controller.Controller;
import busSchedule.client.events.*;
import busSchedule.client.services.BusScheduleService;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import javax.inject.Inject;

public class DataModel {
    private Controller controller;
    private EventBus eventBus;
    private String result = "";

    @Inject
    public DataModel(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void addRow(String str) {
        //что-то парсим, говорим контроллеру, распарсили/добавили, все збс, контроллер говорит view-обновись
        BusScheduleService.App.getInstance().addRow(new MyAsyncCallback(str, result));
    }

    public void deleteRow(int number) {
        BusScheduleService.App.getInstance().deleteRow(new MyAsyncCallback("", ""));
    }

    public void bind() {
        controller.NextPageEventHandler(new NextPageEventHandler() {
            public void onNextPage(NextPageEvent nextPageEvent) {
                BusScheduleService.App.getInstance().pressNextPage(new MyAsyncCallback("", ""));
            }
        });
        controller.PreviousPageEventHandler(new PreviousPageEventHandler() {
            public void onPreviousPage(PreviousPageEvent previousPageEvent) {
                BusScheduleService.App.getInstance().pressPreviousPage(new MyAsyncCallback("", ""));
            }
        });
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private String data;
        private String result;

        public MyAsyncCallback(String data, String result) {
            this.data = data;
            this.result = result;
        }

        public String getData() {
            return data;
        }

        public void onSuccess(String result) {
            this.result = result;
        }

        public void onFailure(Throwable throwable) {
            result = "Error";
        }
    }
}
