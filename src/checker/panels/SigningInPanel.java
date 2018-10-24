package checker.panels;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import checker.gui.GTParameters;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class SigningInPanel extends JPanel {

	private JTextField loginField;
	private JPasswordField passwordField;

	JLabel labelConnexionTitle;	
	JLabel loginLabel;
	JLabel passwordLabel;
	JLabel errorEmptyField;

	JButton buttonConnexion;
	JButton buttonPrevious;
	
	/**
	 * Create the panel.
	 */
	public SigningInPanel() {
		setBackground(Color.LIGHT_GRAY.darker());
		setLayout(null);
		
		int windowWidth = GTParameters.WINDOW_WIDTH;
		if (windowWidth < 1024 || (windowWidth % 1024 != 0)) {
			throw new IllegalArgumentException("Non supported window size : " + windowWidth);
		}
		setPreferredSize(new Dimension(1024, 769));
		initLayout();
		initActions();	
	}
	
	protected void initActions() {
		buttonConnexion.addActionListener(new ConnectAction());
		buttonPrevious.addActionListener(new PreviousAction());
	}
	
	private class ConnectAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			if(loginField.getText().length()>0 && passwordField.getPassword().length>0) {
				//on consulte la bdd pour connecter ou non				
				//PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
			}		
			else {
				errorEmptyField.setVisible(true);
			}
		}
	}
	
	private class PreviousAction implements ActionListener{	
		public void actionPerformed(ActionEvent e) {
			PanelsContainer.getInstance().getCardLayout().previous(PanelsContainer.getInstance());
		}
	}
	
		
	public void initLayout () {
		labelConnexionTitle = new JLabel("Connexion");
		labelConnexionTitle.setFont(new Font("Tahoma", Font.PLAIN, 38));
		labelConnexionTitle.setBounds(400, 22, 335, 76);
		add(labelConnexionTitle);
		
		loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginLabel.setBounds(350, 126, 335, 76);
		add(loginLabel);
				
		loginField = new JTextField();
		loginField.setBounds(400, 156, 135, 20);
		add(loginField);
		loginField.setColumns(10);
		
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(320, 170, 335, 76);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(400, 200, 135, 20);
		add(passwordField);
		passwordField.setColumns(10);
		
		buttonConnexion = new JButton("Connexion");
		buttonConnexion.setBounds(400, 522, 114, 23);
		add(buttonConnexion);
		
		buttonPrevious = new JButton("Previous");
		buttonPrevious.setBounds(514, 522, 104, 23);
		add(buttonPrevious);
		
		errorEmptyField = new JLabel("One or several fields are uncomplete");
		errorEmptyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorEmptyField.setForeground(Color.red);
		errorEmptyField.setBounds(400,300,304,100);
		errorEmptyField.setVisible(false);
		add(errorEmptyField);
			
	}
}