package busSchedule.client.view;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class InputForm extends DialogBox {

    private VerticalPanel mainPanel;
    private HorizontalPanel horizontalPanel;
    private VerticalPanel leftPanel;
    private VerticalPanel rightPanel;
    private HorizontalPanel buttonPanel;
    private TextArea numberInput;
    private TextArea departureInput;
    private TextArea destinationInput;
    private TextArea timeInput;
    private Label numberInfo;
    private Label departureInfo;
    private Label destinationInfo;
    private Label timeInfo;
    private Button addButton;
    private Button closeButton;

    public InputForm() {
        createMarkup();
        bind(this);
        super.setAnimationEnabled(true);
        super.setGlassEnabled(true);
        show();
    }

    public void createMarkup() {
        mainPanel = new VerticalPanel();
        horizontalPanel = new HorizontalPanel();
        buttonPanel = new HorizontalPanel();
        leftPanel = new VerticalPanel();
        rightPanel = new VerticalPanel();
        numberInput = new TextArea();
        departureInput = new TextArea();
        destinationInput = new TextArea();
        timeInput = new TextArea();
        numberInfo = new Label("Bus number");
        departureInfo = new Label("Departure place");
        destinationInfo = new Label("Destination place");
        timeInfo = new Label("Travel time");
        addButton = new Button("Add");
        closeButton = new Button("Close");
        buttonPanel.add(addButton);
        buttonPanel.add(closeButton);
        leftPanel.add(numberInfo);
        leftPanel.add(departureInfo);
        leftPanel.add(destinationInfo);
        leftPanel.add(timeInfo);
        rightPanel.add(numberInput);
        rightPanel.add(departureInput);
        rightPanel.add(destinationInput);
        rightPanel.add(timeInput);
        horizontalPanel.add(leftPanel);
        horizontalPanel.add(rightPanel);
        mainPanel.add(horizontalPanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
        setStyle();

    }

    public void bind(final InputForm inputForm) {
        numberInput.addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent event) {
                if (!isDigit(numberInput.getText())) {
                    numberInput.setText("");
                }
            }
        });
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                inputForm.hide();
            }
        });
    }

    public void setStyle() {
        this.setPopupPosition((Window.getClientWidth() - 420) / 2, (Window.getClientHeight() - 420) / 2);
        this.getElement().getStyle().setWidth(420, Style.Unit.PX);
        this.getElement().getStyle().setHeight(320, Style.Unit.PX);
        this.getElement().getStyle().setBackgroundColor("White");
        this.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
        this.getElement().getStyle().setBorderWidth(1, Style.Unit.PX);
        this.getElement().getStyle().setBorderColor("Gray");

        rightPanel.getElement().getStyle().setPaddingLeft(50, Style.Unit.PX);

        numberInput.getElement().getStyle().setMarginTop(20, Style.Unit.PX);
        departureInput.getElement().getStyle().setMarginTop(30, Style.Unit.PX);
        destinationInput.getElement().getStyle().setMarginTop(30, Style.Unit.PX);
        timeInput.getElement().getStyle().setMarginTop(30, Style.Unit.PX);

        numberInfo.getElement().getStyle().setMarginTop(25, Style.Unit.PX);
        numberInfo.getElement().getStyle().setPaddingLeft(45, Style.Unit.PX);

        departureInfo.getElement().getStyle().setMarginTop(47, Style.Unit.PX);
        departureInfo.getElement().getStyle().setPaddingLeft(45, Style.Unit.PX);

        destinationInfo.getElement().getStyle().setMarginTop(47, Style.Unit.PX);
        destinationInfo.getElement().getStyle().setPaddingLeft(45, Style.Unit.PX);

        timeInfo.getElement().getStyle().setMarginTop(47, Style.Unit.PX);
        timeInfo.getElement().getStyle().setPaddingLeft(45, Style.Unit.PX);

        buttonPanel.getElement().getStyle().setMarginTop(25, Style.Unit.PX);
        buttonPanel.getElement().getStyle().setPaddingLeft(140, Style.Unit.PX);

        addButton.getElement().getStyle().setWidth(60, Style.Unit.PX);
        addButton.getElement().getStyle().setHeight(30, Style.Unit.PX);

        closeButton.getElement().getStyle().setWidth(60, Style.Unit.PX);
        closeButton.getElement().getStyle().setHeight(30, Style.Unit.PX);

        closeButton.getElement().getStyle().setMarginLeft(20, Style.Unit.PX);
    }

    public Button getAddButton() {
        return addButton;
    }

    public TextArea getTimeInput() {
        return timeInput;
    }

    public TextArea getNumberInput() {
        return numberInput;
    }

    public TextArea getDepartureInput() {
        return departureInput;
    }

    public TextArea getDestinationInput() {
        return destinationInput;
    }

    public boolean isDigit(String s) {
        try {
            int num = Integer.parseInt(s);
            if (num > 0) return true;
            else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
