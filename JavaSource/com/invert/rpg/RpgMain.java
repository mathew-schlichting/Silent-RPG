package com.invert.rpg;


import com.invert.engine.components.GameComponent;
import com.invert.engine.input.keyboard.Keyboard;
import com.invert.engine.input.mouse.Mouse;
import com.invert.engine.output.display.screens.Display;
import com.invert.rpg.game.GameScreen;

import java.awt.*;

import static com.invert.rpg.common.InputConstants.ALL_KEYS;
import static com.invert.rpg.common.RpgConstants.*;

/**
 * Created by Mathew on 11/24/2017.
 */
public class RpgMain extends GameComponent{

    private static RpgMain instance;
    private Mouse mouse;
    private Keyboard keyboard;
    private Display display;


    public static void main(String[] args){
        instance = new RpgMain();
        instance.init();
        instance.start();
    }


    public RpgMain() {
        super(GAME_HERTZ, TARGET_FPS, SCREEN_SIZE, null, null, false, PIXEL_SIZE);
        display = new Display(new GameScreen());

        mouse = new Mouse(display);
        keyboard = new Keyboard(ALL_KEYS);

        addMouseListener(mouse);
        addKeyListener(keyboard);
    }


    public static Keyboard getKeyboard(){
        return instance.keyboard;
    }



    public void tick() {
        display.tick();
    }

    public void render(Graphics2D g, float v) {
        display.render(g, v);
    }
}
