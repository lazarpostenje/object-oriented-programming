package View.HBox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class NoPaddingHBox extends HBox {

    public NoPaddingHBox(Pos position, Node... children) {
        super(children);
        super.setAlignment(position);
        super.setSpacing(0);
        super.setPadding(new Insets(0));
    }
}
