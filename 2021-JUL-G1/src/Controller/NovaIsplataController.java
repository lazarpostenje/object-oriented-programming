package Controller;

import View.SecondView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NovaIsplataController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        SecondView.SECOND_VIEW.show();

    }
}
