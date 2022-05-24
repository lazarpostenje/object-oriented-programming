package Controller;

import Controller.Server.Server;
import Model.Zaposleni;
import View.FirstView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class DodajController implements EventHandler<ActionEvent> {

    private final TextField tfIme;
    private final TextField tfPrezime;
    private final TextField tfJMBG;
    private final TextField tfGodinaZaposlenja;
    private final ComboBox<String> cbPozicija;

    public DodajController(TextField tfIme, TextField tfPrezime, TextField tfJMBG, TextField tfGodinaZaposlenja, ComboBox<String> cbPozicija) {
        this.tfIme = tfIme;
        this.tfPrezime = tfPrezime;
        this.tfJMBG = tfJMBG;
        this.tfGodinaZaposlenja = tfGodinaZaposlenja;
        this.cbPozicija = cbPozicija;
    }

    @Override
    public void handle(ActionEvent event) {

        if(tfIme.getText().equals("") || tfPrezime.getText().equals("") || tfJMBG.getText().equals("") || tfGodinaZaposlenja.getText().equals(""))
            return;

        Zaposleni z = new Zaposleni(tfIme.getText(), tfPrezime.getText(), tfJMBG.getText(), Integer.parseInt(tfGodinaZaposlenja.getText()), cbPozicija.getValue());

        Server.SERVER.getZaposleni().add(z);

        FirstView.FIRST_VIEW.getTvZaposleni().setItems(FXCollections.observableArrayList(Server.SERVER.getZaposleni()));
        FirstView.FIRST_VIEW.getTvZaposleni().refresh();

    }
}
