package com.memoryflip.ui;
import com.memoryflip.MemoryFlipApp; import com.memoryflip.controller.SettingsController; import javafx.geometry.*; import javafx.scene.control.*; import javafx.scene.layout.*;
public class SettingsScreen extends VBox {
    public SettingsScreen(MemoryFlipApp app,SettingsController c){setAlignment(Pos.TOP_CENTER);setSpacing(18);getStyleClass().add("root");setPadding(new Insets(50));
        Label t=new Label("SETTINGS");t.getStyleClass().add("title");CheckBox sound=new CheckBox("Sound ON/OFF");sound.setSelected(c.settings().sound());sound.setOnAction(e->c.sound(sound.isSelected()));
        CheckBox music=new CheckBox("Music ON/OFF");music.setSelected(c.settings().music());music.setOnAction(e->c.settings().music(music.isSelected()));
        CheckBox anim=new CheckBox("Animations ON/OFF");anim.setSelected(c.settings().animations());anim.setOnAction(e->c.settings().animations(anim.isSelected()));
        Button reset=new Button("RESET HIGH SCORES");reset.setOnAction(e->c.resetScores());Button back=new Button("BACK");back.setOnAction(e->app.showMenu());getChildren().addAll(t,sound,music,anim,reset,back);
    }
}