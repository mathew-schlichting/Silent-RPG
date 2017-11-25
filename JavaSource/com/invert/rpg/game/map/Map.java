package com.invert.rpg.game.map;

import com.invert.engine.objects.GameObjectI;
import com.invert.engine.utils.GameLogger;
import com.invert.engine.utils.ResourceUtil;
import com.invert.rpg.exceptions.IllegalMapFormatException;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.IllegalFormatException;

import static com.invert.rpg.common.ImageConstants.RES;
import static com.invert.rpg.common.MapConstants.BLACK;
import static com.invert.rpg.common.MapConstants.TILE_SIZE;

/**
 * Created by Mathew on 11/24/2017.
 */
public class Map implements GameObjectI{

    private Tile[][] tile;

    public Map(String map) {
        tile = loadMap(map);

    }

    public Tile[][] loadMap(String map){
        File file;
        BufferedReader in;
        InputStreamReader inputStreamReader;
        ArrayList<String> lines;
        String currentLine;
        String[] currentList;
        int[][] ids;

        Tile[][] result;


        try {
            inputStreamReader = new InputStreamReader(ResourceUtil.getResourceStream(RES, map));
            in = new BufferedReader(inputStreamReader);


            lines = new ArrayList<>();
            currentLine = in.readLine();
            while(currentLine != null){
                lines.add(currentLine);
                currentLine = in.readLine();
            }


            ids = new int[lines.size()][0];

            for(int i=0;i<lines.size();i++){
                currentList = lines.get(i).split(" ");

                ids[i] = new int[currentList.length];
                for(int j=0;j<currentList.length;j++){
                    ids[i][j] = Integer.parseInt(currentList[j]);
                }
            }


            if(ids.length == 0 || ids[0].length == 0){
                throw new IllegalMapFormatException("Unable to parse map due to illegal format: " + map);
            }

            result = new Tile[ids[0].length][ids.length];
            for(int i=0;i<ids[0].length;i++){
                for(int j=0;j<ids.length;j++){
                    result[i][j] = new Tile(ids[j][i], i*TILE_SIZE, j*TILE_SIZE);
                }
            }


            return result;


        }catch (FileNotFoundException fnfe){
            GameLogger.logError("Could not find file: " + map);
        }catch (IOException ioe){
            GameLogger.logError("IOException thrown while loading map: " + map);
        }

        throw new IllegalMapFormatException("Unable to parse map due to illegal format: " + map);
    }



    public void tick() {
        for(int i=0;i<tile.length;i++){
            for(int j=0;j<tile[i].length;j++){
                tile[i][j].tick();
            }
        }
    }

    public void render(Graphics2D g, float v) {
        for(int i=0;i<tile.length;i++){
            for(int j=0;j<tile[i].length;j++){
                tile[i][j].render(g, v);
            }
        }
    }
}
