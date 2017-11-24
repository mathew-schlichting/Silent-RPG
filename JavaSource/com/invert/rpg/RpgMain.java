package com.invert.rpg;


import com.invert.engine.components.GameComponent;
import com.invert.rpg.game.Game;

import java.awt.*;

import static com.invert.rpg.common.RpgConstants.*;

/**
 * Created by Mathew on 11/24/2017.
 */
public class RpgMain extends GameComponent{

    private static RpgMain rpg;
    private Game game;


    public static void main(String[] args){
        rpg = new RpgMain();
        startGame();
    }


    public RpgMain() {
        super(GAME_HERTZ, FPS, SIZE, null, null, false, PIXEL_SIZE);
        game = new Game();
    }


    public static void startGame(){
        rpg.init();
        rpg.start();
    }


    public void tick() {
        game.tick();
    }

    public void render(Graphics2D g, float v) {
        game.render(g, v);
    }
}
