package com.memoryflip.util;
import javafx.animation.*; import javafx.scene.Node; import javafx.util.Duration;
public final class AnimationUtil {
    private AnimationUtil(){}
    public static void pop(Node n){ScaleTransition s=new ScaleTransition(Duration.millis(160),n);s.setFromX(.92);s.setFromY(.92);s.setToX(1);s.setToY(1);s.play();}
    public static void shake(Node n){TranslateTransition t=new TranslateTransition(Duration.millis(55),n);t.setFromX(-5);t.setToX(5);t.setCycleCount(6);t.setAutoReverse(true);t.play();}
    public static void fade(Node n){FadeTransition f=new FadeTransition(Duration.millis(280),n);f.setFromValue(0);f.setToValue(1);f.play();}
}