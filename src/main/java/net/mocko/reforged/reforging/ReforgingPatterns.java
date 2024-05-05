package net.mocko.reforged.reforging;

public enum ReforgingPatterns {

    EMPTY(0,0),
    UP(0,2),
    DOWN(0,-2),
    LEFT(-2,0),
    RIGHT(2,0);

    private int patternX;
    private int patternY;

    ReforgingPatterns(int x, int y){
        this.patternX = x;
        this.patternY = y;
    }

    public int getPatternY() {
        return patternY;
    }

    public int getPatternX() {
        return patternX;
    }

}

