package treningsdagbokApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Treningsdagbok extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TreningsdagbokView.fxml"));
        primaryStage.setTitle("Treningsdagbok");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
    }

    public static void main(String[] args) {
/*
        LagApparatCtrl apparatCtrl = new LagApparatCtrl();
        apparatCtrl.lagApparat("Vektstativ","Stativ som holder vektstenger");
        apparatCtrl.fullf�rApparat();


        Lag�velseCtrl �velseCtrl = new Lag�velseCtrl();
        �velseCtrl.lag�velse("Kneb�y","Sett ut rumpa og la det st� til", 92, 5,3);
        �velseCtrl.fullf�r�velse();


*/

    launch(args);

    }
}
