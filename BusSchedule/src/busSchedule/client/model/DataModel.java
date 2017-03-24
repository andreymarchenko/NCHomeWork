package busSchedule.client.model;

import busSchedule.client.controller.Controller;
import busSchedule.client.events.NextPageEvent;
import busSchedule.client.events.NextPageEventHandler;
import busSchedule.client.events.PreviousPageEvent;
import busSchedule.client.events.PreviousPageEventHandler;
import busSchedule.client.services.BusScheduleService;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TextArea;

import javax.inject.Inject;


public class DataModel {
    private Controller controller;
    private EventBus eventBus;
    static int pagesNumber = 1;
    static int currentPageNumber = 1;

    @Inject
    public DataModel(EventBus eventBus) {
        this.eventBus = eventBus;
        getPageNumber();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void loadTable() {
        BusScheduleService.App.getInstance().loadTable(new MyAsyncCallback(controller));
    }

    public void getPageNumber() {
        BusScheduleService.App.getInstance().getPageNumber(new PageNumberAsyncCallback());
    }

    public void addRow(String str) {
        BusScheduleService.App.getInstance().addRow(str, currentPageNumber, new AddDeleteAsyncCallback(controller));
        BusScheduleService.App.getInstance().getPageNumber(new PageNumberAsyncCallback());
    }

    public void deleteRow(int number) {
        BusScheduleService.App.getInstance().deleteRow(number, currentPageNumber, new AddDeleteAsyncCallback(controller));
        BusScheduleService.App.getInstance().getPageNumber(new PageNumberAsyncCallback());
    }

    public void sortByNumber() {
        BusScheduleService.App.getInstance().sortByNumber(currentPageNumber, new MyAsyncCallback(controller));
    }

    public void sortByDeparture() {
        BusScheduleService.App.getInstance().sortByDeparture(currentPageNumber, new MyAsyncCallback(controller));
    }

    public void sortByDestination() {
        BusScheduleService.App.getInstance().sortByDestination(currentPageNumber, new MyAsyncCallback(controller));
    }

    public void sortByTime() {
        BusScheduleService.App.getInstance().sortByTime(currentPageNumber, new MyAsyncCallback(controller));
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

    public void filterByNumber(String fromText, String toText) {
        BusScheduleService.App.getInstance().filterByNumber(currentPageNumber,
                fromText, toText, new MyAsyncCallback(controller));
    }

    public void filterByDeparture(String fromText, String toText) {
        BusScheduleService.App.getInstance().filterByDeparture(currentPageNumber,
                fromText, toText, new MyAsyncCallback(controller));
    }

    public void filterByDestination(String fromText, String toText) {
        BusScheduleService.App.getInstance().filterByDestination(currentPageNumber,
                fromText, toText, new MyAsyncCallback(controller));
    }

    public void filterByTime(String fromText, String toText) {
        BusScheduleService.App.getInstance().filterByTime(currentPageNumber,
                fromText, toText, new MyAsyncCallback(controller));
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

    private static class AddDeleteAsyncCallback implements AsyncCallback<String> {
        private Controller controller;

        public AddDeleteAsyncCallback(Controller controller) {
            this.controller = controller;
        }

        public void onSuccess(String result) {
            String str[] = result.split("-");
            controller.setTableModel(str[0]);
            currentPageNumber = Integer.parseInt(str[1]);
        }

        public void onFailure(Throwable throwable) {
            controller.setTableModel("-1/Error/Error/Error");
        }
    }

    private static class PageNumberAsyncCallback implements AsyncCallback<String> {

        public void onSuccess(String result) {
            DataModel.pagesNumber = Integer.parseInt(result);
        }

        public void onFailure(Throwable throwable) {
            DataModel.pagesNumber = -1;
        }
    }

}
