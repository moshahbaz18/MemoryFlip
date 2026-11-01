package com.memoryflip.controller;
import com.memoryflip.MemoryFlipApp; import com.memoryflip.model.Difficulty;
public class MenuController {
    private final MemoryFlipApp app; public MenuController(MemoryFlipApp a){app=a;}
    public void play(){app.showGame(Difficulty.EASY);} public void difficulty(){app.showGame(Difficulty.MEDIUM);}
    public void how(){app.showHowToPlay();} public void achievements(){app.showAchievements();} public void scores(){app.showScores();}
    public void settings(){app.showSettings();} public void exit(){app.close();}
}