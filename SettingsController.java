package com.memoryflip.controller;
import com.memoryflip.manager.*;
public class SettingsController {
    private final SettingsManager settings; private final HighScoreManager scores; private final SoundManager sound;
    public SettingsController(SettingsManager s,HighScoreManager h,SoundManager sm){settings=s;scores=h;sound=sm;}
    public SettingsManager settings(){return settings;} public void resetScores(){scores.reset();} public void sound(boolean v){settings.sound(v);sound.enabled(v);}
}