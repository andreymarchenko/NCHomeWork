package busSchedule.client.modules;

import busSchedule.client.controller.LifeCycle;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(Module.class)
public interface Injector extends Ginjector {
    LifeCycle getLifeCycle();
}