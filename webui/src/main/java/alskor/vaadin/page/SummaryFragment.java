package alskor.vaadin.page;

import alskor.vaadin.Buttons;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SummaryFragment extends VerticalLayout {
    public SummaryFragment(Navigator navigator, int numberOfTrips) {
        setWidth("100%");

        addComponent(new Label("Total trips: " + numberOfTrips));
        addComponent(Buttons.createNewTripButton(navigator));
    }
}
