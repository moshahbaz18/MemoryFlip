package com.memoryflip.controller;

import com.memoryflip.MemoryFlipApp;
import com.memoryflip.manager.*;
import com.memoryflip.model.*;
import com.memoryflip.ui.GameScreen;
import javafx.application.Platform;
import java.util.*;

public class GameController {
    private final MemoryFlipApp app; private final Difficulty difficulty; private final HighScoreManager scores; private final AchievementManager achievements; private final SettingsManager settings; private final SoundManager sound;
    private final CardManager cards=new CardManager(); private final ScoreManager score=new ScoreManager(); private final TimerManager timer=new TimerManager();
    private List<Card> deck; private Card first,second; private int moves,lives=3; private boolean locked; private GameScreen view;
    public GameController(MemoryFlipApp a,Difficulty d,HighScoreManager h,AchievementManager am,SettingsManager sm,SoundManager s){app=a;difficulty=d;scores=h;achievements=am;settings=sm;sound=s;}
    public void attach(GameScreen v){view=v;}
    public void start(){deck=cards.create(difficulty);score.reset();moves=0;lives=3;locked=false;first=second=null;if(view!=null)view.buildBoard(deck);timer.start(()->Platform.runLater(()->view.refresh()));}
    public void restart(){start();}
    public void choose(Card c){
        if(locked||c.isMatched()||c.isFaceUp())return;
        c.flipUp();sound.play("flip");view.refresh();
        if(first==null){first=c;achievements.unlock("🏅 First Match");return;}
        second=c;moves++;locked=true;
        if(first.getSymbol().equals(second.getSymbol())){
            first.setMatched(true);second.setMatched(true);score.match();achievements.unlock("🔥 Combo King");
            view.refresh();locked=false;first=second=null;
            if(deck.stream().allMatch(Card::isMatched))win();
        }else{
            score.wrong();lives--;view.refresh();
            view.mismatch(first,second,()->{first.flipDown();second.flipDown();first=second=null;locked=false;view.refresh();if(lives<=0)gameOver();});
        }
    }
    public void hint(){if(locked)return;score.hint();Optional<Card> a=deck.stream().filter(c->!c.isMatched()).findFirst();if(a.isEmpty())return;Card x=a.get();Card y=deck.stream().filter(c->!c.isMatched()&&c.getSymbol().equals(x.getSymbol())&&c!=x).findFirst().orElse(null);if(y!=null)view.highlight(x,y);}
    private void win(){timer.stop();score.finish(timer.seconds(),lives);if(difficulty==Difficulty.HARD)achievements.unlock("🧠 Memory Master");if(difficulty==Difficulty.EXPERT)achievements.unlock("👑 Ultimate Champion");if(timer.seconds()<60)achievements.unlock("⚡ Speed Master");if(lives==3)achievements.unlock("💯 Perfect Memory");boolean high=scores.isHighScore(score.score());scores.add("Player",score.score(),difficulty.label(),timer.text(),moves);view.showWin(high);}
    private void gameOver(){timer.stop();view.showGameOver();}
    public List<Card> deckSnapshot(){return List.copyOf(deck);} public Difficulty difficulty(){return difficulty;} public int moves(){return moves;} public int lives(){return lives;} public ScoreManager score(){return score;} public TimerManager timer(){return timer;}
    public void pause(){timer.pause();locked=true;view.showPause();}
    public void resume(){timer.resume();locked=false;view.hidePause();}
    public void menu(){timer.stop();app.showMenu();}
}