package View;

import Controller.PokreniController;
import View.HBox.DefaultHBox;
import View.VBox.DefaultVBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainView extends Stage {

    public static final MainView MAIN_VIEW = new MainView();

    private final DefaultVBox root = new DefaultVBox(Pos.CENTER);

    private final Label lbUnesiPodatke = new Label("Unesite potrebne podatke za raspodelu");

    private final Label lbBrojTermina = new Label("Broj termina");
    private final Label lbBrojStudenataPoUcionici = new Label("Broj studenata po ucionici");

    private final TextField tfBrojTermina = new TextField();
    private final TextField tfBrojStudenataPoUcionici = new TextField();

    private final CheckBox cbSamoSaRacunarima = new CheckBox("Samo ucionice sa racunarima");

    private final Button btnPokreni = new Button("Pokreni");

    private final Label lbPoruka = new Label("Poruka");

    private MainView(){

        super.setScene(new Scene(root));
        super.setWidth(500);
        super.setHeight(400);

        btnPokreni.setOnAction(new PokreniController(tfBrojTermina, tfBrojStudenataPoUcionici, cbSamoSaRacunarima, lbPoruka));

        root.getChildren().addAll(lbUnesiPodatke, new DefaultHBox(Pos.CENTER,
                new DefaultVBox(Pos.CENTER_LEFT, lbBrojTermina, lbBrojStudenataPoUcionici),
                new DefaultVBox(Pos.CENTER_LEFT, tfBrojTermina, tfBrojStudenataPoUcionici)));

        root.getChildren().addAll(cbSamoSaRacunarima, btnPokreni, lbPoruka);

    }

}
