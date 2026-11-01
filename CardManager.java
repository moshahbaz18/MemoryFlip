package com.memoryflip.manager;

import com.memoryflip.model.*;
import java.util.*;

public class CardManager {
    private static final String[] SYMBOLS={"🍎","🍕","🚀","🐱","🦊","🌟","🎮","⚽","🎵","🦄","🌈","🔥","🌙","🍀","💎","👑","🎯","🧩","🛸","🐼","🎲","🍩","🌸","🦁"};
    public List<Card> create(Difficulty d){
        List<Card> cards=new ArrayList<>(); int id=0;
        for(int i=0;i<d.pairs();i++){String s=SYMBOLS[i%SYMBOLS.length];cards.add(new Card(id++,s));cards.add(new Card(id++,s));}
        Collections.shuffle(cards); return cards;
    }
}