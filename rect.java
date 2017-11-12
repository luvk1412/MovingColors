/* 
        Code for Assignment 5(b) by Luv : IIT2016085
*/

package MovingColors;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class rect{
    private int x, y, width;
    private Color color;
    public rect(int x, int y, int width, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getwidth(){
        return width;
    }
    public Color getcolor(){
        return color;
    }
}