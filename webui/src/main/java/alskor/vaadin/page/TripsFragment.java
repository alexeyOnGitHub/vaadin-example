package alskor.vaadin.page;

import alskor.vaadin.Buttons;
import alskor.vaadin.db.Trip;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

import java.util.Collection;

public class TripsFragment extends VerticalLayout {
    public static final String URI = "trips";

    private final Navigator navigator;
    private Table table;

    public TripsFragment(Navigator navigator, Collection<Trip> trips) {
        this.navigator = navigator;
        setWidth("100%");
        addComponent(new Label("Trips here"));
        addComponent(Buttons.createNewTripButton(navigator));

        table = new Table();
        table.addContainerProperty("Trip", Button.class, null);
        addComponent(table);

        showTable(trips);
    }

    private void showTable(Collection<Trip> trips) {
        table.removeAllItems();
        // items can't be added to the table without specifying index if there's no "ID" defined for the table.
        int i = 0;
        for (Trip trip : trips) {
            addTripToTable(trip, i++);
        }
        table.setPageLength(table.size() + 1);
    }

    private void addTripToTable(final Trip trip, int index) {
        String buttonLabel = "From " + trip.getStartLocation() + " To " + trip.getFinishLocation();
        Button button = new Button(buttonLabel);
        button.setStyleName(BaseTheme.BUTTON_LINK);
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                showEditTrainPage(trip.getId());
            }
        });
        table.addItem(new Object[]{button}, index);
    }

    private void showEditTrainPage(long tripId) {
        navigator.navigateTo("/" + EditTripFragment.URI_EDIT + "/" + tripId);
    }
}
