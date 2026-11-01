package com.memoryflip.ui;
import com.memoryflip.MemoryFlipApp; import com.memoryflip.controller.MenuController; import com.memoryflip.util.AnimationUtil; import javafx.geometry.*; import javafx.scene.control.*; import javafx.scene.layout.*;
public class MainMenu extends StackPane {
    public MainMenu(MemoryFlipApp app,MenuController c){
        getStyleClass().add("root"); VBox box=new VBox(14);box.setAlignment(Pos.CENTER);box.setMaxWidth(520);
        Label title=new Label("MEMORY FLIP");title.getStyleClass().add("title");Label sub=new Label("MATCH • REMEMBER • CONQUER");sub.getStyleClass().add("subtitle");
        Button play=btn("▶  PLAY GAME",c::play);Button diff=btn("◆  SELECT DIFFICULTY",c::difficulty);Button how=btn("？  HOW TO PLAY",c::how);Button ach=btn("🏆  ACHIEVEMENTS",c::achievements);Button high=btn("📊  HIGH SCORES",c::scores);Button set=btn("⚙  SETTINGS",c::settings);Button exit=btn("✕  EXIT",c::exit);
        box.getChildren().addAll(title,sub,play,diff,how,ach,high,set,exit);getChildren().add(box);AnimationUtil.fade(box);
    }
    private Button btn(String t,Runnable r){Button b=new Button(t);b.getStyleClass().add("menu-button");b.setOnAction(e->r.run());return b;}
}