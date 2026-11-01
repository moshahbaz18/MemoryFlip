package com.memoryflip.manager;
import javafx.scene.media.AudioClip;
public class SoundManager {
    private boolean enabled=true;
    public void enabled(boolean v){enabled=v;} public boolean enabled(){return enabled;}
    public void play(String name){if(!enabled)return;try{var u=getClass().getResource("/sounds/"+name+".wav");if(u!=null)new AudioClip(u.toExternalForm()).play();}catch(Exception ignored){}}
}