package busSchedule.client.view;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import busSchedule.client.entity.*;

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
    Label label;

    private String[] buses = {"5", "", "", ""};

    private ArrayList<Bus> list = new ArrayList<Bus>();
    private CellTable<Bus> cellTable = new CellTable<Bus>();

    public void createUI() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initTable();
        addData();
        tablePanel.add(cellTable);
        setView();
        RootPanel.get("root").add(this);
    }

    public void initTable() {
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

    public Button getNextPage() {
        return nextPage;
    }

    public String[] getBuses() {
        return buses;
    }

    public void setView() {
        nextPage.getElement().getStyle().setMarginLeft(30, Style.Unit.PX);
        previousPage.getElement().getStyle().setMarginLeft(70, Style.Unit.PX);
    }

    public void addData() {

        list.add(new Bus(Integer.parseInt(buses[0]), buses[1], buses[2], buses[3]));
        //list.add(new Bus(2, "C", "B", "21.00"));
        //list.add(new Bus(3, "W", "T", "21.00"));
        cellTable.setRowCount(list.size(), true);
        cellTable.setRowData(0, list);
    }

}