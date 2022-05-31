package Controller;

import Model.Izdavac;
import Model.Udzbenik;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Iterator;

public class IzvrsiController implements EventHandler<ActionEvent> {

    private final TableView<Izdavac> tvIzdavaci;
    private final TableView<Udzbenik> tvUdzbenici;
    private final ComboBox<String> cbDodajSmanjiPrimerke;
    private final TextField tfDodajSmanjiPrimerke;

    public IzvrsiController(TableView<Izdavac> tvIzdavaci, TableView<Udzbenik> tvUdzbenici, ComboBox<String> cbDodajSmanjiPrimerke, TextField tfDodajSmanjiPrimerke) {
        this.tvIzdavaci = tvIzdavaci;
        this.tvUdzbenici = tvUdzbenici;
        this.cbDodajSmanjiPrimerke = cbDodajSmanjiPrimerke;
        this.tfDodajSmanjiPrimerke = tfDodajSmanjiPrimerke;
    }

    @Override
    public void handle(ActionEvent event) {

        if(tfDodajSmanjiPrimerke.getText().equals("")) return;

        ObservableList<Udzbenik> selektovaniUdzbenici = tvUdzbenici.getSelectionModel().getSelectedItems();

        if(selektovaniUdzbenici.isEmpty()) return;

        int kolicina = Integer.parseInt(tfDodajSmanjiPrimerke.getText());

        int znak = 1;

        ArrayList<Udzbenik> zaBrisanje = new ArrayList<>();

        if(cbDodajSmanjiPrimerke.getValue().equals("Smanji broj primeraka")) znak = -1;

        for (Udzbenik udzbenik : selektovaniUdzbenici) {

            if(udzbenik.getBrojPrimeraka() + (kolicina * znak) <= 0) {

                udzbenik.setBrojPrimeraka(0);
                zaBrisanje.add(udzbenik);

            } else udzbenik.setBrojPrimeraka(udzbenik.getBrojPrimeraka() + (kolicina * znak));

        }

       tvUdzbenici.getItems().removeAll(zaBrisanje);

        tvUdzbenici.refresh();
        tvIzdavaci.refresh();

    }
}
