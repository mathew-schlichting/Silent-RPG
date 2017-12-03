package com.invert.rpg.game.player.attacks;

import com.invert.engine.objects.GameObject;
import com.invert.engine.objects.SerializedGameObject;
import com.invert.rpg.common.PlayerConstants;

import java.awt.*;

import static com.invert.rpg.common.ImageConstants.tiles;

public class Attack extends SerializedGameObject{

    private PlayerConstants.Type type;
    private int xVel, yVel;

    public Attack(int image, int x, int y, int width, int height, PlayerConstants.Type type, int xVel, int yVel) {
        super(image, x, y, width, height);
        this.type = type;
        this.xVel = xVel;
        this.yVel = yVel;
    }


    public void tick(){
        super.tick();

        setX(getX() + xVel);
        setY(getY() + yVel);
    }


    @Override
    public void render(Graphics2D g, float v) {
        renderScroll(g, v, tiles[getId()]);
    }
}
