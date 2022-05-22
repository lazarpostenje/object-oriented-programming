package Controller;

import Controller.Utils.Utils;
import Model.Transakcija;
import View.FirstView;
import View.ThirdView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

public class PregledIsplataController implements EventHandler<ActionEvent> {

    private final TableView<Transakcija> tvTransakcije;

    public PregledIsplataController(TableView<Transakcija> tvTransakcije) {
        this.tvTransakcije = tvTransakcije;
    }

    @Override
    public void handle(ActionEvent event) {

        if(tvTransakcije.getSelectionModel().getSelectedItems().isEmpty()) return;

        ThirdView.THIRD_VIEW.getLbMinVrednost().setText("" + Utils.minIsplata(tvTransakcije.getSelectionModel().getSelectedItems()));
        ThirdView.THIRD_VIEW.getLbMaxVrednost().setText("" + Utils.maxIsplata(tvTransakcije.getSelectionModel().getSelectedItems()));

        ThirdView.THIRD_VIEW.getLvKategorije().setItems(Utils.generisiAnalitiku(tvTransakcije.getSelectionModel().getSelectedItems()));

        ThirdView.THIRD_VIEW.show();
    }
}
