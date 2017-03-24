package busSchedule.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
        if (format == 1) createMarkUp("Sort by number");
        else if (format == 2) createMarkUp("Sort by departure");
        else if (format == 3) createMarkUp("Sort by destination");
        else createMarkUp("Sort by time");
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
