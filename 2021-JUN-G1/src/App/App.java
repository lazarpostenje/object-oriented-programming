package App;

import Controller.Utils.Utils;
import View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Utils.ucitajStudente("studenti1.txt");
        MainView.MAIN_VIEW.show();
    }
}
