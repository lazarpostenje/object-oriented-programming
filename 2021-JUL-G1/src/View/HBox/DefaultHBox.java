package View.HBox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class DefaultHBox extends HBox {

    public DefaultHBox(Pos position, Node... children) {
        super(children);
        super.setAlignment(position);
        super.setSpacing(10);
        super.setPadding(new Insets(10));
    }
}
