package Controller.Server;

import Model.Student;
import Model.Ucionica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Server {

    public static final Server SERVER = new Server();

    private final ArrayList<Student> studenti = new ArrayList<>();

    private final LinkedHashMap<String, ArrayList<Ucionica>> termini = new LinkedHashMap<>();

    private Server() {}

    public ArrayList<Student> getStudenti() {
        return studenti;
    }

    public HashMap<String, ArrayList<Ucionica>> getTermini() {
        return termini;
    }
}
