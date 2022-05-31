package Controller.Utils;

import Controller.Server.Server;
import Model.Izdavac;
import Model.Udzbenik;
import View.FirstView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Utils {

    public static void ucitaj(String imeFajla){

        File file = new File(imeFajla);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            while((line = br.readLine()) != null){

                String podaci[] = line.split(",");

                Izdavac izdavac = new Izdavac(podaci[3]);

                if(!Server.SERVER.getIzdavaci().contains(izdavac)) Server.SERVER.getIzdavaci().add(izdavac);
                else {

                    for (Izdavac izdavacIzServera : Server.SERVER.getIzdavaci()) {

                        if(izdavac.equals(izdavacIzServera)) izdavac = izdavacIzServera;

                    }

                }

                int razred = podaci[2].charAt(0) - '0';

                Udzbenik udzbenik = new Udzbenik(Integer.parseInt(podaci[0]), razred, izdavac, podaci[4], podaci[1], Double.parseDouble(podaci[podaci.length-2]), Integer.parseInt(podaci[podaci.length-1]));

                for (int i = 5; i < podaci.length - 2; i++) {

                    udzbenik.getAutori().add(podaci[i]);
                    
                }

                izdavac.getUdzbenici().add(udzbenik);

                Server.SERVER.getUdzbenici().add(udzbenik);

            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ObservableList<String> generisiRazrede(){

        LinkedList<String> razredi = new LinkedList<>();

        razredi.add("Svi razredi");

        for (Udzbenik udzbenik : Server.SERVER.getUdzbenici()) {

            String razred = udzbenik.getRazred() + ". razred";

            if(!razredi.contains(razred)) razredi.add(razred);

        }

        return FXCollections.observableArrayList(razredi);

    }

    public static ObservableList<String> generisiDodajSmanjiOpcije(){

        ArrayList<String> output = new ArrayList<>();

        output.add("Dodaj primerke");
        output.add("Smanji broj primeraka");

        return FXCollections.observableArrayList(output);

    }

    public static void snimi(String imeFajla){

        try {
            FileWriter fw = new FileWriter(imeFajla, true);

            StringBuilder sb = new StringBuilder();

            for (Izdavac izdavac : FirstView.FIRST_VIEW.getTvIzdavaci().getItems()) {

                for (Udzbenik udzbenik : izdavac.getUdzbenici()) {

                    String autori = "";

                    for (String autor : udzbenik.getAutori()) {

                        autori = autori + "," + autor;

                    }

                    sb.append(udzbenik.getId() + "," + udzbenik.getNaslov() + "," + udzbenik.getRazred() + ". razred,"
                            + udzbenik.getIzdavac().getNaziv().toUpperCase() + autori + "," + udzbenik.getCena() + ","
                            + udzbenik.getBrojPrimeraka() + "\n");

                }
                
            }

            fw.write(sb.toString());
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
