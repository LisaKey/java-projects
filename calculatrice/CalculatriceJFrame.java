package calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//import javax.swing.border.Border;

public class CalculatriceJFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Double num1;
	private static Double num2;
	private static String operation;
	public static void main(String[] args) {
		
		//afficher une fenetre avec ses dimensions, son titre
		CalculatriceJFrame fenetre = new CalculatriceJFrame();
		
		//Instanciation d'un objet JPanel
        JPanel pan = new JPanel();
        //Définition de sa couleur de fond
        pan.setBackground(Color.orange);        
        pan.setLayout(new BorderLayout());
        
        // définition une dimension pour les bouttons
       //Dimension dim = new Dimension(30, 40);
        //Dimension dimEgal = new Dimension(60, 40);
        
        JPanel bouttonPanel = new JPanel(new GridBagLayout());
        //bouttonPanel.setLayout(new GridLayout(0, 4));
        
       
        
        // Créez un JTextField avec une largeur de 18 colonnes
        JPanel champsPanel = new JPanel();
        JTextField textField = new JTextField(19); 
        textField.setPreferredSize(new Dimension(30, 40));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        champsPanel.add(textField);
        
        
        
        
        GridBagConstraints constraints = new GridBagConstraints();
        
        //afficher les boutons
        String[] listButton = {"AC", "+/-", "%", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "0", ",", "="};
        JButton[] tab_button = new JButton[listButton.length];
        for(int i = 0; i < listButton.length; i++){
        	tab_button[i] = new JButton(listButton[i]);
        	//tab_button[i].setPreferredSize(dimEgal);
        	constraints.gridx = i%4; // Colonne 
            constraints.gridy = i/4; // Ligne 
            constraints.insets = new Insets(3, 5, 3, 5); // Marges internes (5 pixels de haut, 5 pixels de gauche, 5 pixels de bas, 5 pixels de droite)
            constraints.fill = GridBagConstraints.BOTH;
            
            if (listButton[i].equals("=")) { // L'indice du bouton qui prend deux colonnes
        		constraints.gridwidth = 2; // Le bouton prend deux colonnes
        		//Border border = BorderFactory.createLineBorder(Color.GRAY, 2); // Bordure rouge avec une épaisseur de 2 pixels
        		
        		//tab_button[i].setBorder(border);
            } else {
            	//Border border = BorderFactory.createLineBorder(Color.GRAY, 1); // Bordure rouge avec une épaisseur de 2 pixels
            	//tab_button[i].setBorder(border);
        		constraints.weightx = 1.0; // La colonne se redimensionne
            }
        	bouttonPanel.add(tab_button[i], constraints);
        	/*
        	tab_button[i] = new JButton(listButton[i]);
    		tab_button[i].setPreferredSize(dim);
        	bouttonPanel.add(tab_button[i]);
        	*/
    		
    		pan.add(bouttonPanel, BorderLayout.CENTER);
        	
        	// action a faire pour chaque bouton avec action listener
        	tab_button[i].addActionListener((ActionListener) new ActionListener() {
        		double result=0.0;
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
                    String action = e.getActionCommand(); // l'action faite, le texte du bouton
                    
                    if(action.equals("AC")) {
                    	num1=null;
                    	num1=null;
                    	operation=null;
                    	textField.setText("00");
                    }else if(action.equals("=")) {
    						if(operation==null) {//il n'y a pas d'operation et on demande un calcul
    							textField.setText("0.0");
    						}else {
    						//System.out.println("-------");
    						//System.out.println("action num1 = "+num1);
        					//System.out.println("action num2=  "+num2);
        					//System.out.println("action operation = "+operation);
            				result = Calculer(num1, num2, operation);
    						//System.out.println("operation calcul = "+result);
    						textField.setText(String.valueOf(result));
    						num1=result;
    						num2=0.0;
    						operation=null;
    						}
    						
	    					}else { 
		    						if(!isChiffre(action)){
		    							// ce n'est pas un chiffre, ni AC, ni =, alors soit % ou +/- ou * + - /
		    							// si c'est % ou +/-
		    							if(action.equals("%") || action.equals("+/-")) {
		    								if(operation==null) {
		    									//si pas encore d'operation alors on est a num1
		    									num1 = CalculerNum1(num1, action);
		    									textField.setText(String.valueOf(num1));
		    								}else {
		    									num2 = CalculerNum1(num2, action);
		    									textField.setText(String.valueOf(num2));
		    								}
		    							}else {
		    								// si c'est + ou - ou / ou *
		    								operation=action;
		    							}
			    						//System.out.println("-------");
			        					//System.out.println("num1 operation "+num1);
			    						//System.out.println("operation else : "+operation);
			    						
			    					}else {
			    						
			    						if(operation==null) {
			    							// pas encore d'operation, c'est à dire, de calcul, alors  on est au num1
			    							textField.setText(action);
			    							num1=Double.parseDouble(action);
			    							//System.out.println("-----1");
			    							//System.out.println("num1 : "+num1);
			    							//System.out.println("operation : "+operation);
			    						}else {
			    							// si on a une operation a faire alors on est num2
			    							textField.setText(action);
			    							num2=Double.parseDouble(action);
			    							//System.out.println("-----2");
			    							//System.out.println("num2 : "+num2);
			    							//System.out.println("operation : "+operation);
			    						}
			    					}
	    					}
    			}
    		});
        }
        pan.add(champsPanel, BorderLayout.NORTH);
        fenetre.setContentPane(pan);               
        fenetre.setVisible(true);
    }
	
	public CalculatriceJFrame() {
		//Définit un titre pour notre fenêtre
        this.setTitle("Calculatrice");
        //Définit sa taille : 500 pixels de large et 300 pixels de haut
        this.setSize(250, 270);
        //Nous demandons maintenant à notre objet de se positionner au centre
        this.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible 
        this.setVisible(true);
        // figer la fenetre 
        this.setResizable(false);
        //On définit la police d'écriture à utiliser
        Font police = new Font("Arial", Font.BOLD, 20);
        Container ecran = new JLabel("0");
        ecran.setFont(police);
	}
	
	public static double Calculer(double num1, double num2, String operation) {
		double result =0;
		if(operation.equals("+")) {
			result = Calculatrice.additioner(num1,num2);
		}else
		if(operation.equals("-")) {
			result = Calculatrice.soustraire(num1,num2);
		}else
		if(operation.equals("/")) {
			result = Calculatrice.division(num1,num2);
		}else
		if(operation.equals("x")) {
			result = Calculatrice.multiplier(num1,num2);
		}
		return result;
	}
	
	public static double CalculerNum1(double num1, String operation) {
		double result =0;
		if(operation.equals("%")) {
			result = Calculatrice.pourcentage(num1);
		}else
		if(operation.equals("+/-")) {
			result = Calculatrice.pousitifNegatif(num1);
		}
		return result;
	}
	
	private static boolean isChiffre(String texte) {
	    // Vérifie si l'action est un chiffre valide
		boolean bool;
		if(texte.equals("0") || texte.equals("1")  || texte.equals("2") || texte.equals("3") || texte.equals("4") || texte.equals("5") || texte.equals("6") || texte.equals("7") || texte.equals("8") || texte.equals("9")) {
			bool=true;
		}else {
			bool=false;
		}
	    return bool;
	}
	

}
