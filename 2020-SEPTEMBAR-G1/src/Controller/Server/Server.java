package Controller.Server;

import Model.Izdavac;
import Model.Udzbenik;

import java.util.ArrayList;

public class Server {

    public static final Server SERVER = new Server();

    private final ArrayList<Izdavac> izdavaci = new ArrayList<>();

    private final ArrayList<Udzbenik> udzbenici = new ArrayList<>();

    public ArrayList<Izdavac> getIzdavaci() {
        return izdavaci;
    }

    public ArrayList<Udzbenik> getUdzbenici() {
        return udzbenici;
    }

    private Server(){
    }

}
