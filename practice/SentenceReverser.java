package practice;

import java.util.Arrays;
import java.util.Scanner;
// ce projet reverse une phrase dans un tableau
public class SentenceReverser {

	public static void main(String[] args) {
		System.out.println("Write a sentence :");
		try (// TODO Auto-generated method stub
		Scanner src = new Scanner(System.in)) {
			String word = src.nextLine();
			String[] array = word.split(" ");
			String[] arrayReverse = new String[array.length];
			for(int i=0; i < array.length; i ++) {
				arrayReverse[i]=array[array.length-1-i];	
			}
			System.out.println(Arrays.toString(arrayReverse));
		}
	}

}
