package busSchedule.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class View extends Composite {

    interface ViewUiBinder extends UiBinder<Widget, View> {
    }

    private static ViewUiBinder ourUiBinder = GWT.create(ViewUiBinder.class);

    @UiField
    FlexTable flexTable;

    public void createUI() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initUI();
        initTable();
        RootPanel.get("root").add(this);
    }

    public void initTable() {
        FlexTable.FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
        flexTable.setCellSpacing(5);
        flexTable.setCellPadding(3);
        addRow(flexTable);
    }

    private void addRow(FlexTable flexTable) {
        int numRows = flexTable.getRowCount();
        flexTable.getFlexCellFormatter().setRowSpan(0, 0, numRows + 1);
    }

    public void initUI() {
        flexTable.getElement().getStyle().setBorderColor("Gray");
        flexTable.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
        flexTable.getElement().getStyle().setWidth(700, Style.Unit.PX);
        flexTable.getElement().getStyle().setHeight(500, Style.Unit.PX);
        flexTable.getElement().getStyle().setPaddingLeft(150, Style.Unit.PX);
        flexTable.getElement().getStyle().setPaddingTop(150, Style.Unit.PX);
    }

}