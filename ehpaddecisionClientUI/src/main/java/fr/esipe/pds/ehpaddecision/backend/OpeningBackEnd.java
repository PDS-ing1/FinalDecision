package fr.esipe.pds.ehpaddecision.backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import fr.esipe.pds.ehpaddecision.*;
import fr.esipe.pds.ehpaddecision.frontend.EhpadPage;
import fr.esipe.pds.ehpaddecision.frontend.OpenPageFront;
import fr.esipe.pds.ehpaddecision.frontend.openingPageOld;
import fr.esipe.pds.ehpaddecision.main.ClientServerConnection;
import fr.esipe.pds.ehpaddecision.main.EhpadMain;


public class OpeningBackEnd implements ActionListener{
	
	private EhpadPage ehpadPage;
	
	
	private OpenPageFront openFront;
	
	
	
	public OpeningBackEnd(EhpadPage ehpadPage, OpenPageFront openFront) {
		this.ehpadPage=ehpadPage;
		this.openFront = openFront; 
	}

	@SuppressWarnings("incomplete-switch")
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() instanceof JButton)
		{
			JButton clickedButton = (JButton)ae.getSource();

			if(clickedButton == openFront.serverAccess())
			{				
				openFront.connectionState().setText(ConnectionStarting.TRYAGAIN.getMessage());
				
				ConnectionStarting status = ClientServerConnection.callSocket();
				openFront.connectionState().setText("");
				switch(status)
				{					
					case FAIL:
						JOptionPane.showMessageDialog(null, ConnectionStarting.FAIL,null, JOptionPane.ERROR_MESSAGE);
						break;	
						
					case CONNECTION_PROBLEM:
						JOptionPane.showMessageDialog(null, ConnectionStarting.CONNECTION_PROBLEM, null, JOptionPane.ERROR_MESSAGE);
						break;
	
					case WELLDONE:
						JOptionPane.showMessageDialog(null, ConnectionStarting.WELLDONE, null, JOptionPane.INFORMATION_MESSAGE);
						ehpadPage.showPage(ehpadPage.returnNameEhpad());
						ehpadPage.setVisible(true);
						
						break;
				}
			}
		}

	}
}
	

