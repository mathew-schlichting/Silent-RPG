package com.invert.rpg.common;

import com.invert.engine.utils.ImageUtil;

import java.awt.image.BufferedImage;

/**
 * Created by Mathew on 11/24/2017.
 */
public class ImageConstants {

    public static final String RES = "Resources/";

    public static final BufferedImage[] tiles = {
            ImageUtil.loadImage(RES, "black.png")
    };


}
