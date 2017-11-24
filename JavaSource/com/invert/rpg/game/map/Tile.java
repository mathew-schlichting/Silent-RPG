package com.invert.rpg.game.map;

import com.invert.engine.objects.SerializedGameObject;
import com.invert.rpg.common.ImageConstants;

import java.awt.*;


/**
 * Created by Mathew on 11/24/2017.
 */
public class Tile extends SerializedGameObject {

    public Tile(int image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
    }


    @Override
    public void render(Graphics2D g, float v) {
        renderScroll(g, v, ImageConstants.tiles[getId()]);
    }
}
