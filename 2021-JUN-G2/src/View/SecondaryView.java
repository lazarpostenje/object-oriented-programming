package View;

import Controller.PrebaciUUcionicuController;
import Model.Student;
import Model.Ucionica;
import View.HBox.DefaultHBox;
import View.VBox.RootVBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SecondaryView extends Stage {

    public static final SecondaryView SECONDARY_VIEW = new SecondaryView();

    private final RootVBox root = new RootVBox(Pos.CENTER);

    private final Label lbPodaciUcionica = new Label("Ucionica:");
    private final Label lbPodaciUcionicaVrednost = new Label();

    private final Label lbPodaciTermin = new Label(", termin:");
    private final Label lbPodaciTerminVrednost = new Label();

    private final Label lbPodaciPrekoraceno = new Label(", prekoraceno:");
    private final Label lbPodaciPrekoracenoVrednost = new Label();

    private final ListView<Student> lvStudenti = new ListView<>();

    private final Label lbTermin = new Label("Termin");
    private final ComboBox<Integer> cbTermin = new ComboBox<>();

    private final Label lbUcionica = new Label("Ucionica");
    private final ComboBox<String> cbUcionica = new ComboBox<>();

    private final Button btnPrebaci = new Button("Prebaci");

    private final Label lbPoruka = new Label("Poruka");

    private SecondaryView(){

        lvStudenti.setPrefHeight(300);
        lvStudenti.setPrefWidth(550);

        lvStudenti.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        btnPrebaci.setOnAction(new PrebaciUUcionicuController(lbPodaciUcionicaVrednost, lbPodaciTerminVrednost, lbPodaciPrekoracenoVrednost, lvStudenti, cbTermin, cbUcionica, lbPoruka));

        root.getChildren().add(new DefaultHBox(Pos.CENTER, lbPodaciUcionica, lbPodaciUcionicaVrednost, lbPodaciTermin, lbPodaciTerminVrednost, lbPodaciPrekoraceno, lbPodaciPrekoracenoVrednost));
        root.getChildren().addAll(lvStudenti, new DefaultHBox(Pos.CENTER, lbTermin, cbTermin));
        root.getChildren().addAll(new DefaultHBox(Pos.CENTER, lbUcionica, cbUcionica), btnPrebaci,lbPoruka);
        super.setScene(new Scene(root));

    }

    public Label getLbPodaciUcionica() {
        return lbPodaciUcionica;
    }

    public Label getLbPodaciUcionicaVrednost() {
        return lbPodaciUcionicaVrednost;
    }

    public Label getLbPodaciTermin() {
        return lbPodaciTermin;
    }

    public Label getLbPodaciTerminVrednost() {
        return lbPodaciTerminVrednost;
    }

    public Label getLbPodaciPrekoraceno() {
        return lbPodaciPrekoraceno;
    }

    public Label getLbPodaciPrekoracenoVrednost() {
        return lbPodaciPrekoracenoVrednost;
    }

    public ListView<Student> getLvStudenti() {
        return lvStudenti;
    }

    public ComboBox<Integer> getCbTermin() {
        return cbTermin;
    }

    public ComboBox<String> getCbUcionica() {
        return cbUcionica;
    }
}
