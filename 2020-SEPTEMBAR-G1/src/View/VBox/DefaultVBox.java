package View.VBox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class DefaultVBox extends VBox {

    public DefaultVBox(Pos position, Node... children) {
        super(children);
        super.setAlignment(position);
        super.setSpacing(10);
        super.setPadding(new Insets(10));
    }
}
