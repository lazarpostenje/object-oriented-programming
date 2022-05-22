package Controller.Utils;

import Controller.Server.Server;
import Model.Isplata;
import Model.Transakcija;
import Model.Uplata;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Utils {

    public static void ucitajTransakcije(String imeFajla){

        File file = new File(imeFajla);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            while((line = br.readLine()) != null){

                String[] podaci = line.split(";");

                Transakcija transakcija = null;

                if(podaci.length == 4){ // isplata

                    transakcija = new Isplata(Integer.parseInt(podaci[0]), podaci[2], podaci[1], podaci[3]);


                } else if(podaci.length == 3){ // uplata

                    transakcija = new Uplata(Integer.parseInt(podaci[0]), podaci[2], podaci[1]);

                }

                if(transakcija == null) continue;

                Server.SERVER.getTransakcije().add(transakcija);

            }

            System.out.println(Server.SERVER.getTransakcije());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ObservableList<String> generisiKategorije(ObservableList<Transakcija> transakcije){

        ArrayList<String> output = new ArrayList<>();

        for (Transakcija transakcija : transakcije) {

            if(transakcija instanceof Isplata){

                if(!output.contains(((Isplata)transakcija).getKategorija())) output.add(((Isplata)transakcija).getKategorija());

            }

        }

        return FXCollections.observableArrayList(output);

    }

    public static int minIsplata(ObservableList<Transakcija> transakcije){

        int min = Integer.MAX_VALUE;

        for (Transakcija transakcija : transakcije) {

            if(transakcija instanceof Isplata){

                int iznos = ((Isplata)transakcija).getIznos();

                if(iznos < min) min = iznos;

            }

        }

        return min;

    }

    public static int maxIsplata(ObservableList<Transakcija> transakcije){

        int max = Integer.MIN_VALUE;

        for (Transakcija transakcija : transakcije) {

            if(transakcija instanceof Isplata){

                int iznos = ((Isplata)transakcija).getIznos();

                if(iznos > max) max = iznos;

            }

        }

        return max;

    }

    public static ObservableList<String> generisiAnalitiku(ObservableList<Transakcija> transakcije){

        ObservableList<String> kategorije = Utils.generisiKategorije(transakcije);

        ArrayList<String> output = new ArrayList<>();

        for (String kategorija : kategorije) {

            int placanja = 0;
            int zbirIznos = 0;

            for (Transakcija transakcija : transakcije) {

                if(transakcija instanceof Isplata){

                    if(kategorija.equals(((Isplata) transakcija).getKategorija())){

                        zbirIznos += ((Isplata)transakcija).getIznos();
                        placanja++;

                    }

                }

            }

            StringBuilder sb = new StringBuilder();

            sb.append(kategorija).append(" (").append(placanja).append(" placanja): ").append(zbirIznos).append(" RSD");

            output.add(sb.toString());

        }

        return FXCollections.observableArrayList(output);

    }

    public static void snimiUplate(ObservableList<Transakcija> transakcije, String imeFajla){

        try {
            FileWriter fw = new FileWriter(imeFajla, true);

            StringBuilder sb = new StringBuilder();

            int zbir = 0;

            for (Transakcija transakcija : transakcije) {

                if(transakcija instanceof Uplata){

                    Uplata uplata = ((Uplata)transakcija);

                    sb.append(uplata.getIznos() + ";" + uplata.getUplatilac() + ";" + uplata.getDatum() + "\n");
                    zbir += uplata.getIznos();

                }

            }

            sb.append(zbir + "\n");

            fw.write(sb.toString());
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void snimiIsplate(ObservableList<Transakcija> transakcije, String imeFajla){

        try {
            FileWriter fw = new FileWriter(imeFajla, true);

            StringBuilder sb = new StringBuilder();

            int zbir = 0;

            for (Transakcija transakcija : transakcije) {

                if(transakcija instanceof Isplata){

                    Isplata isplata = ((Isplata)transakcija);

                    sb.append(isplata.getIznos() + ";" + isplata.getPrimalac() + ";" + isplata.getDatum() + ";" + isplata.getKategorija() + "\n");
                    zbir += isplata.getIznos();

                }

            }

            sb.append(zbir + "\n");

            fw.write(sb.toString());
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
