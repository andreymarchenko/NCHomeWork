package busSchedule.client.view;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class FormatForm extends DialogBox {
    private VerticalPanel mainPanel;
    private HorizontalPanel horizontalPanel;
    private HorizontalPanel buttonPanel;
    private VerticalPanel leftPanel;
    private VerticalPanel rightPanel;
    private TextArea fromText;
    private TextArea toText;
    private Label from;
    private Label to;
    private Button ok;
    private Button close;
    private Label sortBy;

    public FormatForm(int format) {
        if (format == 1) createMarkUp("Filter by number");
        else if (format == 2) createMarkUp("Filter by departure");
        else if (format == 3) createMarkUp("Filter by destination");
        else createMarkUp("Filter by time");
        setStyle();
        bind();
        super.setAnimationEnabled(true);
        super.setGlassEnabled(true);
        show();
    }

    public void createMarkUp(String text) {
        sortBy = new Label(text);
        mainPanel = new VerticalPanel();
        horizontalPanel = new HorizontalPanel();
        leftPanel = new VerticalPanel();
        rightPanel = new VerticalPanel();
        fromText = new TextArea();
        toText = new TextArea();
        from = new Label("From");
        to = new Label("To");
        ok = new Button("OK");
        close = new Button("Close");
        buttonPanel = new HorizontalPanel();
        buttonPanel.add(ok);
        buttonPanel.add(close);
        leftPanel.add(from);
        leftPanel.add(to);
        rightPanel.add(fromText);
        rightPanel.add(toText);
        horizontalPanel.add(leftPanel);
        horizontalPanel.add(rightPanel);
        mainPanel.add(sortBy);
        mainPanel.add(horizontalPanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }

    public Button getOk() {
        return ok;
    }

    public void setStyle() {
        this.getElement().getStyle().setBackgroundColor("White");
        this.getElement().getStyle().setWidth(320, Style.Unit.PX);
        this.getElement().getStyle().setHeight(250, Style.Unit.PX);
        this.setPopupPosition((Window.getClientWidth() - 320) / 2, (Window.getClientHeight() - 250) / 2);
        this.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
        this.getElement().getStyle().setBorderWidth(1, Style.Unit.PX);
        this.getElement().getStyle().setBorderColor("Gray");

        sortBy.getElement().getStyle().setMarginLeft(105, Style.Unit.PX);
        sortBy.getElement().getStyle().setMarginTop(15, Style.Unit.PX);

        leftPanel.getElement().getStyle().setMarginLeft(50, Style.Unit.PX);
        leftPanel.getElement().getStyle().setMarginTop(35, Style.Unit.PX);

        rightPanel.getElement().getStyle().setMarginLeft(30, Style.Unit.PX);
        rightPanel.getElement().getStyle().setMarginTop(35, Style.Unit.PX);

        from.getElement().getStyle().setMarginTop(7, Style.Unit.PX);
        to.getElement().getStyle().setMarginTop(30, Style.Unit.PX);

        toText.getElement().getStyle().setMarginTop(15, Style.Unit.PX);

        buttonPanel.getElement().getStyle().setMarginTop(30, Style.Unit.PX);

        ok.getElement().getStyle().setWidth(60, Style.Unit.PX);
        ok.getElement().getStyle().setHeight(30, Style.Unit.PX);
        ok.getElement().getStyle().setMarginLeft(95, Style.Unit.PX);

        close.getElement().getStyle().setWidth(60, Style.Unit.PX);
        close.getElement().getStyle().setHeight(30, Style.Unit.PX);

        close.getElement().getStyle().setMarginLeft(20, Style.Unit.PX);


    }

    public TextArea getFromText() {
        return fromText;
    }

    public TextArea getToText() {
        return toText;
    }

    public void bind() {
        close.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                hide();
            }
        });
    }


}
