package com.invert.rpg.game.player;

import com.invert.engine.objects.SerializedGameObject;
import com.invert.rpg.common.PlayerConstants;
import com.invert.rpg.game.player.attacks.Attack;

import java.awt.Graphics2D;
import java.util.ArrayList;

import static com.invert.rpg.common.ImageConstants.PLAYER_SPRITE;
import static com.invert.rpg.common.InputConstants.SPELL_KEYS;


public class Player extends SerializedGameObject {

    private int targetX, targetY;
    private int speed;
    private ArrayList<Attack> attacks;

    public Player(int id, int x, int y, int width, int height) {
        super(id, x, y, width, height);

        targetX = x;
        targetY = y;

        speed =  10;

        attacks = new ArrayList<>();
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


    public void move(){
        int dx, dy;     // delta x and y
        double x = 0;      // x axis of triangle
        double y = 0;      // y axis of triangle
        double z;          // hypotenoos (hell yeah I spell it like that)
        int mx = 1;     // multiplier for x (1 or -1)
        int my = 1;     // multiplier for y (1 or -1)

        if(targetX != getCenterX() ){
            x = targetX - getCenterX();
            mx = (int) (Math.abs(x)/x);
            x = Math.abs(x);
        }
        if(targetY != getCenterY()){
            y = targetY - getCenterY();
            my = (int) (Math.abs(y)/y);
            y = Math.abs(y);
        }

        z = Math.max((int) Math.ceil(Math.sqrt((x * x) + (y * y))), 1);



        dx = (int) (speed * x / z);
        dy = (int) (speed * y / z);


        dx = Math.min((int) x, dx) * mx;
        dy = Math.min((int) y, dy) * my;

        moveDelta(dx, dy);
    }


    public boolean canAttack(){
        return true;
    }

    public int checkAttack(){
        if(SPELL_KEYS[0].isPressed() && SPELL_KEYS[13].isPressed() && SPELL_KEYS[15].isPressed()){
            return 0;
        }




        return -1;
    }

    public void attack(int x, int y, int attackType){
        if(attackType >= 0) {


            Attack attack;
            double speed = 20;
            int dx, dy;     // delta x and y
            double z;          // hypotenoos (hell yeah I spell it like that)
            double mx = 1;     // multiplier for x (1 or -1)
            double my = 1;     // multiplier for y (1 or -1)

            x = x - getCenterX();
            if (x != getCenterX()) {
                mx = Math.abs(x) / x;
            }
            x = Math.abs(x);

            y = y - getCenterY();
            if (y != getCenterY()) {
                my = Math.abs(y) / y;
            }
            y = Math.abs(y);


            z = Math.max((int) Math.ceil(Math.sqrt((x * x) + (y * y))), 1);

            dx = (int) (mx * speed * x / z);
            dy = (int) (my * speed * y / z);

            attack = new Attack(0, getCenterX(), getCenterY(), 20, 20, PlayerConstants.Type.fire, dx, dy);
            attacks.add(attack);
        }
    }



    public void leftRelease(int x, int y) {
        if(canAttack()){
            attack(x, y, checkAttack());
        }
    }


        @Override
    public void tick(){
        super.tick();
        move();

        for(int i=0;i<attacks.size();i++){
            attacks.get(i).tick();
        }
    }


    @Override
    public void render(Graphics2D g, float v) {
        renderCenter(g, v, PLAYER_SPRITE[getId()]);
        for(int i=0;i<attacks.size();i++){
            attacks.get(i).render(g, v);
        }
    }
}
