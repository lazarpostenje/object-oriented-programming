package View;

import Controller.DodajController;
import Controller.Utils.Utils;
import View.HBox.DefaultHBox;
import View.VBox.NoPaddingVBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondView extends Stage {

    public static final SecondView SECOND_VIEW = new SecondView();

    private final NoPaddingVBox root = new NoPaddingVBox(Pos.CENTER);

    private final Label lbIme = new Label("Ime");
    private final Label lbPrezime = new Label("Prezime");
    private final Label lbJMBG = new Label("JMBG");
    private final Label lbPozicija = new Label("Pozicija");
    private final Label lbGodinaZaposlenja = new Label("Godina zaposlenja");

    private final TextField tfIme = new TextField();
    private final TextField tfPrezime = new TextField();
    private final TextField tfJMBG = new TextField();
    private final TextField tfGodinaZaposlenja = new TextField();
    private final ComboBox<String> cbPozicija = new ComboBox<>();

    private Button btnDodaj = new Button("Dodaj");

    private SecondView(){

        cbPozicija.setItems(Utils.generisiZanimanja(false));

        lbIme.setPrefWidth(100);
        lbPrezime.setPrefWidth(100);
        lbJMBG.setPrefWidth(100);
        lbPozicija.setPrefWidth(100);
        lbGodinaZaposlenja.setPrefWidth(100);
        cbPozicija.getSelectionModel().selectFirst();

        btnDodaj.setOnAction(new DodajController(tfIme, tfPrezime, tfJMBG, tfGodinaZaposlenja, cbPozicija));

        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbIme, tfIme));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbPrezime, tfPrezime));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbJMBG, tfJMBG));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbPozicija, cbPozicija));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbGodinaZaposlenja, tfGodinaZaposlenja));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, btnDodaj));

        super.setTitle("Dodaj zaposlenog");
        super.setScene(new Scene(root));

    }

}
