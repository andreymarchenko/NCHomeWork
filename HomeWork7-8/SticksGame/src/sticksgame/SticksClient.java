/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import SticksCORBAApp.SticksCORBA;
import SticksCORBAApp.SticksCORBAHelper;
import SticksCORBAPackage.SticksCORBAObj;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author Andrey
 */
public class SticksClient {

    static SticksCORBA sticksCORBAObj;

    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            sticksCORBAObj = SticksCORBAHelper.narrow(ncRef.resolve_str("Sticks"));

            System.out.println("Obtained a handle on server object: " + sticksCORBAObj);

            GamePanel gamePanel = new GamePanel();
            gamePanel.setVisible(true);

            while (!gamePanel.getMyListener().getGameField().getGame().isIsFinished()) {
                while (gamePanel.getMyListener().getGameField().getGame().getActivePlayer() == false) {
                }
                gamePanel.setEnabled(false);                
                
                //Client
                Game game = gamePanel.getMyListener().getGameField().getGame();
                sticksCORBAObj.clientMove(game.toByteArray());

                //Server
                byte[] response = sticksCORBAObj.serverMove();
                Game game1 = Game.fromByteArray(response);
                gamePanel.getMyListener().getGameField().setGame(game1);
                gamePanel.repaint();
                gamePanel.setEnabled(true);

            }
            
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}
