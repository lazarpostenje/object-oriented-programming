package Controller;

import Model.Student;
import Model.Ucionica;
import View.MainView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PrebaciUUcionicuController implements EventHandler<ActionEvent> {

    private final Label lbPodaciUcionicaVrednost;
    private final Label lbPodaciTerminVrednost;
    private final Label lbPodaciPrekoracenoVrednost;
    private final ListView<Student> lvStudenti;
    private final ComboBox<Integer> cbTermin;
    private final ComboBox<String> cbUcionica;
    private final Label lbPoruka;

    public PrebaciUUcionicuController(Label lbPodaciUcionicaVrednost, Label lbPodaciTerminVrednost, Label lbPodaciPrekoracenoVrednost, ListView<Student> lvStudenti, ComboBox<Integer> cbTermin, ComboBox<String> cbUcionica, Label lbPoruka) {
        this.lbPodaciUcionicaVrednost = lbPodaciUcionicaVrednost;
        this.lbPodaciTerminVrednost = lbPodaciTerminVrednost;
        this.lbPodaciPrekoracenoVrednost = lbPodaciPrekoracenoVrednost;
        this.lvStudenti = lvStudenti;
        this.cbTermin = cbTermin;
        this.cbUcionica = cbUcionica;
        this.lbPoruka = lbPoruka;
    }

    @Override
    public void handle(ActionEvent event) {

        Ucionica ucionica = null;

        if(cbTermin.getValue() == null) return;
        if(cbUcionica.getValue() == null) return;
        if(lvStudenti.getSelectionModel().getSelectedItems().isEmpty()) return;

        for (Ucionica ucionicaIzTabele : MainView.MAIN_VIEW.getTvUcionice().getItems()) {

            if(ucionicaIzTabele.equals(new Ucionica(cbUcionica.getValue(), 0, cbTermin.getValue()))){

                ucionica = ucionicaIzTabele;

            }

        }

        if(ucionica == null) {

            lbPoruka.setText("Ta ucionica ne postoji za zadati termin");
            return;

        }

        Ucionica trenutnaUcionica = null;

        for (Ucionica ucionicaIzTabele : MainView.MAIN_VIEW.getTvUcionice().getItems()) {

            if(ucionicaIzTabele.equals(new Ucionica(lbPodaciUcionicaVrednost.getText(), 0, Integer.parseInt(lbPodaciTerminVrednost.getText())))){

                trenutnaUcionica = ucionicaIzTabele;

            }

        }

        if(trenutnaUcionica == null) return;


        if(ucionica.dodajStudente(lvStudenti.getSelectionModel().getSelectedItems())){

            for (Student student : lvStudenti.getSelectionModel().getSelectedItems()) {

                student.setTermin(cbTermin.getValue());
                student.setUcionica(cbUcionica.getValue());

            }

            trenutnaUcionica.getStudenti().removeAll(lvStudenti.getSelectionModel().getSelectedItems());
            lvStudenti.setItems(FXCollections.observableArrayList(trenutnaUcionica.getStudenti()));
            lvStudenti.refresh();
            MainView.MAIN_VIEW.getTvUcionice().refresh();
            lbPodaciPrekoracenoVrednost.setText("" + trenutnaUcionica.getBrojPrekoracenihMesta());
            lbPoruka.setText("Poruka");

        } else lbPoruka.setText("Nema dovoljno mesta u ucionici");

    }
}
