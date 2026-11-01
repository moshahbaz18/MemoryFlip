package com.memoryflip.model;

public class Card {
    private final int id;
    private final String symbol;
    private boolean faceUp, matched;
    public Card(int id,String symbol){this.id=id;this.symbol=symbol;}
    public int getId(){return id;} public String getSymbol(){return symbol;}
    public boolean isFaceUp(){return faceUp;} public boolean isMatched(){return matched;}
    public void flipUp(){if(!matched)faceUp=true;} public void flipDown(){if(!matched)faceUp=false;}
    public void setMatched(boolean value){matched=value;if(value)faceUp=true;}
}