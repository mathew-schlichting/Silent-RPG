package com.invert.rpg.game.map;

import com.invert.engine.objects.GameObjectI;

import java.awt.*;

import static com.invert.rpg.common.MapConstants.BLACK;
import static com.invert.rpg.common.MapConstants.TILE_SIZE;

/**
 * Created by Mathew on 11/24/2017.
 */
public class Map implements GameObjectI{

    private Tile[][] tile;

    public Map(String map) {
        tile = new Tile[20][20];

        for(int i=0;i<tile.length;i++){
            for(int j=0;j<tile[i].length;j++){
                tile[i][j] = new Tile(BLACK, i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

    }

    public Tile[][] loadMap(String map){
        return null;
    }



    public void tick() {
        for(int i=0;i<tile.length;i++){
            for(int j=0;j<tile[i].length;j++){
                tile[i][j].tick();
            }
        }
    }

    public void render(Graphics2D g, float v) {
        for(int i=0;i<tile.length;i++){
            for(int j=0;j<tile[i].length;j++){
                tile[i][j].render(g, v);
            }
        }
    }
}
