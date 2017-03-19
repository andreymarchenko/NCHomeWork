package busSchedule.client.controller;

import busSchedule.client.view.View;

import javax.inject.Inject;

public class LifeCycle {
    private View view;
    private Controller controller;

    @Inject
    public LifeCycle(View view,
                     Controller controller) {
        this.view = view;
        this.controller = controller;
    }

    public void start() {
        view.createUI();
        view.bind();
        controller.bind();
    }
}
