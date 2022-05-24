package Controller;

import Controller.Server.Server;
import Model.Statistika;
import Model.Zaposleni;
import View.FirstView;
import View.ThirdView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class StatistikaController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {

        if(FirstView.FIRST_VIEW.getTvZaposleni().getItems().isEmpty()) return;

        ArrayList<Statistika> statistike = new ArrayList<>();

        for (String zanimanje : Server.SERVER.getZanimanja().keySet()) {

            int brojZaposlenih = 0;
            double zbirZarada = 0;

            for (Zaposleni zaposleni : Server.SERVER.getZaposleni()) {

                if(zaposleni.getZanimanje().equals(zanimanje)){

                    brojZaposlenih++;
                    zbirZarada += zaposleni.getPlata();

                }

            }

            statistike.add(new Statistika(zanimanje, brojZaposlenih, zbirZarada / brojZaposlenih));

        }

        statistike.sort(null);

        ThirdView.THIRD_VIEW.getLvPozicije().setItems(FXCollections.observableArrayList(statistike));

        int ukupanBrojZaposlenih = Server.SERVER.getZaposleni().size();
        double ukupanMesecniIzdatak = 0;
        double ukupnePlate = 0;

        for (Statistika statistika : statistike) {

            ukupanMesecniIzdatak += statistika.getProsecnaZarada();

        }

        for (Zaposleni zaposleni : Server.SERVER.getZaposleni()) {

            ukupnePlate += zaposleni.getPlata();

        }

        ThirdView.THIRD_VIEW.getLbIzdatakVrednost().setText("" + String.format("%.2f", ukupanMesecniIzdatak));
        ThirdView.THIRD_VIEW.getLbBrojZaposlenihVrednost().setText("" + ukupanBrojZaposlenih);
        ThirdView.THIRD_VIEW.getLbProsecnaZaradaVrednost().setText("" + String.format("%.2f", ukupnePlate / ukupanBrojZaposlenih));

        ThirdView.THIRD_VIEW.show();

    }
}
