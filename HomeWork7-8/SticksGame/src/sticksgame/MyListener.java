/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Andrey
 */
public class MyListener implements MouseListener {

    GameField gameField;
    GamePanel gamePanel;
    WinnerDialog dialog;

    public synchronized GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }
    int currentX;
    int currentY;
    boolean isClicked = false;

    public MyListener(GameField gamefield, GamePanel gamePanel) {
        this.gameField = gamefield;
        this.gamePanel = gamePanel;
    }

    public void makeMove(int x, int y, boolean active) {

        isClicked = false;
        currentX = x;
        currentY = y;

        int previousIndicator = 0;
        int nextIndicator = 0;

        //Закраска горизонтальных границ
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                if ((x - 6) > gameField.getGame().getHorizontalBorders()[i][j].getX()
                        && (x - 6) < (gameField.getGame().getHorizontalBorders()[i][j].getX()
                        + gameField.getGame().getHorizontalBorders()[i][j].getWidth())
                        && (y - 6) > gameField.getGame().getHorizontalBorders()[i][j].getY()
                        && (y - 6) < (gameField.getGame().getHorizontalBorders()[i][j].getY()
                        + gameField.getGame().getHorizontalBorders()[i][j].getHeigth())) {
                    if (gameField.getGame().getHorizontalBorders()[i][j].getColor().equals(Color.BLACK)) {
                        return;
                    } else {
                        gameField.getGame().getHorizontalBorders()[i][j].setColor(Color.BLACK);
                        nextIndicator++;
                    }
                }
            }
        }

        //Закраска вертикальных границ
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                if ((x - 6) > gameField.getGame().getVerticalBorders()[i][j].getX()
                        && (x - 6) < gameField.getGame().getVerticalBorders()[i][j].getX()
                        + gameField.getGame().getVerticalBorders()[i][j].getWidth()
                        && (y - 6) > gameField.getGame().getVerticalBorders()[i][j].getY()
                        && (y - 6) < gameField.getGame().getVerticalBorders()[i][j].getY()
                        + gameField.getGame().getVerticalBorders()[i][j].getHeigth()) {
                    if (gameField.getGame().getVerticalBorders()[i][j].getColor().equals(Color.BLACK)) {
                        return;
                    } else {
                        gameField.getGame().getVerticalBorders()[i][j].setColor(Color.BLACK);
                        nextIndicator++;
                    }
                }
            }
        }

        //Проверка на закрашенность клетки
        if (active == false) {
            int firstInspector = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (gameField.getGame().getCells()[i][j].getHorizontalBorders()[0].getColor().equals(Color.BLACK)
                            && gameField.getGame().getCells()[i][j].getHorizontalBorders()[1].getColor().equals(Color.BLACK)
                            && gameField.getGame().getCells()[i][j].getVerticalBorders()[0].getColor().equals(Color.BLACK)
                            && gameField.getGame().getCells()[i][j].getVerticalBorders()[1].getColor().equals(Color.BLACK)
                            && gameField.getGame().getCells()[i][j].getColor().equals(Color.WHITE)) {
                        gameField.getGame().getCells()[i][j].setColor(Color.RED);
                        gameField.getGame().increaseClientScore();
                        firstInspector++; //Если уже закрасил одну ячейку, чтобы дальше при проверке не произошел переход хода
                    } else if (firstInspector == 0) {
                        if ((nextIndicator - previousIndicator) > 0) { //Для того, чтобы не переходил ход при нажатии на пустую клетку
                            gameField.getGame().setActivePlayer(true);
                            previousIndicator++;
                            gamePanel.repaint();
                        }
                    }
                }
            }
            if (gamePanel.getGameField().getGame().getActivePlayer() == false) {
                System.out.println("Ходит клиент 1");
            } else if (gamePanel.getGameField().getGame().getActivePlayer() == true) {
                System.out.println("Ходит сервер 1");
            }
        } else if (active == true) {
            int secondInspector = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (gameField.getGame().getCells()[i][j].getHorizontalBorders()[0].getColor().equals(Color.BLACK)
                            && gameField.getGame().getCells()[i][j].getHorizontalBorders()[1].getColor().equals(Color.BLACK)
                            && gameField.getGame().getCells()[i][j].getVerticalBorders()[0].getColor().equals(Color.BLACK)
                            && gameField.getGame().getCells()[i][j].getVerticalBorders()[1].getColor().equals(Color.BLACK)
                            && gameField.getGame().getCells()[i][j].getColor().equals(Color.WHITE)) {
                        gameField.getGame().getCells()[i][j].setColor(Color.BLUE);
                        gameField.getGame().increaseServerScore();
                        secondInspector++;
                    } else if (secondInspector == 0) {
                        if ((nextIndicator - previousIndicator) > 0) {
                            gameField.getGame().setActivePlayer(false);
                            previousIndicator++;
                            gamePanel.repaint();
                        }
                    }
                }
            }
            if (gamePanel.getGameField().getGame().getActivePlayer() == false) {
                System.out.println("Ходит клиент 2");
            } else if (gamePanel.getGameField().getGame().getActivePlayer() == true) {
                System.out.println("Ходит сервер 2");
            }
        }

        if (gamePanel.getGameField().getGame().getClientScore()
                + gamePanel.getGameField().getGame().getServerScore() == 3) {
            gamePanel.getGameField().getGame().setIsFinished(true);
            if (gamePanel.getGameField().getGame().getClientScore()
                    > gamePanel.getGameField().getGame().getServerScore()) {
                dialog = new WinnerDialog(gamePanel, "Player 1");
                dialog.setLocation(500,300);
                dialog.setVisible(true);
                gamePanel.setEnabled(false);
            } else if (gamePanel.getGameField().getGame().getClientScore()
                    < gamePanel.getGameField().getGame().getServerScore()) {
                dialog = new WinnerDialog(gamePanel, "Player 2");
                dialog.setLocation(500,300);
                dialog.setVisible(true);
                gamePanel.setEnabled(false);
            } else {
                dialog = new WinnerDialog(gamePanel, "");
                dialog.setLocation(500,300);
                dialog.setVisible(true);
                gamePanel.setEnabled(false);
            }
        }
        gamePanel.repaint();
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

    public boolean isClicked() {
        return this.isClicked;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        isClicked = true;
        gameField.getGame().setCurrentX(e.getX());
        gameField.getGame().setCurrentY(e.getY());
        makeMove(e.getX(), e.getY(), gameField.getGame().getActivePlayer());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
