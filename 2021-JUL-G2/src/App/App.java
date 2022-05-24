package App;

import Controller.Utils.Utils;
import View.FirstView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Utils.ucitajZaposlene("zaposleni.txt");
        Utils.ucitajZanimanja("zanimanja.txt");
        FirstView.FIRST_VIEW.show();

    }
}
