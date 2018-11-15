/**
 * 
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Dimension;

/**
 * @author GILLES Anne-Sophie
 *
 */
public class GUIConnection extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static GUIConnection window = new GUIConnection();
	private JTextField txtIdentifiant;
	private JPasswordField pwdMotDePasse;
	
	
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		window.setVisible(true);
		window.setTitle("Connexion");
	}
	
	
	public GUIConnection() {
		setSize(new Dimension(400, 300));
		setPreferredSize(new Dimension(360, 300));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblVeuillezVousConnecter = new JLabel("Veuillez vous connecter \u00E0 votre compte pour jouer.");
		lblVeuillezVousConnecter.setBounds(55, 11, 289, 14);
		getContentPane().add(lblVeuillezVousConnecter);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setBounds(135, 46, 83, 14);
		getContentPane().add(lblIdentifiant);
		
		txtIdentifiant = new JTextField();
		txtIdentifiant.setBounds(135, 71, 127, 20);
		getContentPane().add(txtIdentifiant);
		txtIdentifiant.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(135, 117, 86, 14);
		getContentPane().add(lblMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(151, 187, 97, 23);
		getContentPane().add(btnConnexion);
		
		pwdMotDePasse = new JPasswordField();
		pwdMotDePasse.setBounds(135, 142, 127, 20);
		getContentPane().add(pwdMotDePasse);
		
		JButton btnOuCrerUn = new JButton("ou Cr\u00E9er un compte");
		btnOuCrerUn.setBounds(123, 237, 157, 23);
		getContentPane().add(btnOuCrerUn);
	}
}
