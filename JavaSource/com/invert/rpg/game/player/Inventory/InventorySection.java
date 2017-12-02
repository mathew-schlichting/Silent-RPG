package com.invert.rpg.game.player.Inventory;

import com.invert.engine.objects.GameObjectI;

import java.awt.*;

/**
 * Created by Mathew on 12/1/2017.
 */
public class InventorySection implements GameObjectI{

    private InventorySlot[][] slots;

    public InventorySection(InventorySlot[][] slots){
        this.slots = slots;
    }


    public void tick(){
        for(int x=0;x<slots.length;x++){
            for(int y=0;y<slots[x].length;y++){
                slots[x][y].tick();
            }
        }
    }

    public void render(Graphics2D g, float v){
        for(int x=0;x<slots.length;x++){
            for(int y=0;y<slots[x].length;y++){
                slots[x][y].render(g, v);
            }
        }
    }
}
