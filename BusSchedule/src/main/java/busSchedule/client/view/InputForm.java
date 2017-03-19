package busSchedule.client.view;

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
        setPopupPosition(Window.getClientWidth() / 2, Window.getClientHeight() / 2);
        bind(this);
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
        numberInfo = new Label("Enter bus number");
        departureInfo = new Label("Enter departure place");
        destinationInfo = new Label("Enter destination place");
        timeInfo = new Label("Enter time");
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
