/* 
        Code for Assignment 5(b) by Luv : IIT2016085
*/

package MovingColors;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class canvas extends JPanel{
    ArrayList <rect> comp;
    int width;
    canvas t;
    Color color;
    public canvas(){
        this.width = 25;
        this.color = Color.GRAY;
        this.comp = new ArrayList<rect>();
        this.setBackground(Color.WHITE);
        t = this;
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Drawrect(e);
            }
        });
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                moverect(e);
            }
        });
    }
    private void Drawrect(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        comp .add(new rect(x, y, width, color));
        t.setFocusable(true);
        t.requestFocusInWindow();
        repaint();
    }
    public void moverect(KeyEvent e){
        int code = e.getKeyCode();
        if(code == 37){
            //left
            rect last = comp.get(comp.size()-1);
            int left = 0;
            if(last.getx() - last.getwidth() / 2 >= left){
                rect r = new rect(last.getx() - 3, last.gety(), last.getwidth(), last.getcolor());
                comp.remove(comp.size()-1);
                comp.add(r);
            }
        }
        else if(code == 38){
            //up
            rect last = comp.get(comp.size() - 1);
            int up = 0;
            if(last.gety() - last.getwidth() / 2 >= up){
                rect r = new rect(last.getx(), last.gety() - 3, last.getwidth(), last.getcolor());
                comp.remove(comp.size() - 1);
                comp.add(r);
            }
        }
        else if(code == 39){
            //right
            rect last = comp.get(comp.size() - 1);
            int right = getWidth();
            if(last.getx() + last.getwidth() / 2 <= right){
                rect r = new rect(last.getx() + 3, last.gety(), last.getwidth(), last.getcolor());
                comp.remove(comp.size() - 1);
                comp.add(r);
            }
        }
        else if(code == 40){
            //down
            int down = getHeight();
            rect last = comp.get(comp.size() - 1);
            if(last.gety() + last.getwidth() / 2 <= down){
                rect r = new rect(last.getx(), last.gety() + 3, last.getwidth(), last.getcolor());
                comp.remove(comp.size() - 1);
                comp.add(r);
            }
        }
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < comp.size(); ++i){
            g.setColor(comp.get(i).getcolor());
            int x = comp.get(i).getx();
            int y = comp.get(i).gety();
            int width = comp.get(i).getwidth();
            g.fillRect(x- width / 2, y - width / 2, width, width);
        }
    }
    void setwidth(int width){
        this.width = width;
    }
    void setcolor(Color color){
        this.color = color;
    }
    void clear(){
        comp.clear();
        repaint();
    }
}
