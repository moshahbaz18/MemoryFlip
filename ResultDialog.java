package com.memoryflip.ui;
import javafx.geometry.*; import javafx.scene.Scene; import javafx.scene.control.*; import javafx.scene.layout.*; import javafx.stage.*;
public class ResultDialog extends Stage {
    public ResultDialog(String title,String body,Runnable again,Runnable menu){
        initModality(Modality.APPLICATION_MODAL);setTitle(title);VBox b=new VBox(18);b.setAlignment(Pos.CENTER);b.getStyleClass().add("dialog-box");
        Label t=new Label(title);t.getStyleClass().add("title");Label x=new Label(body);x.getStyleClass().add("result-text");Button a=new Button("PLAY AGAIN");a.setOnAction(e->{close();again.run();});Button m=new Button("MAIN MENU");m.setOnAction(e->{close();menu.run();});b.getChildren().addAll(t,x,a,m);Scene s=new Scene(b,520,420);s.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());setScene(s);
    }
}