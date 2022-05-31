package View;

import Controller.IzaberiController;
import Controller.IzvrsiController;
import Controller.Server.Server;
import Controller.SnimiController;
import Controller.Utils.Utils;
import Model.Izdavac;
import Model.Udzbenik;
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

    private final TableView<Izdavac> tvIzdavaci = new TableView<>(FXCollections.observableArrayList(Server.SERVER.getIzdavaci()));

    private final ComboBox<String> cbRazredi = new ComboBox<>(Utils.generisiRazrede());

    private final Button btnIzaberi = new Button("Izaberi");

    private final TableView<Udzbenik> tvUdzbenici = new TableView<>();

    private final ComboBox<String> cbDodajSmanjiPrimerke = new ComboBox<>(Utils.generisiDodajSmanjiOpcije());

    private final TextField tfDodajSmanjiPrimerke = new TextField();

    private final Button btnIzvrsi = new Button("Izvrsi");

    private final Button btnSnimi = new Button("Snimi");

    //gornja tabela
    private final TableColumn tcIzdavac = new TableColumn("Izdavac");
    private final TableColumn tcRazredi = new TableColumn("Razredi");
    private final TableColumn tcBrojPrimeraka = new TableColumn("Broj primeraka");
    private final TableColumn tcProsecnaCena = new TableColumn("Prosecna cena");

    //donja tabela

    private final TableColumn tcId = new TableColumn("Id");
    private final TableColumn tcRazred = new TableColumn("Razred");
    private final TableColumn tcIzdavacDonji = new TableColumn("Izdavac");
    private final TableColumn tcPredmet = new TableColumn("Predmet");
    private final TableColumn tcNaslov = new TableColumn("Naslov");
    private final TableColumn tcAutori = new TableColumn("Autori");
    private final TableColumn tcBrojPrimerakaDonji = new TableColumn("Broj primeraka");
    private final TableColumn tcCena = new TableColumn("Cena");

    private FirstView(){

        tcBrojPrimeraka.setPrefWidth(100);
        tcProsecnaCena.setPrefWidth(100);
        tcBrojPrimerakaDonji.setPrefWidth(100);

        cbRazredi.getSelectionModel().selectFirst();

        btnIzaberi.setOnAction(new IzaberiController(tvIzdavaci, tvUdzbenici, cbRazredi));

        tcIzdavac.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcRazredi.setCellValueFactory(new PropertyValueFactory<>("razredi"));
        tcBrojPrimeraka.setCellValueFactory(new PropertyValueFactory<>("brojPrimeraka"));
        tcProsecnaCena.setCellValueFactory(new PropertyValueFactory<>("prosecnaCena"));

        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcRazred.setCellValueFactory(new PropertyValueFactory<>("razred"));
        tcIzdavacDonji.setCellValueFactory(new PropertyValueFactory<>("izdavac"));
        tcPredmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));
        tcNaslov.setCellValueFactory(new PropertyValueFactory<>("naslov"));
        tcAutori.setCellValueFactory(new PropertyValueFactory<>("autori"));
        tcBrojPrimerakaDonji.setCellValueFactory(new PropertyValueFactory<>("brojPrimeraka"));
        tcCena.setCellValueFactory(new PropertyValueFactory<>("cena"));

        cbDodajSmanjiPrimerke.getSelectionModel().selectFirst();

        btnIzvrsi.setOnAction(new IzvrsiController(tvIzdavaci, tvUdzbenici, cbDodajSmanjiPrimerke, tfDodajSmanjiPrimerke));
        btnSnimi.setOnAction(new SnimiController());

        tvUdzbenici.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tvIzdavaci.getColumns().addAll(tcIzdavac, tcRazredi, tcBrojPrimeraka, tcProsecnaCena);
        tvUdzbenici.getColumns().addAll(tcId, tcRazred, tcIzdavacDonji, tcPredmet, tcNaslov, tcAutori, tcBrojPrimerakaDonji, tcCena);

        root.getChildren().addAll(tvIzdavaci, new DefaultVBox(Pos.CENTER, cbRazredi, btnIzaberi), tvUdzbenici);
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, cbDodajSmanjiPrimerke, tfDodajSmanjiPrimerke, btnIzvrsi, btnSnimi));

        super.setScene(new Scene(root, 800, 900));

    }

    public TableView<Izdavac> getTvIzdavaci() {
        return tvIzdavaci;
    }
}
