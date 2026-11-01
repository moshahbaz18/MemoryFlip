package com.memoryflip.manager;
import javafx.animation.KeyFrame; import javafx.animation.Timeline; import javafx.util.Duration;
public class TimerManager {
    private int seconds; private Timeline timeline; private Runnable onTick;
    public void start(Runnable tick){stop();seconds=0;onTick=tick;timeline=new Timeline(new KeyFrame(Duration.seconds(1),e->{seconds++;if(onTick!=null)onTick.run();}));timeline.setCycleCount(Timeline.INDEFINITE);timeline.play();}
    public void pause(){if(timeline!=null)timeline.pause();} public void resume(){if(timeline!=null)timeline.play();}
    public void stop(){if(timeline!=null)timeline.stop();} public int seconds(){return seconds;}
    public String text(){return String.format("%02d:%02d",seconds/60,seconds%60);}
}