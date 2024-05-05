package net.mocko.reforged.reforging;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

public class ReforgingGrid {
    //class stores an array of tiles of size width*height
    public int gridWidth = 20;
    public int gridHeight = 12;

    public ReforgingGrid(){
        generateGrid();
    }


    public ReforgingTile[][] grid = new ReforgingTile[gridWidth][gridHeight];

    PerlinSimplexNoise REFORGING_NOISE = new PerlinSimplexNoise(new LegacyRandomSource(4543543),
            ImmutableList.of(3,2,1,0,-1,-2,-3));

    public ReforgingTile generateTilesFromNoise(int gridX, int gridY){
        double noise= REFORGING_NOISE.getValue(gridX,gridY, false);
        if(noise <= 0)
            return new ReforgingTile(TileType.INVALID);
        else
            return new ReforgingTile(TileType.VALID);
    }

    private void generateGrid(){
        for(int j = 0; j < gridHeight; j++)
        {
            for(int i = 0; i < gridWidth; i++){
                grid[i][j] = generateTilesFromNoise(i,j);
            }
        }
    }


    public int getTileColor(int x, int y){
        TileType value = grid[x][y].tileType;
        if (value == TileType.INVALID){
            return 0XFF222222;
        }
        //else if (value == TileType.STARTING){
          //return 0XFFFFFFFF;
        //}
        else return 0XFF888888;
    }

    private void populateGrid(){
        //make a for loop that grabs 2d noise values, asings them to a tile to determine if its valid or not
        //add said tile to the grid array
        return;
    }



}
