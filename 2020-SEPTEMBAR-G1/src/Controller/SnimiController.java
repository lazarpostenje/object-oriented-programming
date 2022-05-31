package Controller;

import Controller.Utils.Utils;
import Model.Izdavac;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

public class SnimiController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        Utils.snimi("izlaz.txt");

    }
}
