package Controller.Utils;

import Controller.Server.Server;
import Model.Smer;
import Model.Student;
import Model.Ucionica;
import View.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Utils {

    public static void ucitajMapuUcionica(String imeFajla){

        File file = new File(imeFajla);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            while((line = br.readLine()) != null){

                String[] podaci = line.split("-");

                Server.SERVER.getMapaUcionica().put(podaci[0], Integer.parseInt(podaci[1]));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void ucitajRaspored(String imeFajla){

        File file = new File(imeFajla);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            while((line = br.readLine()) != null){

                String[] podaci = line.split(",");

                Student student = new Student(podaci[4], podaci[3], Smer.valueOf(podaci[0]), Integer.parseInt(podaci[1]), Integer.parseInt(podaci[2]), Integer.parseInt(podaci[5]), podaci[6]);

                Ucionica ucionica = new Ucionica(podaci[6], Server.SERVER.getMapaUcionica().get(podaci[6]), Integer.parseInt(podaci[5]));

                ucionica.getStudenti().add(student);

                if(!Server.SERVER.getUcionice().contains(ucionica)) Server.SERVER.getUcionice().add(ucionica);
                else {

                    for (Ucionica ucionicaIzServera : Server.SERVER.getUcionice()) {

                        if(ucionica.equals(ucionicaIzServera)) ucionicaIzServera.getStudenti().add(student);

                    }

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ObservableList<String> generisiUcioniceZaListView(){

        ArrayList<String> output = new ArrayList();

        for (Map.Entry<String, Integer> stringIntegerEntry : Server.SERVER.getMapaUcionica().entrySet()) {

            output.add(stringIntegerEntry.getKey() + " broj mesta: " + stringIntegerEntry.getValue());

        }

        return FXCollections.observableArrayList(output);

    }

    public static ObservableList<Integer> generisiTermine(){

        ArrayList<Integer> output = new ArrayList<>();

        for (Ucionica ucionicaIzTabele :  MainView.MAIN_VIEW.getTvUcionice().getItems()) {

            if(!output.contains(ucionicaIzTabele.getTermin())) output.add(ucionicaIzTabele.getTermin());
            
        }

        output.sort(Comparator.naturalOrder());

        return FXCollections.observableArrayList(output);

    }

    public static ObservableList<Student> generisiListuZaStampanje(ObservableList<Ucionica> ucionice){

        ArrayList<Student> studenti = new ArrayList<>();

        for (Ucionica ucionica : ucionice) {

            studenti.addAll(ucionica.getStudenti());

        }

        studenti.sort(null);

        return FXCollections.observableArrayList(studenti);

    }

    public static void ispisUFajl(String imeFajla, ObservableList<Student> studenti){

        try {
            FileWriter fw = new FileWriter(imeFajla, true);

            StringBuilder sb = new StringBuilder();

            for (Student student : studenti) {

                sb.append(student.getSmer() + "," + student.getBrojUpisa() + "," + student.getGodinaUpisa() + ","
                + student.getPrezime() + "," + student.getIme() + "," + student.getTermin() + "," + student.getUcionica() + "\n");

            }

            fw.write(sb.toString());
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
