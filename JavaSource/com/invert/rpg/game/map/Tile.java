package com.invert.rpg.game.map;

import com.invert.engine.objects.SerializedGameObject;
import com.invert.rpg.common.ImageConstants;

import java.awt.*;

import static com.invert.rpg.common.ImageConstants.PLAYER_SPRITE;
import static com.invert.rpg.common.ImageConstants.tiles;
import static com.invert.rpg.common.MapConstants.TILE_SIZE;


/**
 * Created by Mathew on 11/24/2017.
 */
public class Tile extends SerializedGameObject {

    public Tile(int id, int x, int y){
        super(id, x, y, TILE_SIZE, TILE_SIZE);
    }


    public boolean isSolid(){
        return true;
    }

    @Override
    public void render(Graphics2D g,  float v){
        super.renderScroll(g, v, tiles[getId()]);
    }
}
