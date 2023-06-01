package com.view.advanced_code;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import viewmodel.ViewModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Main extends Application {
//    @Override
//    public void start(Stage primaryStage) {
//        try {
//            FXMLLoader fxl = new FXMLLoader();
//            BorderPane root = fxl.load(getClass().getResource("Window.fxml").openStream());
//            Model m = new Model("properties.txt");
//            WindowController wc = fxl.getController();	//View
//            ViewModel vm = new ViewModel(m);
//            wc.init(vm);
//            wc.paint();
//
//            Scene scene = new Scene(root, 400, 400);
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setTitle("Hello!");
        //stage.setScene(scene);
        //stage.show();
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("MyBoard.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load(), 320, 240);
        stage.setTitle("MyBoard");
        stage.setScene(scene2);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

