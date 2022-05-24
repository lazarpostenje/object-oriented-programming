package View.VBox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class NoPaddingVBox extends VBox {

    public NoPaddingVBox(Pos position, Node... children) {
        super(children);
        super.setAlignment(position);
        super.setSpacing(5);
        super.setPadding(new Insets(5));
    }
}
