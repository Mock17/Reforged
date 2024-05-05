package net.mocko.reforged.reforging;

public class ReforgingFollower {

    public int followerX = 0;
    public int followerY = 0;

    public void addPatternCordinates(ReforgingPatterns pattern){
        this.followerX += pattern.getPatternX()*ReforgingTile.tileSize;
        this.followerY += pattern.getPatternY()*ReforgingTile.tileSize;
    }
}
