package fr.esipe.ehpaddecision.connection;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Service extends JPanel {
	CardLayout card;
    Container con;
    
    JButton btn;
    public Service(CardLayout card , Container con) {
        btn = new JButton("BACK");
        this.card=card;
        this.con = con;
        btn.addActionListener(backListener);
        add(btn);  
    }
    
	ActionListener backListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
           card.show(con, "1");
        }
    };
}
