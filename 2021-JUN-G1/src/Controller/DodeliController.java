package Controller;

import Model.Student;
import Model.Ucionica;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

public class DodeliController implements EventHandler<ActionEvent> {

    private final ListView lvNerasporedjeni;
    private final ListView lvUcionice;
    private final TableView tvRasporedjeni;
    private final Label lbNerasporedjeniBroj;
    private final ComboBox cbTermini;

    public DodeliController(ListView lvNerasporedjeni, ListView lvUcionice, TableView tvRasporedjeni, Label lbNerasporedjeniBroj, ComboBox cbTermini) {
        this.lvNerasporedjeni = lvNerasporedjeni;
        this.lvUcionice = lvUcionice;
        this.tvRasporedjeni = tvRasporedjeni;
        this.lbNerasporedjeniBroj = lbNerasporedjeniBroj;
        this.cbTermini = cbTermini;
    }

    @Override
    public void handle(ActionEvent event) {

        if(lvNerasporedjeni.getSelectionModel().getSelectedItem() == null) return;
        if(lvUcionice.getSelectionModel().getSelectedItem() == null) return;


        ObservableList<Student> nerasporedjeni = lvNerasporedjeni.getItems();

        Student student = (Student) lvNerasporedjeni.getSelectionModel().getSelectedItem();

        Ucionica ucionica = (Ucionica) lvUcionice.getSelectionModel().getSelectedItem();

        if(ucionica.dodajStudenta(student)){

            nerasporedjeni.remove(student);
            lvNerasporedjeni.setItems(nerasporedjeni);
            lvNerasporedjeni.refresh();
            lvUcionice.refresh();
            lbNerasporedjeniBroj.setText("" + nerasporedjeni.size());
            tvRasporedjeni.getItems().add(student);
            student.setTermin("" + cbTermini.getValue());
            student.setUcionica(ucionica);

        }

    }
}
