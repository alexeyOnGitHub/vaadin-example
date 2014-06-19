package alskor.vaadin;

import alskor.vaadin.page.EditTripFragment;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;

public class Buttons {

    public static Button createNewTripButton(final Navigator navigator) {
        Button button = new Button("Create a trip");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navigator.navigateTo("/" + EditTripFragment.URI_CREATE);
            }
        });
        return button;
    }
}
