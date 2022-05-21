package View;

import Controller.DodajController;
import Controller.PrebaciController;
import Controller.SacuvajController;
import Controller.Server.Server;
import Controller.Utils.Utils;
import Model.Ucionica;
import View.HBox.DefaultHBox;
import View.VBox.RootVBox;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class MainView extends Stage {

    public static final MainView MAIN_VIEW = new MainView();

    private final RootVBox root = new RootVBox(Pos.CENTER);

    private final Button btnSacuvaj = new Button("Sacuvaj");
    private final Button btnPrebaci = new Button("Prebaci");

    private final TableView<Ucionica> tvUcionice = new TableView<>(); //TODO promeniti genericku klasu i dodati FXCollections

    private final TableColumn tcUcionica = new TableColumn("Ucionica");
    private final TableColumn tcTermin = new TableColumn("Termin");
    private final TableColumn tcBrojStudenata = new TableColumn("Broj studenata");
    private final TableColumn tcPrekoracenje = new TableColumn("Prekoracenje");
    private final TableColumn tcSlobodno = new TableColumn("Slobodno");

    private final Label lbNoviTermin = new Label("Novi termin");
    private final TextField tfNoviTermin = new TextField();

    private final Label lbUcionice = new Label("Ucionice");
    private final ListView<String> lvUcionice = new ListView<>();

    private final Button btnDodaj = new Button("Dodaj");

    private MainView(){

        tvUcionice.setPrefHeight(250);
        tvUcionice.setPrefWidth(500);
        tcBrojStudenata.setPrefWidth(110);
        tvUcionice.getColumns().addAll(tcUcionica, tcTermin,tcBrojStudenata, tcPrekoracenje, tcSlobodno);
        lvUcionice.setPrefHeight(300);
        lbUcionice.setPrefWidth(63);
        tfNoviTermin.setPrefWidth(248);

        btnDodaj.setOnAction(new DodajController(lvUcionice, tfNoviTermin, tvUcionice));

        tcUcionica.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcTermin.setCellValueFactory(new PropertyValueFactory<>("termin"));
        tcBrojStudenata.setCellValueFactory(new PropertyValueFactory<>("brojStudenata"));
        tcPrekoracenje.setCellValueFactory(new PropertyValueFactory<>("brojPrekoracenihMesta"));
        tcSlobodno.setCellValueFactory(new PropertyValueFactory<>("brojSlobodnihMesta"));

        tvUcionice.setItems(FXCollections.observableArrayList(Server.SERVER.getUcionice()));
        lvUcionice.setItems(Utils.generisiUcioniceZaListView());
        lvUcionice.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        btnPrebaci.setOnAction(new PrebaciController(tvUcionice));

        btnSacuvaj.setOnAction(new SacuvajController());

        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_RIGHT, btnPrebaci, btnSacuvaj), tvUcionice);
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbNoviTermin, tfNoviTermin));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbUcionice, lvUcionice), new DefaultHBox(Pos.CENTER_LEFT, btnDodaj));



        super.setScene(new Scene(root));

    }

    public TableView<Ucionica> getTvUcionice() {
        return tvUcionice;
    }
}
