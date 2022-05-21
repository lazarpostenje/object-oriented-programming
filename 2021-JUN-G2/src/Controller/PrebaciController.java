package Controller;

import Controller.Server.Server;
import Controller.Utils.Utils;
import Model.Ucionica;
import View.SecondaryView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

public class PrebaciController implements EventHandler<ActionEvent> {

    private final TableView<Ucionica> tvUcionica;

    public PrebaciController(TableView<Ucionica> tvUcionica) {
        this.tvUcionica = tvUcionica;
    }

    @Override
    public void handle(ActionEvent event) {

        Ucionica ucionica = tvUcionica.getSelectionModel().getSelectedItem();

        if(ucionica == null) return;

        SecondaryView.SECONDARY_VIEW.getLbPodaciUcionicaVrednost().setText(ucionica.getNaziv());
        SecondaryView.SECONDARY_VIEW.getLbPodaciTerminVrednost().setText("" + ucionica.getTermin());
        SecondaryView.SECONDARY_VIEW.getLbPodaciPrekoracenoVrednost().setText("" + ucionica.getBrojPrekoracenihMesta());

        SecondaryView.SECONDARY_VIEW.getLvStudenti().setItems(FXCollections.observableArrayList(ucionica.getStudenti()));
        SecondaryView.SECONDARY_VIEW.getCbTermin().setItems(Utils.generisiTermine());
        SecondaryView.SECONDARY_VIEW.getCbUcionica().setItems(FXCollections.observableArrayList(Server.SERVER.getMapaUcionica().keySet()));
        SecondaryView.SECONDARY_VIEW.show();


    }
}
