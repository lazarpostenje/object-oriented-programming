package Controller.Utils;

import Controller.Server.Server;
import Model.Smer;
import Model.Student;
import Model.Ucionica;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Utils {

    public static boolean isNumeric(String string){

        try {

            Integer.parseInt(string);
            return true;

        } catch(Exception e){

            return false;

        }

    }

    public static void ucitajStudente(String imeFajla){

        File file = new File(imeFajla);

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            while((line = br.readLine()) != null){

                String[] podaci = line.split(",");

                Student s = new Student(Smer.valueOf(podaci[0]), Integer.parseInt(podaci[1]),
                        Integer.parseInt(podaci[2]), podaci[3], podaci[4]);

                Server.SERVER.getStudenti().add(s);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Ucionica> ucitajUcionice(String imeFajla, boolean samoSaRacunarima){

        File file = new File(imeFajla);

        ArrayList<Ucionica> output = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            while((line = br.readLine()) != null){

                String[] podaci = line.split("-");

                boolean amfiteatar = false;
                boolean racunari = false;

                if(samoSaRacunarima && podaci.length == 2 && podaci[1].equals("R")){

                    racunari = true;
                    Ucionica s = new Ucionica(podaci[0], amfiteatar, racunari);
                    output.add(s);

                } else if(!samoSaRacunarima){

                    if(podaci.length == 2){

                        if(podaci[1].equals("A")) amfiteatar = true;
                        else if(podaci[1].equals("R")) racunari = true;

                    }

                    Ucionica s = new Ucionica(podaci[0], amfiteatar, racunari);
                    output.add(s);

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<String> generisiTermine(){

        ArrayList<String> output = new ArrayList<>();

        for (String s : Server.SERVER.getTermini().keySet()) {

            output.add(s);

        }

        return output;

    }

    public static void ispis(String imeFajla, ObservableList<Student> rasporedjeni){

        try {
            StringBuilder sb = new StringBuilder();
            FileWriter fw = new FileWriter(imeFajla, true);

            for (Student student : rasporedjeni) {

                sb.append(student.toString());
                sb.append(" " + student.getTermin() + " " + student.getUcionica().getNaziv() + "\n");

            }

            fw.write(sb.toString());
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
