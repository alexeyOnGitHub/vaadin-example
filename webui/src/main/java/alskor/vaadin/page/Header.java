package alskor.vaadin.page;

import alskor.vaadin.Authenticator;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class Header extends HorizontalLayout {

    private final Authenticator authenticator;

    public Header(Authenticator authenticator) {
        this.authenticator = authenticator;
        buildMainLayout();
    }

    private void buildMainLayout() {
        setSpacing(true);
        addStyleName("header_panel");

        Label label = new Label("Vaadin Sample Application Title");
        label.setSizeUndefined();
        label.addStyleName("header_logo_label");
        addComponent(label);

        addWelcomeSection();
    }

    private void addWelcomeSection() {
        String name = "guest";
        if (authenticator.isLoggedIn()) {
            name = authenticator.getUserName();
        }
        addComponent(new Label("Welcome, " + name));
    }
}