package com.invert.rpg.game.player.Inventory;

import com.invert.engine.objects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Mathew on 12/1/2017.
 */
public abstract class Item extends GameObject{


    private boolean inventoryItem;

    public Item(BufferedImage image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
    }


    public void renderInventory(Graphics2D g, float v){
        
    }

    public void renderField(Graphics2D g, float v){

    }

    @Override
    public void render(Graphics2D g, float v){
        if(inventoryItem){
            renderInventory(g, v);
        }
        else{
            renderField(g, v);
        }
    }



}
