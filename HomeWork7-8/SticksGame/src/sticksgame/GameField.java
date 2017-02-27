/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andrey
 */
public class GameField extends JPanel {

    private Game game;

    public GameField() {
        setOpaque(true);
    }

    public GameField(Game game) {
        setOpaque(true);
        this.game = game;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        Font scoreFont = new Font("Tahoma", Font.PLAIN, 25);
        g.setFont(scoreFont);
        g.drawString("Score", 208, 30);
        Font playersFont = new Font("Tahoma", Font.PLAIN, 20);
        g.setFont(playersFont);
        g.drawString("Player 1", 10, 65);
        g.drawString("Player 2", 396, 65);
        g.drawString(Integer.toString(game.getClientScore()), 211, 65);
        g.drawString(Integer.toString(game.getServerScore()), 256, 65);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g.setColor(game.getCells()[i][j].getColor());
                g.fillRect(game.getCells()[i][j].getX(), game.getCells()[i][j].getY(),
                        game.getCells()[i][j].getWidth(), game.getCells()[i][j].getHeigth());
            }
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                g.setColor(game.getHorizontalBorders()[i][j].getColor());
                g.fillRect(game.getHorizontalBorders()[i][j].getX(), game.getHorizontalBorders()[i][j].getY(),
                        game.getHorizontalBorders()[i][j].getWidth(), game.getHorizontalBorders()[i][j].getHeigth());
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                g.setColor(game.getVerticalBorders()[i][j].getColor());
                g.fillRect(game.getVerticalBorders()[i][j].getX(), game.getVerticalBorders()[i][j].getY(),
                        game.getVerticalBorders()[i][j].getWidth(), game.getVerticalBorders()[i][j].getHeigth());
            }
        }
    }

    public Game getGame() {
        return game;
    }

    public synchronized void setGame(Game game) {
        this.game = game;
        if (getGame().getActivePlayer() == false) {
            System.out.println("Ходит клиент 1");
        } else if (getGame().getActivePlayer() == true) {
            System.out.println("Ходит сервер 1");
        }
    }
}
