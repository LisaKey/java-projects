package codinGame;

import java.util.Scanner;

public class PowerOfThor {

	private static Scanner in;

	public static void main(String[] args) {
		 in = new Scanner(System.in);
		 String[][] array= new String[18][40];
		 System.out.print("Entrez les coordonnées X et Y de Light :");
		 int lightX = in.nextInt(); // the X position of the light of power
	     int lightY = in.nextInt(); // the Y position of the light of power
	     System.out.print("Entrez les coordonnées X et Y de Thor :");
	     int initialTx = in.nextInt(); // Thor's starting X position
	     int initialTy = in.nextInt(); // Thor's starting Y position
	     System.out.println("light (Y, X) : "+lightY+","+lightX);
	     System.out.println("thor (Y, X) : "+initialTy+","+initialTx);
	     
	     System.out.println("========================================================================");
		 for(int y=0; y < array.length; y++ ) {
			 for(int x=0; x < array[y].length; x++) {
				 System.out.print("\t");
				 array[y][x]="$";
				 array[lightY][lightX]="light";
				 array[initialTy][initialTx]="thor";
				System.out.print(array[y][x]); 
			 }
			 System.out.println();
		 }
		 System.out.println("========================================================================");
		 
		 
	     String directionX="";
	     String directionY="";
		 if(initialTx < lightX) {
	         //  colonne thor est loin de la colonne du light
			 directionX="E";
			 while(initialTx<lightX) {	
				 initialTx+=1;
			 }
		 }else {
			 
			 directionX="W";
			 while(initialTx>lightX) {	
				initialTx-=1;
			 }
		}
		 if(initialTy < lightY) {
	         //  y thor est loin du y du light
			 directionY="S";
			 while(initialTy<lightY) {	
				 initialTy+=1;
			 }
		}else {
			directionY="N";
			while(initialTy>lightY) {	
				initialTy-=1;
			}
	    }
		 System.out.println("\n Thor's direction is : "+directionY.concat(directionX));
		 
		 
		 System.out.println("========================================================================");
		 for(int y=0; y < array.length; y++ ) {
			 for(int x=0; x < array[y].length; x++) {
				 System.out.print("\t");
				 //array[lightY][lightX]="light";
				 array[initialTy][initialTx]="New thor";
				 System.out.print(array[y][x]); 
			 }
			 System.out.println();
		 }
	        
	}

}
