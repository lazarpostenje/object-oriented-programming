package Controller;

import Controller.Server.Server;
import Model.Ucionica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class TerminController implements EventHandler<ActionEvent> {

    private final ListView lvUcionice;
    private final ComboBox cbTermini;

    public TerminController(ListView lvUcionice, ComboBox cbTermini) {
        this.lvUcionice = lvUcionice;
        this.cbTermini = cbTermini;
    }

    @Override
    public void handle(ActionEvent event) {

        ObservableList<Ucionica> ucioniceZaTermin = FXCollections.observableArrayList(Server.SERVER.getTermini().get(cbTermini.getValue()));
        lvUcionice.setItems(ucioniceZaTermin);
        lvUcionice.refresh();

    }
}
