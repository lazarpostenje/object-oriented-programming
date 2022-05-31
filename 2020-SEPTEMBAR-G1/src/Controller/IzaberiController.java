package Controller;

import Model.Izdavac;
import Model.Udzbenik;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class IzaberiController implements EventHandler<ActionEvent> {

    private final TableView<Izdavac> tvIzdavaci;
    private final TableView<Udzbenik> tvUdzbenici;
    private final ComboBox<String> cbRazred;

    public IzaberiController(TableView<Izdavac> tvIzdavaci, TableView<Udzbenik> tvUdzbenici, ComboBox<String> cbRazred) {
        this.tvIzdavaci = tvIzdavaci;
        this.tvUdzbenici = tvUdzbenici;
        this.cbRazred = cbRazred;
    }

    @Override
    public void handle(ActionEvent event) {

        ArrayList<Udzbenik> output = new ArrayList<>();

        Izdavac izdavac = tvIzdavaci.getSelectionModel().getSelectedItem();

        if(izdavac == null) return;

        int razred;

        if(cbRazred.getValue().equals("Svi razredi")) razred = 0;
        else razred = cbRazred.getValue().charAt(0) - '0';

        if(razred == 0){

            for (Udzbenik udzbenik : izdavac.getUdzbenici()) {

                output.add(udzbenik);

            }

        } else {

            for (Udzbenik udzbenik : izdavac.getUdzbenici()) {

                if(udzbenik.getRazred() == razred) output.add(udzbenik);

            }

        }

        tvUdzbenici.setItems(FXCollections.observableArrayList(output));
        tvUdzbenici.refresh();

    }
}
