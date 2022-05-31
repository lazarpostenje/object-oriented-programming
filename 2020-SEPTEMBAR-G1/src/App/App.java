package App;

import Controller.Server.Server;
import Controller.Utils.Utils;
import View.FirstView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Utils.ucitaj("udzbenici-prvitermin.txt");
        FirstView.FIRST_VIEW.show();
    }
}
