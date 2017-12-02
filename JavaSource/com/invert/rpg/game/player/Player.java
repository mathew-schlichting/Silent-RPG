package com.invert.rpg.game.player;

import com.invert.engine.objects.SerializedGameObject;
import java.awt.Graphics2D;

import static com.invert.rpg.common.ImageConstants.PLAYER_SPRITE;


public class Player extends SerializedGameObject {

    private int targetX, targetY;
    private int speed;

    public Player(int id, int x, int y, int width, int height) {
        super(id, x, y, width, height);

        targetX = x;
        targetY = y;

        speed =  7;
    }

    public void setTargetX(int x){ targetX = x; }
    public void setTargetY(int y){
        targetY = y;
    }

    public void moveDelta(int x, int y){
        move(getX()+x, getY()+y);
    }
    public void move(int x, int y){
        setX(x);
        setY(y);
    }


    public void movePlayer(){
        int dx, dy;     // delta x and y
        int x = 0;      // x axis of triangle
        int y = 0;      // y axis of triangle
        int z;          // hypotenoos (hell yeah I spell it like that)
        int mx = 1;     // multiplier for x (1 or -1)
        int my = 1;     // multiplier for y (1 or -1)

        if(targetX != getCenterX() ){
            x = targetX - getCenterX();
            mx = Math.abs(x)/x;
            x = Math.abs(x);
        }
        if(targetY != getCenterY()){
            y = targetY - getCenterY();
            my = Math.abs(y)/y;
            y = Math.abs(y);
        }

        z = Math.max((int) Math.ceil(Math.sqrt((x * x) + (y * y))), 1);

        dx = speed * x / z;
        dy = speed * y / z;


        dx = Math.min(x, dx) * mx;
        dy = Math.min(y, dy) * my;

        moveDelta(dx, dy);
    }


    @Override
    public void tick(){
        super.tick();
        movePlayer();
    }


    @Override
    public void render(Graphics2D g, float v) {
        renderCenter(g, v, PLAYER_SPRITE[getId()]);
    }
}
