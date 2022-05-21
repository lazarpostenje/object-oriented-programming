package Controller;

import Controller.Utils.Utils;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SacuvajController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Utils.ispisUFajl("ispis.txt", Utils.generisiListuZaStampanje(MainView.MAIN_VIEW.getTvUcionice().getItems()));

    }
}
