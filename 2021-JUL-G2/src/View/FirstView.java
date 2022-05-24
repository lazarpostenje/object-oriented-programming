package View;

import Controller.DodajZaposlenogController;
import Controller.FiltrirajController;
import Controller.ObracunajController;
import Controller.StatistikaController;
import Controller.Utils.Utils;
import Model.Zaposleni;
import View.HBox.DefaultHBox;
import View.VBox.DefaultVBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FirstView extends Stage {

    public static final FirstView FIRST_VIEW = new FirstView();

    private final DefaultVBox root = new DefaultVBox(Pos.CENTER);

    private final Label lbCenaRada = new Label("Cena rada: ");
    private final TextField tfCenaRada = new TextField();
    private final Button btnObracunaj = new Button("Obracunaj");

    private final TableView<Zaposleni> tvZaposleni = new TableView<>();

    private final Label lbFilter = new Label("Filter");
    private final TextField tfFilter = new TextField();
    private final Label lbPozicija = new Label("Pozicija");
    private final ComboBox<String> cbPozicija = new ComboBox<>(Utils.generisiZanimanja(true));
    private final Button btnFiltriraj = new Button("Filtriraj");

    private final Button btnDodajZaposlenog = new Button("Dodaj zaposlenog");
    private final Button btnSnimi = new Button("Snimi");
    private final Button btnStatistika = new Button("Statistika");

    //kolone za table view

    private final TableColumn tcIme = new TableColumn("Ime");
    private final TableColumn tcPrezime = new TableColumn("Prezime");
    private final TableColumn tcJMBG = new TableColumn("JMBG");
    private final TableColumn tcPozicija = new TableColumn("Pozicija");
    private final TableColumn tcPlata = new TableColumn("Plata");

    private FirstView(){

        tvZaposleni.setPrefHeight(200);
        tvZaposleni.setPrefWidth(550);

        tvZaposleni.getColumns().addAll(tcIme, tcPrezime, tcJMBG, tcPozicija, tcPlata);
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcJMBG.setCellValueFactory(new PropertyValueFactory<>("jmbg"));
        tcPozicija.setCellValueFactory(new PropertyValueFactory<>("zanimanje"));
        tcPlata.setCellValueFactory(new PropertyValueFactory<>("plata"));
        cbPozicija.getSelectionModel().selectFirst();

        //Event Handleri
        btnObracunaj.setOnAction(new ObracunajController(tfCenaRada, tvZaposleni));
        btnFiltriraj.setOnAction(new FiltrirajController(tvZaposleni, tfFilter, cbPozicija));
        btnDodajZaposlenog.setOnAction(new DodajZaposlenogController());
        btnSnimi.setOnAction(e -> {

            Utils.snimi("ispis.txt");

        });
        btnStatistika.setOnAction(new StatistikaController());

        root.getChildren().add(new DefaultHBox(Pos.CENTER, lbCenaRada, tfCenaRada, btnObracunaj));
        root.getChildren().add(tvZaposleni);
        root.getChildren().add(new DefaultHBox(Pos.CENTER, lbFilter, tfFilter, lbPozicija, cbPozicija, btnFiltriraj));
        root.getChildren().add(new DefaultHBox(Pos.CENTER, btnDodajZaposlenog, btnSnimi, btnStatistika));

        super.setTitle("Ispit jun 2021");
        super.setScene(new Scene(root));

    }

    public TableView<Zaposleni> getTvZaposleni() {
        return tvZaposleni;
    }
}
