package com.invert.rpg;


import com.invert.engine.components.GameComponent;
import com.invert.engine.input.mouse.Mouse;
import com.invert.engine.output.display.screens.Display;
import com.invert.rpg.game.GameScreen;

import java.awt.*;

import static com.invert.rpg.common.RpgConstants.*;

/**
 * Created by Mathew on 11/24/2017.
 */
public class RpgMain extends GameComponent{

    private static RpgMain rpg;
    private Mouse mouse;
    private Display display;


    public static void main(String[] args){
        rpg = new RpgMain();
        rpg.init();
        rpg.start();
    }


    public RpgMain() {
        super(GAME_HERTZ, TARGET_FPS, SCREEN_SIZE, null, null, false, PIXEL_SIZE);
        display = new Display(new GameScreen());
        mouse = new Mouse(display);
        addMouseListener(mouse);
    }


    public void tick() {
        display.tick();
    }

    public void render(Graphics2D g, float v) {
        display.render(g, v);
    }
}
