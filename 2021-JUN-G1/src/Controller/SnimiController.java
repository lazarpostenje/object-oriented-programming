package Controller;

import Controller.Utils.Utils;
import Model.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

public class SnimiController implements EventHandler<ActionEvent> {

    private final TableView tvRasporedjeni;

    public SnimiController(TableView tvRasporedjeni) {
        this.tvRasporedjeni = tvRasporedjeni;
    }

    @Override
    public void handle(ActionEvent event) {

        ObservableList<Student> rasporedjeni = tvRasporedjeni.getItems();
        rasporedjeni.sort(null);
        Utils.ispis("ispis.txt", rasporedjeni);

    }
}
