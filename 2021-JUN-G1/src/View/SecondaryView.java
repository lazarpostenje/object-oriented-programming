package View;

import Controller.DodeliController;
import Controller.Server.Server;
import Controller.SnimiController;
import Controller.TerminController;
import Controller.Utils.Utils;
import Model.Student;
import Model.Ucionica;
import View.HBox.NoPaddingHBox;
import View.VBox.DefaultVBox;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SecondaryView extends Stage {

    public static final SecondaryView SECONDARY_VIEW = new SecondaryView();

    private final BorderPane root = new BorderPane();

    // leva strana
    private final Label lbNerasporedjeni = new Label("Broj nerasporedjenih studenata:");
    private final Label lbNerasporedjeniBroj = new Label("" + Server.SERVER.getStudenti().size());
    private final ListView<Student> lvNerasporedjeni = new ListView<>(FXCollections.observableArrayList(Server.SERVER.getStudenti()));

    //desna strana
    private final ComboBox<String> cbTermini = new ComboBox<String>(FXCollections.observableArrayList(Utils.generisiTermine()));
    private final ListView<Ucionica> lvUcionice = new ListView<>();

    //sredina
    private final Button btnDodeli = new Button("Dodeli");

    //dole
    private final TableView<Student> tvRasporedjeni = new TableView<>();
    private final Button btnSnimi = new Button("Snimi");
    private final TableColumn tcStudent = new TableColumn("Student");
    private final TableColumn tcTermin = new TableColumn("Termin");
    private final TableColumn tcUcionica = new TableColumn("Ucionica");


    private SecondaryView(){

        tvRasporedjeni.setPrefHeight(200);
        tvRasporedjeni.getColumns().addAll(tcStudent, tcTermin, tcUcionica);
        cbTermini.setOnAction(new TerminController(lvUcionice, cbTermini));
        btnDodeli.setOnAction(new DodeliController(lvNerasporedjeni, lvUcionice, tvRasporedjeni, lbNerasporedjeniBroj, cbTermini));
        btnSnimi.setOnAction(new SnimiController(tvRasporedjeni));
        tcStudent.setPrefWidth(150);
        tcStudent.setCellValueFactory(new PropertyValueFactory<>("prikazImenaZaTabelu"));
        tcTermin.setCellValueFactory(new PropertyValueFactory<>("termin"));
        tcUcionica.setCellValueFactory(new PropertyValueFactory<>("prikazUcioniceZaTabelu"));


        root.setLeft(new DefaultVBox(Pos.CENTER, new NoPaddingHBox(Pos.CENTER_LEFT, lbNerasporedjeni, lbNerasporedjeniBroj), lvNerasporedjeni));
        root.setCenter(btnDodeli);
        root.setRight(new DefaultVBox(Pos.CENTER, cbTermini, lvUcionice));
        root.setBottom(new DefaultVBox(Pos.CENTER, tvRasporedjeni, btnSnimi));


        super.setScene(new Scene(root));

    }

}
