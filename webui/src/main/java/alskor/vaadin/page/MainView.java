package alskor.vaadin.page;

import alskor.vaadin.Authenticator;
import alskor.vaadin.db.TrainManager;
import alskor.vaadin.db.Trip;
import com.google.common.base.Strings;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {
    private final Navigator navigator;
    private final TrainManager trainManager;
    private HorizontalLayout currentComponentArea = new HorizontalLayout();

    public MainView(Navigator navigator,
                    Authenticator authenticator,
                    TrainManager trainManager) {
        this.navigator = navigator;
        this.trainManager = trainManager;
        Header header = new Header(authenticator);
        header.setHeight("50px");
        header.setWidth(100, Sizeable.Unit.PERCENTAGE);
        addComponent(header);

        LeftMenu leftMenu = new LeftMenu(navigator);
        leftMenu.setWidth("120px");
        HorizontalLayout mainArea = new HorizontalLayout();
        mainArea.addComponent(leftMenu);

        currentComponentArea.setSizeFull();

        mainArea.addComponent(currentComponentArea);
        mainArea.setExpandRatio(currentComponentArea, 1.0f);
        mainArea.setSizeFull();
        addComponent(mainArea);
        setComponentAlignment(mainArea, Alignment.TOP_LEFT);
        setExpandRatio(mainArea, 1.0f);      // use all available space
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        currentComponentArea.removeAllComponents();

        String parameters = event.getParameters();

        if (Strings.isNullOrEmpty(parameters)) {
            currentComponentArea.addComponent(new SummaryFragment(navigator, trainManager.getAll().size()));
        } else if (parameters.equals(EditTripFragment.URI_CREATE)) {
            Trip trip = new Trip();
            currentComponentArea.addComponent(createEditTripFragment(trip));
        } else if (parameters.startsWith(EditTripFragment.URI_EDIT)) {
            long tripId = parseIdFromURI(parameters);
            final Trip trip = trainManager.get(tripId);
            currentComponentArea.addComponent(createEditTripFragment(trip));
        } else if (TripsFragment.URI.equals(parameters)) {
            currentComponentArea.addComponent(new TripsFragment(navigator, trainManager.getAll()));
        }
    }

    private static long parseIdFromURI(String parameters) {
        int i = parameters.lastIndexOf('/');
        String idString = parameters.substring(i + 1);
        return Long.parseLong(idString);
    }

    private Layout createEditTripFragment(final Trip trip) {
        final EditTripFragment fragment = new EditTripFragment(
                new MethodProperty<String>(trip, "startLocation"),
                new MethodProperty<String>(trip, "finishLocation"),
                new MethodProperty<Float>(trip, "price"));
        fragment.getSaveButton().addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                saveClicked();
            }

            private void saveClicked() {
                trainManager.save(trip);
                Notification.show("Saved", Notification.Type.HUMANIZED_MESSAGE);
                navigator.navigateTo("/" + TripsFragment.URI);
            }
        });
        return fragment;
    }
}
