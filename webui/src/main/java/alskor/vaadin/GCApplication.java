package alskor.vaadin;

import alskor.vaadin.db.TripManager;
import alskor.vaadin.page.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This is the Vaadin web application entry point.
 */
@Theme("mytheme")
public class GCApplication extends UI {
    private Navigator navigator;
    private Authenticator authenticator;
    private TripManager manager = new TripManager();

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        navigator = new Navigator(this, this);
        authenticator = new Authenticator();
        // Create and register the views
        navigator.addView("", new MainView(navigator, authenticator, manager));

        SampleDataLoader.loadSampleData(manager);
    }
}
