package com.memoryflip.manager;
import java.io.*; import java.nio.file.*; import java.time.*; import java.util.*;
public class HighScoreManager {
    public record Entry(String player,int score,String difficulty,String time,int moves,String date){}
    private final Path file=Path.of(System.getProperty("user.home"),".memoryflip","scores.txt"); private final List<Entry> entries=new ArrayList<>();
    public HighScoreManager(){load();}
    public void add(String p,int s,String d,String t,int m){entries.add(new Entry(p,s,d,t,m,LocalDate.now().toString()));entries.sort(Comparator.comparingInt(Entry::score).reversed());if(entries.size()>10)entries.subList(10,entries.size()).clear();save();}
    public List<Entry> entries(){return List.copyOf(entries);}
    public boolean isHighScore(int s){return entries.size()<10||entries.get(entries.size()-1).score()<s;}
    public void reset(){entries.clear();save();}
    private void load(){try{if(Files.exists(file))for(String l:Files.readAllLines(file)){String[] x=l.split("\\|",-1);if(x.length>=6)entries.add(new Entry(x[0],Integer.parseInt(x[1]),x[2],x[3],Integer.parseInt(x[4]),x[5]));}entries.sort(Comparator.comparingInt(Entry::score).reversed());}catch(Exception ignored){}}
    private void save(){try{Files.createDirectories(file.getParent());StringBuilder b=new StringBuilder();for(Entry e:entries)b.append(e.player()).append('|').append(e.score()).append('|').append(e.difficulty()).append('|').append(e.time()).append('|').append(e.moves()).append('|').append(e.date()).append('\n');Files.writeString(file,b.toString());}catch(IOException ignored){}}
}