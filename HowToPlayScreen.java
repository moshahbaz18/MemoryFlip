package com.memoryflip.ui;
import com.memoryflip.MemoryFlipApp; import javafx.geometry.*; import javafx.scene.control.*; import javafx.scene.layout.*;
public class HowToPlayScreen extends VBox {
    public HowToPlayScreen(MemoryFlipApp app){setAlignment(Pos.CENTER);setSpacing(16);getStyleClass().add("root");Label t=new Label("HOW TO PLAY");t.getStyleClass().add("title");Label x=new Label("1. Click a card to flip it.\n2. Flip another card.\n3. Find matching pairs.\n4. Match all cards to win.\n5. Use hints carefully (-50 points).\n6. Finish with the highest score.");x.getStyleClass().add("body-text");Button b=new Button("BACK TO MENU");b.setOnAction(e->app.showMenu());getChildren().addAll(t,x,b);}
}