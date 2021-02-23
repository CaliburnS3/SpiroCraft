package com.gmail.fingrambbg.generic;


/**
 * A pen can be used to draw on a canvas. The pen maintains a position, direction, color,
 * and an up/down state. The pen can be moved across the canvas. If the pen is down, it 
 * leaves a line on the canvas when moved. (If it is up, it will not draw a line.)
 *
 * @author Michael Kölling & David J. Barnes
 * @version 2016.02.29
 */
public class Pen
{

    private int xPosition;
    private int yPosition;
    private int rotation;

    public int pX;
    public int pY;

    /**
     * Create a new Pen with its own canvas. The pen will create a new canvas for 
     * itself to draw on, and start in the default state (centre of canvas, direction
     * right, color black, pen down).
     */
    public Pen()
    {
        this (0, 0);
    }

    /**
     * Create a new Pen for a given canvas. The direction is initially 0 (to the right),
     * the color is black, and the pen is down.
     *
     * @param xPos  the initial horizontal coordinate of the pen
     * @param yPos  the initial vertical coordinate of the pen
     * @param drawingCanvas  the canvas to draw on
     */
    public Pen(int xPos, int yPos)
    {
        xPosition = xPos;
        yPosition = yPos;
        rotation = 0;
    }

    /**
     * Move the specified distance in the current direction. If the pen is down, 
     * leave a line on the canvas.
     *
     * @param distance  The distance to move forward from the current location.
     */
    public void move(int distance)
    {
        double angle = Math.toRadians(rotation);
        int newX = (int) Math.round(xPosition + Math.cos(angle) * distance);
        int newY = (int) Math.round(yPosition + Math.sin(angle) * distance);

        moveTo(newX, newY);
    }

    /**
     * Move to the specified location. If the pen is down, leave a line on the canvas.
     *
     * @param x   The x-coordinate to move to.
     * @param y   The y-coordinate to move to.
     */
    public void moveTo(int x, int y)
    {
        xPosition = x;
        yPosition = y;
    }

    /**
     * Turn the specified amount (out of a 360 degree circle) clockwise from the current 
     * rotation.
     *
     * @param degrees  The amount of degrees to turn. (360 is a full circle.)
     */
    public void turn(int degrees)
    {
        rotation = rotation + degrees;
    }
    
    public void getPos()
    {
        pX = xPosition;
        pY = yPosition;
    }
}