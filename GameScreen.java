package com.memoryflip.ui;
import com.memoryflip.MemoryFlipApp; import com.memoryflip.controller.GameController; import com.memoryflip.model.Card; import com.memoryflip.util.AnimationUtil;
import javafx.animation.PauseTransition; import javafx.geometry.*; import javafx.scene.control.*; import javafx.scene.layout.*; import javafx.util.Duration; import java.util.*;

public class GameScreen extends BorderPane {
    private final MemoryFlipApp app; private final GameController c; private final GridPane grid=new GridPane(); private final Label stats=new Label(); private final StackPane center=new StackPane(); private StackPane pause;
    public GameScreen(MemoryFlipApp a,GameController gc){app=a;c=gc;c.attach(this);getStyleClass().add("root");build(); }
    private void build(){
        Label title=new Label("MEMORY FLIP");title.getStyleClass().add("small-title");
        stats.getStyleClass().add("stats");HBox top=new HBox(24,title,stats);top.setAlignment(Pos.CENTER_LEFT);top.getStyleClass().add("topbar");
        Button pauseBtn=new Button("Ⅱ Pause");pauseBtn.setOnAction(e->c.pause());Button restart=new Button("↻ Restart");restart.setOnAction(e->c.restart());Button hint=new Button("💡 Hint");hint.setOnAction(e->c.hint());Button menu=new Button("⌂ Menu");menu.setOnAction(e->c.menu());
        Region sp=new Region();HBox.setHgrow(sp,Priority.ALWAYS);top.getChildren().addAll(sp,pauseBtn,restart,hint,menu);setTop(top);
        center.getChildren().add(grid);setCenter(center);grid.getStyleClass().add("card-grid");grid.setAlignment(Pos.CENTER);grid.setHgap(12);grid.setVgap(12);BorderPane.setMargin(center,new Insets(18));
    }
    public void buildBoard(List<Card> deck){grid.getChildren().clear();for(int i=0;i<deck.size();i++){Card card=deck.get(i);Button b=cardButton(card);grid.add(b,i%c.difficulty().cols(),i/c.difficulty().cols());}}
    private Button cardButton(Card card){Button b=new Button();b.getStyleClass().add("memory-card");b.setPrefSize(110,110);b.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);b.setText(card.isFaceUp()?card.getSymbol():"✦");b.getStyleClass().add(card.isMatched()?"matched":"");b.setOnAction(e->c.choose(card));return b;}
    public void refresh(){buildBoard(c.deckSnapshot());stats.setText("⭐ "+c.score().score()+"    🎯 "+c.moves()+"    🔥 ×"+c.score().combo()+"    ❤️ "+c.lives()+"    ⏱ "+c.timer().text());}
    public void mismatch(Card a,Card b,Runnable after){refresh();PauseTransition p=new PauseTransition(Duration.millis(850));p.setOnFinished(e->after.run());p.play();}
    public void highlight(Card a,Card b){a.flipUp();b.flipUp();refresh();PauseTransition p=new PauseTransition(Duration.millis(700));p.setOnFinished(e->{a.flipDown();b.flipDown();refresh();});p.play();}
    public void showPause(){if(pause!=null)return;pause=new StackPane();pause.getStyleClass().add("overlay");VBox box=new VBox(15);box.setAlignment(Pos.CENTER);Label l=new Label("GAME PAUSED");l.getStyleClass().add("title");Button r=new Button("RESUME");r.setOnAction(e->c.resume());Button re=new Button("RESTART");re.setOnAction(e->{pause=null;c.restart();});Button m=new Button("MAIN MENU");m.setOnAction(e->c.menu());box.getChildren().addAll(l,r,re,m);pause.getChildren().add(box);center.getChildren().add(pause);}
    public void hidePause(){if(pause!=null){center.getChildren().remove(pause);pause=null;}}
    public void showWin(boolean high){new ResultDialog("🎉 YOU WIN! 🎉","Score: "+c.score().score()+"\nTime: "+c.timer().text()+"\nMoves: "+c.moves()+"\nBest Combo: ×"+c.score().bestCombo()+(high?"\n\n🏆 NEW HIGH SCORE!":""),()->c.restart(),()->app.showMenu()).show();}
    public void showGameOver(){new ResultDialog("GAME OVER","Your Score: "+c.score().score()+"\nMoves: "+c.moves()+"\nTime: "+c.timer().text(),()->c.restart(),()->app.showMenu()).show();}
}