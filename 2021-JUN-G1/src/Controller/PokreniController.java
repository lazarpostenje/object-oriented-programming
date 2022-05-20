package Controller;

import Controller.Server.Server;
import Controller.Utils.Utils;
import Model.Ucionica;
import View.MainView;
import View.SecondaryView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class PokreniController implements EventHandler<ActionEvent> {

    private final TextField tfBrojTermina;
    private final TextField tfBrojStudenataPoUcionici;
    private final CheckBox cbSamoSaRacunarima;
    private final Label lbPoruka;

    public PokreniController(TextField tfBrojTermina, TextField tfBrojStudenataPoUcionici, CheckBox cbSamoSaRacunarima, Label lbPoruka) {
        this.tfBrojTermina = tfBrojTermina;
        this.tfBrojStudenataPoUcionici = tfBrojStudenataPoUcionici;
        this.cbSamoSaRacunarima = cbSamoSaRacunarima;
        this.lbPoruka = lbPoruka;
    }

    @Override
    public void handle(ActionEvent event) {

        if(!(Utils.isNumeric(tfBrojTermina.getText()) && Utils.isNumeric(tfBrojStudenataPoUcionici.getText()))){

            lbPoruka.setText("Pogresan format broja");
            return;

        } else lbPoruka.setText("");


        int brojTermina = Integer.parseInt(tfBrojTermina.getText());
        boolean samoSaRacunarima = cbSamoSaRacunarima.isSelected();

        for (int i = 1; i <= brojTermina; i++) {

            Server.SERVER.getTermini().put("termin" + i, Utils.ucitajUcionice("ucionice1.txt", samoSaRacunarima));

        }

        int ukupnoMesta = 0;
        int kapacitetUcionica = Integer.parseInt(tfBrojStudenataPoUcionici.getText());
        int kapacitetAmfiteatar = kapacitetUcionica * 2;

        for (ArrayList<Ucionica> ucionice : Server.SERVER.getTermini().values()) {

            for (Ucionica ucionica : ucionice) {

                if(ucionica.isAmfiteatar()) ukupnoMesta += kapacitetAmfiteatar;
                else ukupnoMesta += kapacitetUcionica;

            }

        }

        if(Server.SERVER.getStudenti().size() > ukupnoMesta){

            lbPoruka.setText("Nema dovoljno mesta");
            return;

        }

        Ucionica.setKapacitetUcionica(kapacitetUcionica);
        Ucionica.setKapacitetAmfiteatar(kapacitetAmfiteatar);

        MainView.MAIN_VIEW.hide();
        SecondaryView.SECONDARY_VIEW.show();

    }
}
