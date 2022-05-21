package Controller.Server;

import Model.Student;
import Model.Ucionica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Server {

    public static final Server SERVER = new Server();

    private final ArrayList<Student> studenti = new ArrayList<>();

    private final ArrayList<Ucionica> ucionice = new ArrayList<>();

    private final LinkedHashMap<String, Integer> mapaUcionica = new LinkedHashMap<>();

    public ArrayList<Student> getStudenti() {
        return studenti;
    }

    public ArrayList<Ucionica> getUcionice() {
        return ucionice;
    }

    public HashMap<String, Integer> getMapaUcionica() {
        return mapaUcionica;
    }

    private Server(){
    }

}
