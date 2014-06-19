package alskor.vaadin.editor;

import com.vaadin.data.Property;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.ui.TextField;

public class EditorUtil {
    public static TextField textInput(String caption, Property<?> property) {
        final TextField result = new TextField(caption);
        result.setPropertyDataSource(property);
        return result;
    }

    public static TextField propertyInput(String caption, Object o, String field) {
        return textInput(caption, new MethodProperty<String>(o, field));
    }
}
