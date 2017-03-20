package busSchedule.client.view;

import busSchedule.client.controller.Controller;
import busSchedule.client.services.BusScheduleService;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import busSchedule.client.entity.*;

import javax.inject.Inject;
import java.util.ArrayList;

public class View extends Composite {

    interface ViewUiBinder extends UiBinder<Widget, View> {
    }

    private static ViewUiBinder ourUiBinder = GWT.create(ViewUiBinder.class);

    @UiField
    FlowPanel tablePanel;
    @UiField
    Button previousPage;
    @UiField
    Button nextPage;
    @UiField
    Button addRow;
    @UiField
    Button deleteRow;
    @UiField
    Label label;


    private Controller controller;
    private InputForm inputForm;

    private ArrayList<Bus> list = new ArrayList<Bus>();
    private CellTable<Bus> cellTable = new CellTable<Bus>();

    @Inject
    public View(Controller controller) {
        this.controller = controller;
        controller.setView(this);
    }

    public void createUI() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initTableStructure();
        initTableData();
        tablePanel.add(cellTable);
        setView();
        RootPanel.get("root").add(this);
    }

    public void initTableStructure() {
        NumberCell numberCell = new NumberCell();
        Column<Bus, Number> numberColumn = new Column<Bus, Number>(numberCell) {
            @Override
            public Integer getValue(Bus object) {
                return object.getNumber();
            }
        };
        cellTable.addColumn(numberColumn, "Number");

        TextColumn<Bus> startColumn = new TextColumn<Bus>() {
            @Override
            public String getValue(Bus object) {
                return object.getStart();
            }
        };
        cellTable.addColumn(startColumn, "Start");

        TextColumn<Bus> endColumn = new TextColumn<Bus>() {
            @Override
            public String getValue(Bus object) {
                return object.getEnd();
            }
        };
        cellTable.addColumn(endColumn, "End");

        TextColumn<Bus> timeColumn = new TextColumn<Bus>() {
            @Override
            public String getValue(Bus object) {
                return object.getTime();
            }
        };
        cellTable.addColumn(timeColumn, "Time");
    }

    public void initTableData() {
        controller.tableLoad();
    }

    public void bind() {
        nextPage.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                controller.pressNextPage();
            }
        });
        previousPage.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                controller.pressPreviousPage();
            }
        });
        addRow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                inputForm = new InputForm();
                inputForm.getAddButton().addClickHandler(new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        String str = inputForm.getNumberInput().getText() + "/" +
                                inputForm.getDepartureInput().getText() + "/" +
                                inputForm.getDestinationInput().getText() + "/" +
                                inputForm.getTimeInput().getText();
                        controller.addRow(str);
                    }
                });

            }
        });
        deleteRow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                controller.deleteRow(1);
            }
        });
    }

    public Button getNextPage() {
        return nextPage;
    }

    public Label getLabel() {
        return label;
    }


    public void setView() {
        nextPage.getElement().getStyle().setMarginLeft(30, Style.Unit.PX);
        previousPage.getElement().getStyle().setMarginLeft(70, Style.Unit.PX);
    }

    public void addData(String str) {
        list.clear();
        String[] data = str.split("/");

        for (int i = 0; i < data.length; i += 4) {
            list.add(new Bus(Integer.parseInt(data[i]), data[i + 1], data[i + 2], data[i + 3]));
        }

        cellTable.setRowCount(list.size(), true);
        cellTable.setRowData(0, list);
        cellTable.redraw();
    }

    public void update() {

    }

}