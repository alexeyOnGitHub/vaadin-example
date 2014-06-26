package alskor.vaadin.page;

import alskor.vaadin.Buttons;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class UIBuilder {
    public static Component createSummaryFragment(Navigator navigator, int numberOfTrips) {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("100%");
        layout.addComponent(new Label("Total trips: " + numberOfTrips));
        layout.addComponent(Buttons.createNewTripButton(navigator));
        return layout;
    }
}
