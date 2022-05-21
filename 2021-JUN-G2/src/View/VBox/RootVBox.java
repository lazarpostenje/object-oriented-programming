package View.VBox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class RootVBox extends VBox {

    public RootVBox(Pos position, Node... children) {
        super(children);
        super.setAlignment(position);
        super.setSpacing(0);
        super.setPadding(new Insets(0));
    }
}
