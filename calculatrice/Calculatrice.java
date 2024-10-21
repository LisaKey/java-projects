package calculatrice;

public class Calculatrice {
	double a;
	double b;
	
	Calculatrice(double num1, double num2){
		this.a=num1;
		this.b=num2;
	}
	public static double additioner(double num1, double num2) {
		double result=num1+num2;
		return result;
	}
	public static double soustraire(double num1, double num2) {
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
	public static double pourcentage(double num1) {
		double result=num1/100;
		return result;
	}
	public static double pousitifNegatif(double num1) {
		double result= num1*(-1);
		return result;
	}
	public static double renitialiser() {
		double result= 0;
		return result;
	}
	public static double virgule(double num1) {
		double result=num1+0.0;
		return result;
	}
	public static double validation(double result) {
		
		return result;
	}

}
