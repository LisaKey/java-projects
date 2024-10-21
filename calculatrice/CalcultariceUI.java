package calculatrice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcultariceUI {// erreur de frappe du clavier
	
	JFrame mafenetre = new JFrame("Ma calculatrice");
	
	JLabel lbl1 = new JLabel("number1");
	JLabel lbl2 = new JLabel("number2");
	
	JTextField text1 = new JTextField(10);
	JTextField text2 = new JTextField(10);
	
	JButton button1 = new JButton("+");
	JButton button2 = new JButton("-");
	JButton button3 = new JButton("*");
	JButton button4 = new JButton("/");
	
	JLabel lblresult = new JLabel("resultat");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	public void graphique() {
		panel1.add(lbl1);
		panel1.add(text1);
		panel1.add(lbl2);
		panel1.add(text2);
		
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		
		panel3.add(lblresult);
		
		mafenetre.add(panel1,BorderLayout.NORTH);
		mafenetre.add(panel2,BorderLayout.CENTER);
		mafenetre.add(panel3,BorderLayout.SOUTH);
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String val1 = text1.getText();
				String val2 = text2.getText();
				double a = Double.parseDouble(val1);
				double b = Double.parseDouble(val2);
				//Calculatrice calcul = new Calculatrice(a,b);
				double result = Calculatrice.additioner(a,b);
				lblresult.setText("Resultat = "+result);
			
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String val1 = text1.getText();
				String val2 = text2.getText();
				double a = Double.parseDouble(val1);
				double b = Double.parseDouble(val2);
				//Calculatrice calcul = new Calculatrice(a,b);
				double result = Calculatrice.soustraire(a,b);
				lblresult.setText("Resultat = "+result);
			
			}
		});
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String val1 = text1.getText();
				String val2 = text2.getText();
				double a = Double.parseDouble(val1);
				double b = Double.parseDouble(val2);
				//Calculatrice calcul = new Calculatrice(a,b);
				double result = Calculatrice.multiplier(a,b);
				lblresult.setText("Resultat = "+result);
			
			}
		});
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String val1 = text1.getText();
				String val2 = text2.getText();
				double a = Double.parseDouble(val1);
				double b = Double.parseDouble(val2);
				//Calculatrice calcul = new Calculatrice(a,b);
				double result = Calculatrice.division(a,b);
				lblresult.setText("Resultat = "+result);
			
			}
		});
		
		mafenetre.setVisible(true);
	}
	public static void main(String[] args) {
		CalcultariceUI ui = new CalcultariceUI();
		ui.graphique();
	}
}
