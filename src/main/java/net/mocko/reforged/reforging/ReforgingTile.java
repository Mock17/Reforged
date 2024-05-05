package net.mocko.reforged.reforging;

public class ReforgingTile {
    public static int tileSize = 8; //tile's side size, tiles are square


    public TileType tileType;
    public int tileX;
    public int tileY;

    ReforgingTile(TileType type)
    {
        this.tileType = type;
    }
}


enum TileType {
    VALID,INVALID,ENCHANTED
};
