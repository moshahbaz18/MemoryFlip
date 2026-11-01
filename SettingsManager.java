package com.memoryflip.manager;
import java.io.*; import java.nio.file.*;
public class SettingsManager {
    private boolean sound=true,music=true,animations=true; private final Path file=Path.of(System.getProperty("user.home"),".memoryflip","settings.txt");
    public SettingsManager(){load();}
    private void load(){try{if(Files.exists(file))for(String s:Files.readAllLines(file)){if(s.startsWith("sound="))sound=Boolean.parseBoolean(s.substring(6));if(s.startsWith("music="))music=Boolean.parseBoolean(s.substring(6));if(s.startsWith("animations="))animations=Boolean.parseBoolean(s.substring(10));}}catch(Exception ignored){}}
    public void save(){try{Files.createDirectories(file.getParent());Files.writeString(file,"sound="+sound+"\nmusic="+music+"\nanimations="+animations+"\n");}catch(IOException ignored){}}
    public boolean sound(){return sound;} public boolean music(){return music;} public boolean animations(){return animations;}
    public void sound(boolean v){sound=v;save();} public void music(boolean v){music=v;save();} public void animations(boolean v){animations=v;save();}
}