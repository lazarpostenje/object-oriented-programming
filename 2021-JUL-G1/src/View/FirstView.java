package View;

import Controller.NovaIsplataController;
import Controller.PregledIsplataController;
import Controller.Server.Server;
import Controller.Utils.Utils;
import Model.Isplata;
import Model.Transakcija;
import Model.Uplata;
import View.HBox.DefaultHBox;
import View.VBox.DefaultVBox;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FirstView extends Stage {

    public static final FirstView FIRST_VIEW = new FirstView();

    private final DefaultVBox root = new DefaultVBox(Pos.CENTER);

    private final Label lbTrenutnoStanje = new Label("Trenutno stanje:");
    private final Label lbTrenutnoStanjeVrednost = new Label();
    private final Label lbTrenutnoStanjeValuta = new Label("RSD");

    private final TableView<Transakcija> tvTransakcije = new TableView<>();

    private final Button btnNovaIsplata = new Button("Nova isplata");
    private final Button btnPregledIsplata = new Button("Pregled isplata");

    private final TableColumn tcIznos = new TableColumn("Iznos");
    private final TableColumn tcUplatilacPrimalac = new TableColumn("Uplatilac/Primalac");
    private final TableColumn tcDatum = new TableColumn("Datum");
    private final TableColumn tcTip = new TableColumn("Tip");

    private final Button btnSnimi = new Button("Snimi");


    private FirstView(){

        tvTransakcije.setPrefHeight(250);
        tvTransakcije.setPrefWidth(500);
        tcUplatilacPrimalac.setPrefWidth(190);
        tvTransakcije.getColumns().addAll(tcIznos, tcUplatilacPrimalac, tcDatum, tcTip);

        tcIznos.setCellValueFactory(new PropertyValueFactory<>("iznos"));
        tcUplatilacPrimalac.setCellValueFactory(new PropertyValueFactory<>("uplatilacPrimalac"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        tcTip.setCellValueFactory(new PropertyValueFactory<>("tip"));

        btnSnimi.setOnAction(e -> {

            Utils.snimiUplate(tvTransakcije.getItems(), "uplate.txt");
            Utils.snimiIsplate(tvTransakcije.getItems(), "isplate.txt");

        });

        tvTransakcije.setItems(FXCollections.observableArrayList(Server.SERVER.getTransakcije()));

        lbTrenutnoStanjeVrednost.setText("" + (Uplata.zbirSvihUplata() - Isplata.zbirSvihUplata()));

        btnNovaIsplata.setOnAction(new NovaIsplataController());
        btnPregledIsplata.setOnAction(new PregledIsplataController(tvTransakcije));

        tvTransakcije.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        root.getChildren().addAll(new DefaultHBox(Pos.CENTER, lbTrenutnoStanje, lbTrenutnoStanjeVrednost, lbTrenutnoStanjeValuta));
        root.getChildren().addAll(tvTransakcije, new DefaultHBox(Pos.CENTER, btnNovaIsplata, btnPregledIsplata, btnSnimi));



        super.setScene(new Scene(root));
        super.setTitle("OOP - ispit jul");

    }


    public TableView<Transakcija> getTvTransakcije() {
        return tvTransakcije;
    }
}
