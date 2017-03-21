package busSchedule.client.modules;

import busSchedule.client.controller.Controller;
import busSchedule.client.controller.LifeCycle;
import busSchedule.client.model.DataModel;
import busSchedule.client.view.View;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class Module extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(Controller.class).asEagerSingleton();
        bind(DataModel.class).in(Singleton.class);
        bind(View.class).in(Singleton.class);
        bind(LifeCycle.class).in(Singleton.class);
    }
}
