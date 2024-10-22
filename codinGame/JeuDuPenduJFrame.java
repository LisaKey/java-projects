package codinGame;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//import javax.swing.border.Border;
// ce projet est un jeu ou un joueur propose un mot et l'autre joueur essaie de le deviner par lettre
public class JeuDuPenduJFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int b;
	private static int a;
	private static String result;
	private static String messageResult;
	//private static JLabel JLabelresult = new JLabel();
	static String textA;
	static char[] resultTab;
	private ImageIcon icon;
	public static void main(String[] args) {
		new JeuDuPenduJFrame();
		
	}
	public JeuDuPenduJFrame() {
		//Définit un titre pour notre fenêtre
		this.setTitle("Jeu du pendu");
        
        //On définit la police d'écriture à utiliser
        Font police = new Font("Arial", Font.ITALIC, 20);
        Container ecran = new JLabel("0");
        ecran.setFont(police);
        
		JLabel lbl1 = new JLabel("Joueur 1");
		JLabel lbl2 = new JLabel("Joueur 2");
		JPanel panellbl1 = new JPanel(new GridBagLayout());
		GridBagConstraints gbclbl = new GridBagConstraints();
        gbclbl.anchor = GridBagConstraints.EAST;
        gbclbl.weighty = 1.0;
        panellbl1.add(lbl1, gbclbl);
        JPanel panellbl2 = new JPanel(new GridBagLayout());
        panellbl2.add(lbl2, gbclbl);
        
		JPasswordField text1 = new JPasswordField(8);
		text1.setPreferredSize(new Dimension(20, 30));
		
		JPanel paneltext1 = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weighty = 1.0;
        paneltext1.add(text1, gbc);
        
		JPanel paneltext2 = new JPanel(new GridBagLayout());
		JTextField text2 = new JTextField(6);
		text2.setPreferredSize(new Dimension(20, 30));
		paneltext2.add(text2, gbc);
		
		
		JPanel panelbuttonA = new JPanel();
		JButton buttonA = new JButton("Validez votre mot");
		buttonA.setPreferredSize(new Dimension(150, 40));
		panelbuttonA.add(buttonA);
		JPanel panelbutton = new JPanel();
		JButton button = new JButton("Validez votre lettre");
		button.setPreferredSize(new Dimension(150, 40));
		panelbutton.add(button);
		
		JPanel panelRejouer = new JPanel(new GridBagLayout());
		JLabel lblresult = new JLabel();
		lblresult.setBackground(new Color(100, 200, 200));
		lblresult.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton buttonRejouer = new JButton("Rejouer");
		buttonRejouer.setPreferredSize(new Dimension(100, 40));
		GridBagConstraints gbcRejouer = new GridBagConstraints();
        gbcRejouer.anchor = GridBagConstraints.CENTER;
        gbcRejouer.weighty = 1.0;
        
		
		icon = new ImageIcon("/Users/Lisa/Desktop/Lisa/Eclipse2/FirstProjet/bin/jeuDuPendu/dessindupundu/Le-pendu.png");
		JPanel paneldessin = new JPanel();
		paneldessin.add(new JLabel(icon));
		JPanel panel = new JPanel(new GridLayout(4, 1));
		
		
		
		//---------------
		
		//---------------
		JPanel panelAB = new JPanel(new GridLayout(1, 4));
		panelAB.add(panellbl1);
		panelAB.add(paneltext1);
		panelAB.add(panellbl2);
		panelAB.add(paneltext2);
		panel.add(panelAB);
		JPanel panelABbutton = new JPanel(new GridLayout(1, 2));
		panelABbutton.add(panelbuttonA);
		panelABbutton.add(panelbutton);
		panel.add(panelABbutton);
		panel.add(paneldessin);
		panelRejouer.add(lblresult);
		//panelRejouer.add(buttonRejouer, gbcRejouer);
		panel.add(panelRejouer);
		
		add(panel);
		pack();
		
		//Définit sa taille : 500 pixels de large et 300 pixels de haut
        this.setSize(430, 660);
        
       
        // figer la fenetre 
        this.setResizable(false);
		
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
		setVisible(true);
		
		//---------
				buttonA.addActionListener(new ActionListener(){
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						textA = text1.getText();
						
						// préparer la tab resultat en *****
						resultTab = new char[textA.length()];
						for(int i=0; i < resultTab.length; i++) {
								resultTab[i]='*';
						}
						text1.setEditable(false);
						buttonA.setEnabled(false);
					}
				});
		//---------
				button.addActionListener(new ActionListener(){
					

					public void actionPerformed(ActionEvent e) {
						
						char[] tabA = new char[textA.length()];
						for(int i=0; i < tabA.length; i++) {
							tabA[i]=textA.charAt(i);
						}
						//avoir le caractère de B
						String textB = text2.getText();
						char charB = 0;
						char[] tabB = new char[textB.length()];
						for(int i=0; i < tabB.length; i++) {
							tabB[i]=textB.charAt(i);
							charB=tabB[0];
						}
						//---------
						b=0;
						for(int i=0; i<tabA.length; i++) {
							if(charB==tabA[i]) {
								resultTab[i]=tabA[i];
								b++;
							}
						}
						result=new String(resultTab);
						if(b!=0) {
							// on joue encore
							messageResult = "Bravo ! Encore "+(6-a)+" tentatives "+result+ "   ";
							//panel.add(paneldessin);
							lblresult.setText(messageResult);
							panelRejouer.add(lblresult);
							if(result.equals(textA)) {
								messageResult = "Vous avez gagné :D "+result+ "   ";
								panel.add(paneldessin);
								text2.setEditable(false);
								button.setEnabled(false);
								//paneldessin.repaint();
								//panel.add(paneldessin);
							    //pack();
							    //setVisible(true);
							    lblresult.setText(messageResult);
								panelRejouer.add(lblresult);
								panelRejouer.add(buttonRejouer);
								
								
							}
						} else {
							a++;
							if(a==6){
								// tu as perdu
								messageResult = "Vous avez perdu :( le mot à trouver était : "+textA + "   ";
								icon.setImage(new ImageIcon("/Users/Lisa/Desktop/Lisa/Eclipse2/FirstProjet/bin/jeuDuPendu/dessindupundu/Le-pendu-6.png").getImage());
								text2.setEditable(false);
								button.setEnabled(false);
								paneldessin.repaint();
								panel.add(paneldessin);
							    //pack();
							    //setVisible(true);
							    lblresult.setText(messageResult);
								panelRejouer.add(lblresult);
								panelRejouer.add(buttonRejouer);
								
							}
								messageResult = "Raté ! Encore "+(6-a)+" tentatives "+result+ "   ";
								if(a==1) {
									icon.setImage(new ImageIcon("/Users/Lisa/Desktop/Lisa/Eclipse2/FirstProjet/bin/jeuDuPendu/dessindupundu/Le-pendu-1.png").getImage());
									paneldessin.repaint();
									panel.add(paneldessin);
								    //pack();
								   // setVisible(true);
								    lblresult.setText(messageResult);
									panelRejouer.add(lblresult);
								}
								if(a==2) {
									icon.setImage(new ImageIcon("/Users/Lisa/Desktop/Lisa/Eclipse2/FirstProjet/bin/jeuDuPendu/dessindupundu/Le-pendu-2.png").getImage());
									paneldessin.repaint();
									panel.add(paneldessin);
								    //pack();
								    //setVisible(true);
								    lblresult.setText(messageResult);
									panelRejouer.add(lblresult);
								}
								if(a==3) {
									icon.setImage(new ImageIcon("/Users/Lisa/Desktop/Lisa/Eclipse2/FirstProjet/bin/jeuDuPendu/dessindupundu/Le-pendu-3.png").getImage());
									paneldessin.repaint();
									panel.add(paneldessin);
								    //pack();
								    //setVisible(true);
								    lblresult.setText(messageResult);
									panelRejouer.add(lblresult);
								}
								if(a==4) {
									icon.setImage(new ImageIcon("/Users/Lisa/Desktop/Lisa/Eclipse2/FirstProjet/bin/jeuDuPendu/dessindupundu/Le-pendu-4.png").getImage());
									paneldessin.repaint();
									panel.add(paneldessin);
								    //pack();
								    //setVisible(true);
								    lblresult.setText(messageResult);
									panelRejouer.add(lblresult);
								}
								if(a==5) {
									icon.setImage(new ImageIcon("/Users/Lisa/Desktop/Lisa/Eclipse2/FirstProjet/bin/jeuDuPendu/dessindupundu/Le-pendu-5.png").getImage());
									paneldessin.repaint();
									panel.add(paneldessin);
								    //pack();
								    //setVisible(true);
								    lblresult.setText(messageResult);
									panelRejouer.add(lblresult);
								    
								}
								
							
								
							
						}
						//System.out.println("==========");
						
						
						panel.add(panelRejouer);
						panel.revalidate();
						panel.repaint();
						pack();
					    setVisible(true);
					}
						
					
					
				});
					
					
		
				
				//---------	
				
				//---------
				buttonRejouer.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent e) {
						text1.setEditable(true);
						text1.setText("");
						buttonA.setEnabled(true);
						text2.setEditable(true);
						text2.setText("");
						button.setEnabled(true);
						 icon.setImage(new ImageIcon("/Users/Lisa/Desktop/Lisa/Eclipse2/FirstProjet/bin/jeuDuPendu/dessindupundu/Le-pendu.png").getImage());
							paneldessin.repaint();
						panelRejouer.remove(buttonRejouer);
						panelRejouer.remove(lblresult);
						panelRejouer.revalidate(); // Rafraîchir la disposition
			            panelRejouer.repaint(); // Redessiner le panel
			           a=0;
						//panel.add(paneldessin);
					
					}
				});
		//---------
	}

}
