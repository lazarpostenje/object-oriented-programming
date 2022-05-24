package Controller;

import Controller.Server.Server;
import Model.Zaposleni;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Locale;

public class FiltrirajController implements EventHandler<ActionEvent> {

    private final TableView<Zaposleni> tvZaposleni;
    private final TextField tfFilter;
    private final ComboBox<String> cbPozicija;

    public FiltrirajController(TableView<Zaposleni> tvZaposleni, TextField tfFilter, ComboBox cbPozicija) {
        this.tvZaposleni = tvZaposleni;
        this.tfFilter = tfFilter;
        this.cbPozicija = cbPozicija;
    }

    @Override
    public void handle(ActionEvent event) {

        if (Zaposleni.getCenaRada() == 0) return;

        ArrayList<Zaposleni> output = new ArrayList<>();

        String filter = tfFilter.getText().toLowerCase();

        if(cbPozicija.getValue().equals("Sve pozicije")){

            for (Zaposleni zaposleni : Server.SERVER.getZaposleni()) {

                if(zaposleni.getIme().toLowerCase().contains(filter) || zaposleni.getPrezime().toLowerCase().contains(filter)){

                    output.add(zaposleni);

                }

            }

        } else {

            for (Zaposleni zaposleni : Server.SERVER.getZaposleni()) {

                if(zaposleni.getZanimanje().equals(cbPozicija.getValue())){

                    if(zaposleni.getIme().toLowerCase().contains(filter) || zaposleni.getPrezime().toLowerCase().contains(filter)){

                        output.add(zaposleni);

                    }

                }

            }

        }

        tvZaposleni.setItems(FXCollections.observableArrayList(output));

    }
}
