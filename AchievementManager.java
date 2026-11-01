package com.memoryflip.manager;
import java.io.*; import java.nio.file.*; import java.util.*;
public class AchievementManager {
    private final Map<String,Boolean> a=new LinkedHashMap<>(); private final Path file=Path.of(System.getProperty("user.home"),".memoryflip","achievements.txt");
    public AchievementManager(){String[] n={"🏅 First Match","⚡ Speed Master","🧠 Memory Master","🔥 Combo King","💯 Perfect Memory","👑 Ultimate Champion"};for(String s:n)a.put(s,false);load();}
    public boolean unlock(String name){if(a.containsKey(name)&&!a.get(name)){a.put(name,true);save();return true;}return false;}
    public Map<String,Boolean> all(){return Collections.unmodifiableMap(a);}
    private void load(){try{if(Files.exists(file))for(String l:Files.readAllLines(file)){int i=l.indexOf('=');if(i>0&&a.containsKey(l.substring(0,i)))a.put(l.substring(0,i),Boolean.parseBoolean(l.substring(i+1)));}}catch(Exception ignored){}}
    private void save(){try{Files.createDirectories(file.getParent());StringBuilder b=new StringBuilder();a.forEach((k,v)->b.append(k).append('=').append(v).append('\n'));Files.writeString(file,b.toString());}catch(IOException ignored){}}
}