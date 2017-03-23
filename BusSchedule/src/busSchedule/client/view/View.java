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
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;

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
    VerticalPanel sortingPanel;
    @UiField
    Button sortByNumber;
    @UiField
    Button sortByDeparture;
    @UiField
    Button sortByDestination;
    @UiField
    Button sortByTime;
    @UiField
    Label label;

    private Controller controller;
    private InputForm inputForm;
    private Sorting sorting;

    private ArrayList<Bus> list = new ArrayList<Bus>();
    private CellTable<Bus> cellTable = new CellTable<Bus>();

    private int sortBy = 0;

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
        cellTable.addColumn(startColumn, "Departure");

        TextColumn<Bus> endColumn = new TextColumn<Bus>() {
            @Override
            public String getValue(Bus object) {
                return object.getEnd();
            }
        };
        cellTable.addColumn(endColumn, "Destination");

        TextColumn<Bus> timeColumn = new TextColumn<Bus>() {
            @Override
            public String getValue(Bus object) {
                return object.getTime();
            }
        };
        cellTable.addColumn(timeColumn, "Travel time");

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
                        if (inputForm.getNumberInput().getText().trim().length() != 0 &&
                                inputForm.getDepartureInput().getText().trim().length() != 0 &&
                                inputForm.getDestinationInput().getText().trim().length() != 0 &&
                                inputForm.getTimeInput().getText().trim().length() != 0) {
                            String str = inputForm.getNumberInput().getText() + "/" +
                                    inputForm.getDepartureInput().getText() + "/" +
                                    inputForm.getDestinationInput().getText() + "/" +
                                    inputForm.getTimeInput().getText();
                            controller.addRow(str);
                        } else {
                            Window.alert("Please fill in all fields");
                        }
                    }
                });

            }
        });

        final SingleSelectionModel<Bus> selectionModel = new SingleSelectionModel<Bus>();
        cellTable.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(SelectionChangeEvent event) {
                        Bus selected = selectionModel.getSelectedObject();
                        if (selected != null) {
                            selectionModel.setSelected(selected, true);
                        }
                    }
                });

        deleteRow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                controller.deleteRow(selectionModel.getSelectedObject().getNumber());
            }
        });

        sortByNumber.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sortBy = 1;
            }
        });

        sortByDeparture.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sortBy = 2;
            }
        });

        sortByDestination.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sortBy = 3;
            }
        });

        sortByTime.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sortBy = 4;
            }
        });

    }

    public Button getNextPage() {
        return nextPage;
    }

    public void setView() {

        nextPage.getElement().getStyle().setWidth(Window.getClientWidth() / 21, Style.Unit.PX);
        nextPage.getElement().getStyle().setHeight(Window.getClientWidth() / 25, Style.Unit.PX);
        nextPage.getElement().getStyle().setMarginLeft(0.1 * Window.getClientWidth(), Style.Unit.PX);
        nextPage.getElement().getStyle().setMarginTop(0.02 * Window.getClientWidth(), Style.Unit.PX);

        previousPage.getElement().getStyle().setWidth(Window.getClientWidth() / 21, Style.Unit.PX);
        previousPage.getElement().getStyle().setHeight(Window.getClientWidth() / 25, Style.Unit.PX);
        previousPage.getElement().getStyle().setMarginLeft(0.39 * Window.getClientWidth(), Style.Unit.PX);
        previousPage.getElement().getStyle().setMarginTop(0.02 * Window.getClientWidth(), Style.Unit.PX);

        addRow.getElement().getStyle().setMarginTop(0.31 * Window.getClientHeight(), Style.Unit.PX);
        addRow.getElement().getStyle().setMarginLeft(0.06 * Window.getClientWidth(), Style.Unit.PX);
        addRow.getElement().getStyle().setWidth(Window.getClientWidth() / 21, Style.Unit.PX);
        addRow.getElement().getStyle().setHeight(Window.getClientWidth() / 25, Style.Unit.PX);

        deleteRow.getElement().getStyle().setMarginTop(0.1 * Window.getClientHeight(), Style.Unit.PX);
        deleteRow.getElement().getStyle().setMarginLeft(0.06 * Window.getClientWidth(), Style.Unit.PX);
        deleteRow.getElement().getStyle().setWidth(Window.getClientWidth() / 21, Style.Unit.PX);
        deleteRow.getElement().getStyle().setHeight(Window.getClientWidth() / 25, Style.Unit.PX);

        cellTable.getElement().getStyle().setWidth(Window.getClientWidth() / 1.5, Style.Unit.PX);
        cellTable.getElement().getStyle().setHeight(Window.getClientHeight() / 1.5, Style.Unit.PX);
        cellTable.getElement().getStyle().setMarginLeft(Window.getClientWidth() / 7, Style.Unit.PX);
        cellTable.getElement().getStyle().setMarginTop(Window.getClientHeight() / 12, Style.Unit.PX);

    }

    public void addData(String str) {
        list.clear();
        String[] data = str.split("/");
        Bus[] buses = new Bus[data.length / 4];

        int j = 0;
        for (int i = 0; i < buses.length; i++) {
            buses[i] = new Bus(Integer.parseInt(data[j]), data[j + 1], data[j + 2], data[j + 3]);
            j += 4;
        }

        Sorting sorting = new Sorting(buses);

        if (sortBy == 1) {

            sorting.sortByNumber();

            for (int i = 0; i < buses.length; i++) {

                list.add(buses[i]);
            }
        } else if (sortBy == 2) {

            sorting.sortByDeparture();

            for (int i = 0; i < buses.length; i++) {

                list.add(buses[i]);
            }
        } else if (sortBy == 3) {

            sorting.sortByDestination();

            for (int i = 0; i < buses.length; i++) {

                list.add(buses[i]);
            }

        } else if (sortBy == 4) {

            sorting.sortByTime();

            for (int i = 0; i < buses.length; i++) {

                list.add(buses[i]);
            }

        } else {

            for (int i = 0; i < data.length; i += 4) {

                list.add(new Bus(Integer.parseInt(data[i]), data[i + 1], data[i + 2], data[i + 3]));
            }
        }

        cellTable.setRowCount(list.size(), true);
        cellTable.setRowData(0, list);
        cellTable.redraw();
    }

}