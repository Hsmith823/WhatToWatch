package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WhatToWatch extends Application {

    private int sceneWidth = 800;
    private int sceneHeight = 400;

    // method to display logo
    public ImageView logo(){
        Image logo = new Image("src/files/logo.png");
        return new ImageView(logo);
    }

    private Scene home(Stage stage){
        // set stage title
        stage.setTitle("What To Watch");
        // set title to be displayed on the scene
        Text homeTitle = new Text("Select Movie or TV Series");
        homeTitle.setFont(Font.font("Verdana",30));
        // button for movies
        Button movieBtn = new Button("Movies");
        // button for tv series
        Button tvBtn = new Button("TV Series");
        // button horizontal display
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(movieBtn,tvBtn);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        // main VBox configuration
        VBox vBox = new VBox();
        vBox.getChildren().addAll(homeTitle,buttonBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setSpacing(10);
        // scroll bar
        ScrollPane scroll = new ScrollPane(vBox);
        scroll.setFitToWidth(true);
        Scene scene = new Scene(scroll,sceneWidth,sceneHeight);
        scene.getStylesheets().add("files/style.css");
        return scene;
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setScene(home(stage));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
