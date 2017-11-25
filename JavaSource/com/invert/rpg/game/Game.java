package com.invert.rpg.game;

import com.invert.engine.objects.GameObjectI;
import com.invert.rpg.game.map.Map;
import com.invert.rpg.game.player.Player;

import java.awt.*;

import static com.invert.rpg.common.MapConstants.TILE_SIZE;

/**
 * Created by Mathew on 11/24/2017.
 */
public class Game implements GameObjectI{

    private Map map;
    private Player player;


    public Game(){
        map = new Map("maps/test.map");

        player = new Player(0, 1, 1, TILE_SIZE/2, TILE_SIZE/2);
    }


    public Map getMap(){return map;}
    public Player getPlayer(){return player;}


    public void tick(){
        map.tick();
        player.tick();
    }

    public void render(Graphics2D g, float v){
        map.render(g, v);
        player.render(g, v);
    }
}
