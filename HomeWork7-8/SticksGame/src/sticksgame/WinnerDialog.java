/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sticksgame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andrey
 */
public class WinnerDialog extends JDialog {

    public WinnerDialog(JFrame owner, String winner) {
        super(owner, "You win", true);

        if (winner.length() != 0) {
            JLabel label = new JLabel("You win, " + winner);
            label.setBounds(150, 37, 175, 29);
            add(label);
            
        } else {
            JLabel label = new JLabel("DRAW");
            label.setBounds(150, 37, 175, 29);
            add(label);
            
        }

        // При активизации кнопки ОК диалогове окно закрывается.
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                setVisible(false);
            }
        });

        // Кнопка ОК помещается в нижнюю часть окна.
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(260, 160);
    }
}
