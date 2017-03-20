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
    private int pagesNumber = 2;
    private int currentPageNumber = 1;

    @Inject
    public DataModel(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void loadTable() {
        BusScheduleService.App.getInstance().loadTable(new MyAsyncCallback(controller));
    }

    public void addRow(String str) {
        //что-то парсим, говорим контроллеру, распарсили/добавили, все збс, контроллер говорит view-обновись
        BusScheduleService.App.getInstance().addRow(str, new MyAsyncCallback(controller));
    }

    public void deleteRow(int number) {
        BusScheduleService.App.getInstance().deleteRow(number, new MyAsyncCallback(controller));
    }

    public void bind() {
        controller.NextPageEventHandler(new NextPageEventHandler() {
            public void onNextPage(NextPageEvent nextPageEvent) {
                if (currentPageNumber >= 1 && currentPageNumber < pagesNumber) {
                    currentPageNumber++;
                    BusScheduleService.App.getInstance().pressNextPage(currentPageNumber, new MyAsyncCallback(controller));
                }

            }
        });
        controller.PreviousPageEventHandler(new PreviousPageEventHandler() {
            public void onPreviousPage(PreviousPageEvent previousPageEvent) {
                if (currentPageNumber > 1 && currentPageNumber <= pagesNumber) {
                    currentPageNumber--;
                    BusScheduleService.App.getInstance().pressPreviousPage(currentPageNumber, new MyAsyncCallback(controller));
                }

            }
        });
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Controller controller;

        public MyAsyncCallback(Controller controller) {
            this.controller = controller;
        }

        public void onSuccess(String result) {
            controller.setTableModel(result);
        }

        public void onFailure(Throwable throwable) {
            controller.setTableModel("-1/Error/Error/Error");
        }
    }
}
