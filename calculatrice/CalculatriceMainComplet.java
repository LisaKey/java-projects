package calculatrice;

import java.util.Scanner;

public class CalculatriceMainComplet {

	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatriceMainComplet calcul = new CalculatriceMainComplet();
		System.out.println("Bonjour, que souhaitez-vous calculer? ");
		in = new Scanner(System.in);
        double num1 = in.nextInt(); 
		System.out.println(" ");
		System.out.println(" Vous souhaitez une + ou - ou / ? ");
        char c = in.next().charAt(0);
        if(c!='+' && c!='-' && c!='/') { System.out.println("Une erreur s'est produite ! Prière de refaire votre calcul");}
        else {
	        System.out.println(" ");
			System.out.println(" Avec ? ");
	        double num2 = in.nextInt(); 
	       	double result=0;
	        if(c=='+') { result = calcul.additioner(num1,num2);}
	        else if(c=='-') { result = calcul.soustraire(num1,num2);}
	        else if(c=='/') { result = CalculatriceMainComplet.division(num1,num2);}
	        System.out.println(" ");
	        System.out.println("Le résultat de "+num1+" "+c+" "+num2+" = "+result);
        }
        
	}

	public double additioner(double num1, double num2) {
		double result=num1+num2;
		return result;
	}
	public double soustraire(double num1, double num2) {
		double result=num1-num2;
		return result;
	}
	public static double division(double num1, double num2) {
		double result=num1/num2;
		return result;
	}
	public static double multiplier(double num1, double num2) {
		double result=num1*num2;
		return result;
	}
}
