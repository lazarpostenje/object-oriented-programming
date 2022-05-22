package Controller.Server;

import Model.Transakcija;

import java.util.ArrayList;

public class Server {

    public static final Server SERVER = new Server();

    private final ArrayList<Transakcija> transakcije = new ArrayList<>();

    private Server(){
    }

    public ArrayList<Transakcija> getTransakcije() {
        return transakcije;
    }
}
