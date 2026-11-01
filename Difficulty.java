package com.memoryflip.model;
public enum Difficulty {
    EASY("Easy",4,4,8), MEDIUM("Medium",4,6,12), HARD("Hard",6,6,18), EXPERT("Expert",6,8,24);
    private final String label; private final int rows, cols, pairs;
    Difficulty(String label,int rows,int cols,int pairs){this.label=label;this.rows=rows;this.cols=cols;this.pairs=pairs;}
    public String label(){return label;} public int rows(){return rows;} public int cols(){return cols;} public int pairs(){return pairs;}
}