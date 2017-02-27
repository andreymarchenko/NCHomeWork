/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Andrey
 */
public class VerticalBorder implements Serializable{

    private Color color;
    private int x;
    private int y;
    private int width = 7;
    private int heigth = 45;
    boolean state = false;

    public VerticalBorder() {

    }

    public VerticalBorder(Color color, int x, int y, int width, int heigth) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.heigth = heigth;
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }
}
