package Controller.Utils;

import Controller.Server.Server;
import Model.Zaposleni;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Utils {

    public static void ucitajZaposlene(String imeFajla){

        File file = new File(imeFajla);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            String zanimanje = "";

            while((line = br.readLine()) != null){

                if(line.equals("")) continue;

                if(!line.contains(",")){

                    zanimanje = line;
                    continue;

                }

                String[] podaci = line.split(",");

                if(podaci.length == 4){

                    Zaposleni z = new Zaposleni(podaci[0], podaci[1], podaci[2], Integer.parseInt(podaci[3]), zanimanje);
                    Server.SERVER.getZaposleni().add(z);

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void ucitajZanimanja(String imeFajla){

        File file = new File(imeFajla);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";


            while((line = br.readLine()) != null){

                String[] podaci = line.split(",");

                Server.SERVER.getZanimanja().put(podaci[0], Double.parseDouble(podaci[1]));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ObservableList<String> generisiZanimanja(boolean svePozicije){

        ArrayList<String> zanimanja = new ArrayList<>();

        if(svePozicije) zanimanja.add("Sve pozicije");

        zanimanja.addAll(Server.SERVER.getZanimanja().keySet());

        return FXCollections.observableArrayList(zanimanja);

    }

    public static void snimi(String imeFajla){

        try {
            FileWriter fw = new FileWriter(imeFajla, true);

            StringBuilder sb = new StringBuilder();

            for (String zanimanje : Server.SERVER.getZanimanja().keySet()) {

                sb.append(zanimanje + "\n");

                for (Zaposleni zaposleni : Server.SERVER.getZaposleni()) {

                    if(zaposleni.getZanimanje().equals(zanimanje)) sb.append(zaposleni.getIme() + "," + zaposleni.getPrezime() + "," + zaposleni.getJmbg() + "," + zaposleni.getGodinaZaposlenja() + "\n");

                }

            }
            fw.write(sb.toString());
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
