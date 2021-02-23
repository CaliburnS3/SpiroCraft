package com.gmail.fingrambbg.generic;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;

public class Spirograph
{
    private static int width;
    private static int height;
    private static Random rand;
    static Location loc;

    public static ArrayList<Location> drawSeeded(ArrayList<Location> input, Location position){
        width = 0;
        height = 0;
        int radius = 25;
        
        Random rand = new Random();

        int Segment = radius / 6;
        
        int innerBeam = rand.nextInt(Segment) + (2 * Segment);
        if(rand.nextInt(2) == 0){
            innerBeam = -innerBeam;
        }

        int outerBeam = rand.nextInt(Segment) + (2 * Segment);
        if(rand.nextInt(2) == 0){
            outerBeam = -outerBeam;
        }

        int innerCircle = rand.nextInt(175) + 5;
        if(rand.nextInt(2) == 0){
            innerCircle = -innerCircle;
        }

        int outerCircle = rand.nextInt(175) + 5;
        if(rand.nextInt(2) == 0){
            outerCircle = -outerCircle;
        }
        
        
        Pen base = new Pen(width, height);
        Pen end = new Pen(width, height);
        
        int x1 = 0;
        int y1 = 0;
        for(int i = 0; i < 361; i++){
            int x2 = x1;
            int y2 = y1;
            base.move(innerBeam);
            base.getPos();
            base.moveTo(width, height);
            base.turn(innerCircle);
            int x = base.pX;
            int y = base.pY;
            end.moveTo(x, y);
            end.move(outerBeam);
            end.turn(outerCircle);
            end.getPos();
            x1 = end.pX;
            y1 = end.pY;
            if(i > 0){
            	input.add(loc = new Location(SpiroCraft.world, x2 + position.getX(), position.getY(), y2 + position.getZ()));
            	input.add(loc = new Location(SpiroCraft.world, x1 + position.getX(), position.getY(), y1 + position.getZ()));
                //Pen output = new Pen(x2, y2);
                //output.moveTo(x1, y1);
            }
        }
        return input;
    }

}