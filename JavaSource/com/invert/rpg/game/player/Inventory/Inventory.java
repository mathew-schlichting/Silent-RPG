package com.invert.rpg.game.player.Inventory;

import com.invert.engine.objects.GameObjectI;

import java.awt.*;

/**
 * Created by Mathew on 12/1/2017.
 */
public class Inventory implements GameObjectI{

    private InventorySection[] sections;
    private int currentSection;

    public Inventory(InventorySection[] sections){
        this.sections = sections;
        this.currentSection = 0;
    }




    public void tick(){
        sections[currentSection].tick();
    }

    public void render(Graphics2D g, float v){
        sections[currentSection].render(g, v);
    }





}
