package com.invert.rpg.common;

import com.invert.engine.utils.ImageUtil;

import java.awt.image.BufferedImage;

/**
 * Created by Mathew on 11/24/2017.
 */
public class ImageConstants {

    public static final String RES = "Resources/";

    public static final BufferedImage[] tiles = {
            ImageUtil.loadImage(RES, "images/black.png"),
            ImageUtil.loadImage(RES, "images/grass.png"),
            ImageUtil.loadImage(RES, "images/water.png")
    };



    public static BufferedImage[] PLAYER_SPRITE = {
            ImageUtil.loadImage(RES, "images/player.png")
    };


}
