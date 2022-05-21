package Controller;

import Model.Ucionica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class DodajController implements EventHandler<ActionEvent> {

    private final ListView<String> lvUcionice;
    private final TextField tfNoviTermin;
    private final TableView<Ucionica> tvUcionice;

    public DodajController(ListView<String> lvUcionice, TextField tfNoviTermin, TableView<Ucionica> tvUcionice) {
        this.lvUcionice = lvUcionice;
        this.tfNoviTermin = tfNoviTermin;
        this.tvUcionice = tvUcionice;
    }

    @Override
    public void handle(ActionEvent event) {

        ObservableList<String> ucioniceIzListView = lvUcionice.getSelectionModel().getSelectedItems();

        int termin = 0;

        try {

            termin = Integer.parseInt(tfNoviTermin.getText());

        } catch (Exception e){

            return;

        }

        for (String s : ucioniceIzListView) {

            String[] podaci = s.split(" ");

            String naziv = podaci[0];
            int kapacitet = Integer.parseInt(podaci[3]);

            Ucionica ucionica = new Ucionica(naziv, kapacitet, termin);

            tvUcionice.getItems().add(ucionica);

        }

        tvUcionice.refresh();

    }

}
