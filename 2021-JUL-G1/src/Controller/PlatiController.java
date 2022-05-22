package Controller;

import Controller.Server.Server;
import Model.Isplata;
import Model.Transakcija;
import View.FirstView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class PlatiController implements EventHandler<ActionEvent> {

    private final TextField tfIznos;
    private final TextField tfPrimalac;
    private final ComboBox<String> cbKategorija;

    public PlatiController(TextField tfIznos, TextField tfPrimalac, ComboBox cbKategorija) {
        this.tfIznos = tfIznos;
        this.tfPrimalac = tfPrimalac;
        this.cbKategorija = cbKategorija;
    }

    @Override
    public void handle(ActionEvent event) {

        String danasnjiDatum = String.format("%02d", LocalDate.now().getDayOfMonth()) + "." + String.format("%02d", LocalDate.now().getMonthValue()) + "." + LocalDate.now().getYear() + ".";

        Transakcija transakcija = new Isplata(Integer.parseInt(tfIznos.getText()), danasnjiDatum,tfPrimalac.getText(), cbKategorija.getValue());

        Server.SERVER.getTransakcije().add(transakcija);

        FirstView.FIRST_VIEW.getTvTransakcije().setItems(FXCollections.observableArrayList(Server.SERVER.getTransakcije()));

    }
}
