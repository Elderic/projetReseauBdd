package gui;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author 
 *
 */
public class GUIMainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	final static String STARTINGPANEL= "RPG - STARTING PANEL";
	final static String GAMEPANEL = "RPG - GAME PANEL";
	final static String FIGHTPANEL = "RPG - FIGHT PANEL";
	final static String SIGNUPPANEL = "RPG - SIGN UP PANEL";
	final static String SIGNINPANEL = "RPG - SIGN IN PANEL";
	final static String CHARACTERCREATIONPANEL = "RPG - CHARACTER CREATION PANEL";

	private JPanel panelsContainer;
	private JPanel startingPanel;
	private JPanel fightPanel;
	private JPanel characterCreationPanel;
	private JPanel signInPanel;
	private JPanel signUpPanel;

	private GUIGame gamePanel;
	private JButton startButton;
	private CardLayout cardLayout;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMainWindow frame = new GUIMainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 */
	public void initActions () {
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.next(panelsContainer);
				System.out.println("test");
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public GUIMainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// panelsContainer = new JPanel();
		// panelsContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		// panelsContainer.setLayout(new BorderLayout(0, 0));
		// setContentPane(panelsContainer);
		
		setSize(new Dimension(1050, 900));
		setResizable(false);

		//Where the components controlled by the CardLayout are initialized:
		//Create the "cards".
		startingPanel = new JPanel();
		gamePanel = new GUIGame();
		fightPanel = new GUIFight();
		//characterCreationPanel = new GUICharacterCreation();
		//signInPanel = new GUISigningIn();
		//signUpPanel = new GUISigningUp();

		// startingPanel.addKeyListener(new GUIGame());
		startingPanel.setFocusable(true);
        
		// Create cardLayout
		cardLayout = new CardLayout();
		
		//Create the panel that contains the "cards".
		panelsContainer = new JPanel(cardLayout);
		
		startButton = new JButton("START");
	
		startingPanel.add(startButton);
		
		panelsContainer.add(startingPanel, STARTINGPANEL);
		panelsContainer.add(gamePanel, GAMEPANEL);
		panelsContainer.add(fightPanel, FIGHTPANEL);
		//panelsContainer.add(characterCreationPanel, CHARACTERCREATIONPANEL);
		//panelsContainer.add(signInPanel, SIGNINPANEL);
		//panelsContainer.add(signUpPanel, SIGNUPPANEL);

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// ((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this)).setJMenuBar(menuBar);
		// System.out.println(this.getRootPane());
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmQuitter = new JMenuItem("Quit");
		mnNewMenu.add(mntmQuitter);
		
		JMenu mnMultijoueurs = new JMenu("Multi-player");
		menuBar.add(mnMultijoueurs);
		
		JMenuItem mntmCombatreUnAutre = new JMenuItem("Fight another player");
		mnMultijoueurs.add(mntmCombatreUnAutre);
		
		// getContentPane().setLayout(null);
		/*
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnNewMenu.add(mntmQuitter);
		
		JMenu mnMultijoueurs = new JMenu("Multi-joueurs");
		menuBar.add(mnMultijoueurs);
		
		JMenuItem mntmCombatreUnAutre = new JMenuItem("Combatre un autre joueur");
		mnMultijoueurs.add(mntmCombatreUnAutre);
		getContentPane().setLayout(null);
		*/
		
		// JPanel panelMap = new JPanel();
		// panelMap.setBounds(10, 11, 474, 428);
		getContentPane().add(panelsContainer);
		
		// panelMap.setBorder(BorderFactory.createLineBorder(Color.black));
        // setFocusable(true);
        //this.pack();
        initActions();
        // this.player = new PlayersCharacter();
        /*
		try {
			initGameVariables();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
