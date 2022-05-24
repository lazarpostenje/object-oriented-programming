package Controller;

import Controller.Server.Server;
import Model.Zaposleni;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ObracunajController implements EventHandler<ActionEvent> {

    private final TextField tfCenaRada;
    private final TableView<Zaposleni> tvZaposleni;

    public ObracunajController(TextField tfCenaRada, TableView<Zaposleni> tvZaposleni) {
        this.tfCenaRada = tfCenaRada;
        this.tvZaposleni = tvZaposleni;
    }

    @Override
    public void handle(ActionEvent event) {

        if(tfCenaRada.getText().equals("")) return;

        Zaposleni.setCenaRada(Integer.parseInt(tfCenaRada.getText()));

        tvZaposleni.setItems(FXCollections.observableArrayList(Server.SERVER.getZaposleni()));
        tvZaposleni.refresh();

    }

}
