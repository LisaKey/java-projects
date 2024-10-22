package practice;

import java.util.Arrays;
import java.util.Scanner;
// ce projet affiche les nombres premiers dans notre tableau
public class PrimeFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// scanner la taille du tableau et le créer
		System.out.println("Quel est la taille du tableau : ");
		try (Scanner src = new Scanner(System.in)) {
			int size = src.nextInt();
			int[] array = new int[size];
			for(int i=0; i < size; i++) {
				array[i]=i+1;
			}
			System.out.println("Voici le tableau :\n"+ Arrays.toString(array));
			int nbdiv, j;
			for(int i=0; i < size; i++) {
				nbdiv=0;
				for(j=array[i]; j!=0; j--) {
					if(array[i]%j==0) {
						nbdiv++;
					}
				}
				// si le nombre de division est de 1 (pour le 1) ou de 2 alors il est premier
				if(nbdiv <=2 ) {
					System.out.println(array[i]+" est premier");
				}
			}
			/* 
			// boucle for et while
			// vérifier si le nombre est premier
			  int nbdiv, j;
			for(int i=0; i < size; i++) {
				nbdiv=0;
				j=array[i];
				while (j!=0) {
					// si le chiffre est divisable par j on incrémente nbdiv
					if(array[i]%j==0) {
						nbdiv++;
					}
					j--;
				}
				// si le nombre de division est de 1 ou de 2 alors il est premier
				if(nbdiv <=2 ) {
					System.out.println(array[i]+" est premier");
				}
			}
			*/
			// Deux boucle for
			// vérifier si le nombre est premier		
		}
	}

}
