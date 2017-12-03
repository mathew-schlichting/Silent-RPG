package com.invert.rpg.common;

import com.invert.engine.input.keyboard.Key;

import java.awt.event.KeyEvent;

public class InputConstants {

    public static Key[] SPELL_KEYS = {
            new Key(KeyEvent.VK_1),
            new Key(KeyEvent.VK_2),
            new Key(KeyEvent.VK_3),
            new Key(KeyEvent.VK_4),
            new Key(KeyEvent.VK_5),

            new Key(KeyEvent.VK_Q),
            new Key(KeyEvent.VK_W),
            new Key(KeyEvent.VK_E),
            new Key(KeyEvent.VK_R),
            new Key(KeyEvent.VK_T),

            new Key(KeyEvent.VK_A),
            new Key(KeyEvent.VK_S),
            new Key(KeyEvent.VK_D),
            new Key(KeyEvent.VK_F),
            new Key(KeyEvent.VK_G),

            new Key(KeyEvent.VK_Z),
            new Key(KeyEvent.VK_X),
            new Key(KeyEvent.VK_C),
            new Key(KeyEvent.VK_V),
            new Key(KeyEvent.VK_B)
    };


    public static Key[] ACTION_KEYS = {
            new Key(KeyEvent.VK_SHIFT),
            new Key(KeyEvent.VK_SPACE)
    };

    public static int   SHIFT   = 0;
    public static int   SPACE   = 1;


    public static Key[] ALL_KEYS = loadKeys();


    private static Key[] loadKeys(){
        Key[] keys;
        int i;

        keys = new Key[SPELL_KEYS.length + ACTION_KEYS.length];

        /* Add spell keys */
        i = 0;
        while(i < SPELL_KEYS.length){
            keys[i] = SPELL_KEYS[i];
            i++;
        }

        /* Add action keys */
        i = 0;
        while(i < ACTION_KEYS.length){
            keys[i + SPELL_KEYS.length] = ACTION_KEYS[i];
            i++;
        }

        return keys;
    }


}
