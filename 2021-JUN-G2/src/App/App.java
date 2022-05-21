package App;

import Controller.Utils.Utils;
import View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Utils.ucitajMapuUcionica("ucionice2.txt");
        Utils.ucitajRaspored("raspored2.txt");
        MainView.MAIN_VIEW.show();
    }
}
