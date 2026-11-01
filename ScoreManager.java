package com.memoryflip.manager;
public class ScoreManager {
    private int score,combo,bestCombo;
    public void reset(){score=0;combo=0;bestCombo=0;}
    public void match(){combo=Math.min(5,combo+1);bestCombo=Math.max(bestCombo,combo);score+=100+50*combo;}
    public void wrong(){combo=0;score=Math.max(0,score-25);}
    public void hint(){score=Math.max(0,score-50);}
    public void finish(int seconds,int lives){score+=Math.max(0,1000-seconds*3)+lives*100;}
    public int score(){return score;} public int combo(){return combo;} public int bestCombo(){return bestCombo;}
}