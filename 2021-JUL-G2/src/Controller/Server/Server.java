package Controller.Server;

import Model.Zaposleni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Server {

    public static final Server SERVER = new Server();

    private final ArrayList<Zaposleni> zaposleni = new ArrayList<>();

    private final LinkedHashMap<String, Double> zanimanja = new LinkedHashMap<>();

    public ArrayList<Zaposleni> getZaposleni() {
        return zaposleni;
    }

    public HashMap<String, Double> getZanimanja() {
        return zanimanja;
    }

    private Server(){}

}
