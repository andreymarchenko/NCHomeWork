package busSchedule.client.model;

import busSchedule.client.controller.Controller;
import busSchedule.client.events.*;
import com.google.gwt.event.shared.EventBus;

import javax.inject.Inject;

public class DataModel {
    private Controller controller;
    private EventBus eventBus;

    @Inject
    public DataModel(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void bind() {
        controller.addRowEventHandler(new AddRowEventHandler() {
            public void onAddRow(AddRowEvent addRowEvent) {
//что-то парсим, говорим контроллеру, распарсили/добавили, все збс, контроллер говорит view-обновись
            }
        });
        controller.deleteRowEventHandler(new DeleteRowEventHandler() {
            public void onDeleteRow(DeleteRowEvent deleteRowEvent) {

            }
        });
        controller.NextPageEventHandler(new NextPageEventHandler() {
            public void onNextPage(NextPageEvent nextPageEvent) {

            }
        });
        controller.PreviousPageEventHandler(new PreviousPageEventHandler() {
            public void onPreviousPage(PreviousPageEvent previousPageEvent) {

            }
        });
    }
}
