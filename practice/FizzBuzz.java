package practice;

import java.util.Arrays;
import java.util.Scanner;
// ce projet consiste à avoir un tableau et transformer les chiffres divisables par 3 en fizz et ceux divisables par 5 par buzz et ceux divisables par 3 et 5 en même temps par fizzbuzz
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// saisir la taille du tableau
		System.out.println("Saisissez la taille du tableau");
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			// créer le tableau
			String[] array = new String[n];
			for(int i=0; i < array.length; i++) {
				array[i]= String.valueOf(i+1);	
			}
			// afficher un tableau
			System.out.println("This is the first array : \n" +Arrays.toString(array));
			// test the array and modifie it
			for(int i=0; i < array.length; i++) {
				if((i+1)%3 == 0) {
					array[i]="fizz";
				}
				if((i+1)%5 == 0){
					array[i]="buzz";
				}
				if(((i+1)%3 == 0) && ((i+1)%5 == 0)){
					array[i]="fizzbuzz";
				}	
			}
			//afficher le nouveau tableau
			System.out.println("This is the new array : \n"+Arrays.toString(array));
		}
		
		
	}

}

