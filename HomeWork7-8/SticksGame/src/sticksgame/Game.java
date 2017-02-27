/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Andrey Класс, описывающий состояние игры
 */
public class Game implements Serializable {

    private Cell[][] cells;
    private HorizontalBorder[][] horizontalBorders;
    private VerticalBorder[][] verticalBorders;
    private int currentX = 0;
    private int currentY = 0;

    private boolean activePlayer = false;
    /**
     * false - 1-ый игрок(клиент) активен; true - 2-ой игрок(сервер) активен
     */
    private int clientScore = 0;
    private int serverScore = 0;
    private boolean isFinished = false;

    public boolean isIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Game() {
        initializeHorizontalBorders(45);
        initializeVerticalBorders(45);
        initializeCells(45);
    }

    public void initializeCells(int cellSize) {
        cells = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell(17 + (j * cellSize), 96 + i * cellSize, cellSize - 7, cellSize - 7);
                HorizontalBorder[] hB = {horizontalBorders[i][j], horizontalBorders[i + 1][j]};
                VerticalBorder[] vB = {verticalBorders[i][j], verticalBorders[i][j + 1]};
                cells[i][j].setHorizontalBorders(hB);
                cells[i][j].setVerticalBorders(vB);
            }
        }
    }

    public void initializeHorizontalBorders(int cellSize) {
        horizontalBorders = new HorizontalBorder[11][10];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                horizontalBorders[i][j] = new HorizontalBorder(Color.LIGHT_GRAY,
                        17 + (j * cellSize), 89 + i * cellSize, cellSize - 6, 8);
            }
        }
    }

    public void initializeVerticalBorders(int cellSize) {
        verticalBorders = new VerticalBorder[10][11];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                verticalBorders[i][j] = new VerticalBorder(Color.LIGHT_GRAY,
                        10 + (j * cellSize), 96 + i * cellSize, 8, cellSize - 7);
            }
        }
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public byte[] toByteArray() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(this);
            out.flush();
            byte[] yourBytes = bos.toByteArray();

            return yourBytes;

        } finally {
            try {
                bos.close();
            } catch (Exception ex) {
                // ignore close exception
            }
        }
    }

    public static Game fromByteArray(byte[] byteArray) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            Object o = in.readObject();

            return (Game) o;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                // ignore close exception
            }
        }
    }

    public void increaseClientScore() {
        this.clientScore++;
    }

    public void increaseServerScore() {
        this.serverScore++;
    }

    public synchronized int getClientScore() {
        return clientScore;
    }

    public void setClientScore(int clientScore) {
        this.clientScore = clientScore;
    }

    public int getServerScore() {
        return serverScore;
    }

    public void setServerScore(int serverScore) {
        this.serverScore = serverScore;
    }

    public synchronized boolean getActivePlayer() {
        return this.activePlayer;
    }

    public synchronized void setActivePlayer(boolean activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public HorizontalBorder[][] getHorizontalBorders() {
        return horizontalBorders;
    }

    public void setHorizontalBorders(HorizontalBorder[][] horizontalBorders) {
        this.horizontalBorders = horizontalBorders;
    }

    public VerticalBorder[][] getVerticalBorders() {
        return verticalBorders;
    }

    public void setVerticalBorders(VerticalBorder[][] verticalBorders) {
        this.verticalBorders = verticalBorders;
    }

}
