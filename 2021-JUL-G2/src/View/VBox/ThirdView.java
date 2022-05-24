package View.VBox;

import Model.Statistika;
import View.HBox.DefaultHBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ThirdView extends Stage {

    public static final ThirdView THIRD_VIEW = new ThirdView();

    private final DefaultVBox root = new DefaultVBox(Pos.CENTER);

    private final ListView<Statistika> lvPozicije = new ListView<>(); //Dodati FXCollections listu

    private final Label lbIzdatak = new Label("Ukupni mesecni izdatak po osnovu zarada:");
    private final Label lbIzdatakVrednost = new Label();

    private final Label lbBrojZaposlenih = new Label("Broj zaposlenih:");
    private final Label lbBrojZaposlenihVrednost = new Label();

    private final Label lbProsecnaZarada = new Label("Prosecna zarada po zaposlenom:");
    private final Label lbProsecnaZaradaVrednost = new Label();

    private ThirdView(){

        lvPozicije.setPrefWidth(300);
        lvPozicije.setPrefHeight(200);

        root.getChildren().addAll(lvPozicije, new DefaultHBox(Pos.CENTER_LEFT, lbIzdatak, lbIzdatakVrednost));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbBrojZaposlenih, lbBrojZaposlenihVrednost));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbProsecnaZarada, lbProsecnaZaradaVrednost));

        super.setTitle("Statistika");
        super.setScene(new Scene(root));

    }

    public ListView<Statistika> getLvPozicije() {
        return lvPozicije;
    }

    public Label getLbIzdatakVrednost() {
        return lbIzdatakVrednost;
    }

    public Label getLbBrojZaposlenihVrednost() {
        return lbBrojZaposlenihVrednost;
    }

    public Label getLbProsecnaZaradaVrednost() {
        return lbProsecnaZaradaVrednost;
    }
}
