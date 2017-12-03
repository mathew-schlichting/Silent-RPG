package com.invert.rpg.game;

import com.invert.engine.output.display.Window;
import com.invert.engine.output.display.screens.Button;
import com.invert.engine.output.display.screens.Screen;
import com.invert.rpg.RpgMain;

import java.awt.*;

import static com.invert.rpg.common.RpgConstants.SCREEN_SIZE;

public class GameScreen extends Screen {

    private Game game;


    public GameScreen() {
        super(new Button[0]);
        game = new Game();
    }


    @Override
    public void rightPress(int x, int y) {

    }

    @Override
    public void rightRelease(int x, int y) {
        x = x - Window.getXScroll();
        y = y - Window.getYScroll();

        game.getPlayer().setTargetX(x);
        game.getPlayer().setTargetY(y);
    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void leftRelease(int x, int y){
        super.leftRelease(x, y);
        game.getPlayer().leftRelease(x - Window.getXScroll(), y - Window.getYScroll());
    }

    public void tick(){
        super.tick();
        game.tick();
    }

    public void render(Graphics2D g, float v){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SCREEN_SIZE.width, SCREEN_SIZE.height);
        game.render(g, v);
        super.render(g, v);
    }
}
