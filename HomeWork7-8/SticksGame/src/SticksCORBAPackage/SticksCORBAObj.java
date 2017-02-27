/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SticksCORBAPackage;

import SticksCORBAApp.SticksCORBAPOA;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import sticksgame.Game;
import sticksgame.GamePanel;

/**
 *
 * @author Andrey
 */
public class SticksCORBAObj extends SticksCORBAPOA {

    // ---------- ВСЯ РЕАЛИЗАЦИЯ СЕРВЕРА ЗДЕСЬ ---------- //
    private ORB orb;
    GamePanel gamePanel;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.gamePanel.setVisible(true);
    }

    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    // implement clientMove() method
    // Сообщаем серверу, что клиент сходил, необходимо для изменения игры на сервере
    @Override
    public void clientMove(byte[] game) {
        try {
            Game clientGame = Game.fromByteArray(game);
            gamePanel.getMyListener().getGameField().setGame(clientGame);
            gamePanel.repaint();
        } catch (Exception e) {
        }
    }

    // implement serverMove() method
    @Override
    public byte[] serverMove() {
        try {
            gamePanel.setEnabled(true);
            while (gamePanel.getMyListener().getGameField().getGame().getActivePlayer() == true) {
            }
            gamePanel.setEnabled(false);
            Game serverGame = gamePanel.getMyListener().getGameField().getGame();
            return serverGame.toByteArray();
        } catch (Exception ex) {
            Logger.getLogger(SticksCORBAObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // implement shutdown() method
    @Override
    public void shutdown() {
        orb.shutdown(false);
    }
}
