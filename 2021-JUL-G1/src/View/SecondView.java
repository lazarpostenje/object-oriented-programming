package View;

import Controller.PlatiController;
import Controller.Server.Server;
import Controller.Utils.Utils;
import View.HBox.DefaultHBox;
import View.VBox.DefaultVBox;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondView extends Stage {

    public static final SecondView SECOND_VIEW = new SecondView();

    private final DefaultVBox root = new DefaultVBox(Pos.CENTER);

    private final Label lbIznos = new Label("Iznos");
    private final Label lbPrimalac = new Label("Primalac");
    private final Label lbKategorija = new Label("Kategorija");

    private final TextField tfIznos = new TextField();
    private final TextField tfPrimalac = new TextField();
    private final ComboBox<String> cbKategorija = new ComboBox<>();

    private final Button btnPlati = new Button("Plati");

    private SecondView(){

        super.setTitle("OOP - ispit jul");
        super.setScene(new Scene(root));

        lbIznos.setPrefWidth(45);
        cbKategorija.setItems(Utils.generisiKategorije(FXCollections.observableArrayList(Server.SERVER.getTransakcije())));
        btnPlati.setOnAction(new PlatiController(tfIznos, tfPrimalac, cbKategorija));

        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbIznos,tfIznos));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbPrimalac,tfPrimalac));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbKategorija,cbKategorija));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, btnPlati));


    }

}
