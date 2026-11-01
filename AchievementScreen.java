package com.memoryflip.ui;
import com.memoryflip.MemoryFlipApp; import com.memoryflip.manager.AchievementManager; import javafx.geometry.*; import javafx.scene.control.*; import javafx.scene.layout.*;
public class AchievementScreen extends VBox {
    public AchievementScreen(MemoryFlipApp app,AchievementManager a){setAlignment(Pos.TOP_CENTER);setSpacing(15);getStyleClass().add("root");setPadding(new Insets(40));Label t=new Label("ACHIEVEMENTS");t.getStyleClass().add("title");VBox list=new VBox(10);a.all().forEach((k,v)->{Label l=new Label((v?"✓ ":"🔒 ")+k);l.getStyleClass().add("achievement");list.getChildren().add(l);});Button b=new Button("BACK");b.setOnAction(e->app.showMenu());getChildren().addAll(t,list,b);}
}