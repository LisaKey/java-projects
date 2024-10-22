package practice;

import java.util.Arrays;
import java.util.Scanner;
// ce projet classe les scores des participants selon le meilleur score
public class ScoreSorter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Quel est le total des participants : ");
		try (Scanner src = new Scanner(System.in)) {
			int size = src.nextInt();
			int[] array = new int[size];
			System.out.println("quels sont les scores : ");
			for(int i=0; i < array.length; i++) {
				array[i]=src.nextInt();
			}
			System.out.println("Quels est le meilleur score du jeu :");
			int score = src.nextInt();
			System.out.println("Voici le classement des scores :\n"+Arrays.toString(scoreSorter(array,score)));
		}	 
	}
	public static int[] scoreSorter(int[] array, int score) {		
		int x=0;
		for(int i=0; i < array.length; i++) {
			for(int j=0; j < array.length; j++) {
				if(array[i]>array[j]) {
					x=array[j];
					array[j]=array[i];
					array[i]=x;
				}
			}
		}
		return array;
	}
}
