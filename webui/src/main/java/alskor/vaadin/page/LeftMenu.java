package alskor.vaadin.page;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

public class LeftMenu extends VerticalLayout {
    private static final Resource ICON_HOME = new ThemeResource("img/home.png");
    private static final Resource ICON_TRIPS = new ThemeResource("img/list.gif");
    private final Navigator navigator;

    public LeftMenu(Navigator navigator) {
        this.navigator = navigator;
        buildUI();
    }

    private void buildUI() {
        setSpacing(true);
        addMenu(ICON_HOME, "Home", "");
        addMenu(ICON_TRIPS, "Trips", TripsFragment.URI);
    }

    private void addMenu(Resource icon, String caption, final String pageId) {
        addComponent(createButtonLink(caption, pageId, icon));
    }

    private Button createButtonLink(String caption, final String pageId, Resource icon) {
        Button button = new Button(caption);
        button.setStyleName(BaseTheme.BUTTON_LINK);
        button.setIcon(icon);
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navigator.navigateTo("/" + pageId);
            }
        });

        return button;
    }
}
