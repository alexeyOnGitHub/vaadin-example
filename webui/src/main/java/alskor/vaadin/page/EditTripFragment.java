package alskor.vaadin.page;

import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import static alskor.vaadin.editor.EditorUtil.textInput;

public class EditTripFragment extends VerticalLayout {
    public static final String URI_CREATE = "create";
    public static final String URI_EDIT = "edit";

    private Button saveButton;

    public EditTripFragment(Property<String> startLocation,
                            Property<String> finishLocation,
                            Property<Float> price) {
        setWidth("100%");
        addComponent(new Label("Edit trip"));

        addComponent(textInput("From", startLocation));
        addComponent(textInput("To", finishLocation));
        addComponent(textInput("Price", price));

        saveButton = new Button("Save");
        addComponent(saveButton);
    }

    public Button getSaveButton() {
        return saveButton;
    }
}
