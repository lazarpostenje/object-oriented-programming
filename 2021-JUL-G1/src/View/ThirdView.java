package View;

import Controller.Utils.Utils;
import View.HBox.DefaultHBox;
import View.VBox.DefaultVBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ThirdView extends Stage {

    public static final ThirdView THIRD_VIEW = new ThirdView();

    private final DefaultVBox root = new DefaultVBox(Pos.CENTER);

    private final Label lbMin = new Label("Minimalna isplata:");
    private final Label lbMax = new Label("Maksimalna isplata:");
    private final Label lbMinVrednost = new Label();
    private final Label lbMaxVrednost = new Label();
    private final Label lbMinValuta = new Label("RSD");
    private final Label lbMaxValuta = new Label("RSD");

    private final ListView<String> lvKategorije = new ListView<>(); //TODO: FXCollections
    private final Button btnZatvori = new Button("Zatvori");

    private ThirdView(){

        lvKategorije.setPrefWidth(500);
        lvKategorije.setPrefHeight(250);

        btnZatvori.setOnAction(e -> ThirdView.THIRD_VIEW.hide());

        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbMin, lbMinVrednost, lbMinValuta));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER_LEFT, lbMax, lbMaxVrednost, lbMaxValuta), lvKategorije, btnZatvori);

        super.setTitle("OOP - ispit jul");
        super.setScene(new Scene(root));

    }

    public ListView<String> getLvKategorije() {
        return lvKategorije;
    }

    public Label getLbMinVrednost() {
        return lbMinVrednost;
    }

    public Label getLbMaxVrednost() {
        return lbMaxVrednost;
    }
}
