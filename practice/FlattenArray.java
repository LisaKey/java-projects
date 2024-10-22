package practice;

import java.util.Arrays;
// ce projet consiste à transformer un tableau à deux dimensions en un tableau à une dimension
public class FlattenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ayant un tableau à deux dimensions
		int[][] array = new int[][] {{1, 2, 3},{4, 5, 6}};
		// trouver la taille du tableau à une dimesion en lisant celui à deux dimension
		int size = 0;
		for(int row=0; row<array.length; row++) {
			for(int column=0; column< array[row].length; column++) {		
				 if(array[row][column]!=0) {
					 size++;				 
				 }	 
			}
		}
		System.out.println("La taille de notre flattenArray : "+size);
		int[] arrayFlatten = new int[size];
		int i = 0;
		for(int row=0; row<array.length; row++) {
			for(int column=0; column< array[row].length; column++) {		
				 arrayFlatten[i] = array[row][column];
				 i++;
			}
		}
		System.out.println("FlattenArray is :\n"+ Arrays.toString(arrayFlatten));
		
	}

}
