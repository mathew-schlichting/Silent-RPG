package com.invert.rpg.game;

import com.invert.engine.objects.GameObjectI;
import com.invert.rpg.game.map.Map;

import java.awt.*;

/**
 * Created by Mathew on 11/24/2017.
 */
public class Game implements GameObjectI{

    private Map map;


    public Game(){
        map = new Map("");
    }


    public void tick(){
        map.tick();
    }

    public void render(Graphics2D g, float v){
        map.render(g, v);
    }



}
