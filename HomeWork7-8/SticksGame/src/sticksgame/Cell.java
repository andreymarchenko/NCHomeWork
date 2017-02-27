/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import javax.swing.JComponent;

/**
 *
 * @author Andrey
 */
public class Cell implements Serializable{

    private Color color = Color.WHITE;  
    private int x;
    private int y;
    private int width;
    private int heigth;
    private int state = 0;
    private HorizontalBorder[] cellsHorizontalBorders;
    private VerticalBorder[] cellsVerticalBorders;

    public Cell(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }

    public HorizontalBorder[] getHorizontalBorders() {
        return cellsHorizontalBorders;
    }

    public void setHorizontalBorders(HorizontalBorder[] horizontalBorders) {
        this.cellsHorizontalBorders = horizontalBorders;
    }

    public VerticalBorder[] getVerticalBorders() {
        return cellsVerticalBorders;
    }

    public void setVerticalBorders(VerticalBorder[] verticalBorders) {
        this.cellsVerticalBorders = verticalBorders;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
