package codinGame;

import java.util.Arrays;
// ce projet nous permet de dessiner des schémas selon des symboles se trouvant un tableau
public class Typewriter  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String sentence = "1sp 123 w 5 10bS 2bS 3f 1/ 1bS 1_ 1/ 1bS nl 1( 1sp 1o 1. 1o 1sp 1) nl 1sp 1> 1sp 1^ 1sp 1< nl 2sp 3|";
		//String sentence = "1sp 1/ 1bS 1_ 1/ 1bS nl 1( 1sp 1o 1. 1o 1sp 1) nl 1sp 1> 1sp 1^ 1sp 1< nl 2sp 3|";
		//String sentence ="18sp 1: nl 18sp 1: nl 7sp 2, 9sp 1: 9sp 2, nl 7sp 2: 9sp 1: 9sp 2: nl 2, 5sp 2: 9sp 1: 9sp 2: 5sp 2, nl 2: 5sp 2: 9sp 1: 9sp 2: 5sp 2: nl 1sp 1sQ 2: 1. 3sp 1sQ 2: 1. 6sp 1: 6sp 1. 2: 1sQ 3sp 1. 2: 1sQ nl 4sp 1sQ 2: 1. 2sp 1sQ 2: 1. 2sp 1_ 1/ 1~ 1bS 1_ 2sp 1. 2: 1sQ 2sp 1. 2: 1sQ nl 6sp 1sQ 2: 1. 2sp 3: 1/ 5sp 1bS 3: 2sp 1. 2: 1sQ nl 8sp 1sQ 5: 1( 7sp 1) 5: 1sQ nl 15sp 1bS 1sp 3_ 1sp 1/ nl 9sp 1. 5: 1/ 1` 3sp 1` 1bS 5: 1. nl 7sp 1. 2: 1sQ 3sp 1. 1: 1bS 1o 1sp 1o 1/ 1: 1. 3sp 1sQ 2: 1. nl 5sp 1. 2: 1sQ 3sp 1. 2: 2sp 1: 1sQ 1: 2sp 2: 1. 3sp 1sQ 2: 1. nl 3sp 1. 2: 1sQ 4sp 2: 1sQ 3sp 1sQ 1sp 1sQ 3sp 1sQ 2: 4sp 1sQ 2: 1. nl 2sp 2: 6sp 2: 13sp 2: 6sp 2: nl 2sp 2^ 6sp 2: 13sp 2: 6sp 2^ nl 10sp 2: 13sp 2: nl 10sp 2^ 13sp 2^";
		String sentence="1sp 1[ 1] 1[ 1] 1[ 1] 1sp 1/ 2sQ 1bS 1sp 1[ 1] 1[ 1] 1[ 1] nl 2sp 1| 2: 1| 1sp 1/ 4_ 1bS 1sp 1| 2: 1| nl 2sp 1| 1[ 1] 1| 1_ 1| 4: 1| 1_ 1| 1[ 1] 1| nl 2sp 1| 6: 2_ 6: 1| nl 2sp 1| 5: 1/ 2| 1bS 5: 1| nl 2sp 1| 1: 1# 3: 4| 2: 1# 2: 1| nl 2sp 168 nl 1sp 88 2sp 88 nl 1sp 78 4sp 78";
		//String sentence="10sp 5_ nl 9sp 1/ 4sp 1/ 1bS nl 8sp 1/ 4sp 1/ 2sp 1bS nl 7sp 1/ 4sp 1/ 4sp 1bS nl 6sp 1/ 4sp 1/ 2sp 1/ 1bS 2sp 1bS nl 5sp 1/ 4sp 1/ 2sp 1/ 2sp 1bS 2sp 1bS nl 4sp 1/ 4sp 1/ 2sp 1/ 1bS 3sp 1bS 2sp 1bS nl 3sp 1/ 4sp 1/ 2sp 1/ 2sp 1bS 3sp 1bS 2sp 1bS nl 2sp 1/ 4sp 1/ 2_ 1/ 4_ 1bS 3sp 1bS 2sp 1bS nl 1sp 1/ 14sp 1bS 3sp 1bS 2sp 1bS nl 1/ 16_ 1bS 3sp 1bS 2sp 1bS nl 1bS 21_ 1bS 1sp 1/";

		String[] array = sentence.split(" ");
        System.out.println(Arrays.toString(array));
        
        for(int i=0; i < array.length; i++) {        	
        	String mot = array[i];
        	
        	if(mot.length()==1) {
    			// (long minimum) si la longueur du mot ne dépasse pas 1 alors l'afficher directement	
    			System.out.print(mot);	
    			
    		}else if(isentier(mot)) {
        		// si le mot est un entier au complet
      
        		// prendre le dernier chiffre de ce long chiffre car c'est lui qu'on va répéter
        		char c =mot.charAt(mot.length()-1);
        		// soulever le nombre de repetition
        		int nbRepetition = repetition(mot,mot.length()-1);        		
        		afficherChar(c,nbRepetition);

        	}else if(mot.length()==2) {
        				//si le mot ne contient pas d'entier et il est de 2lettre c'est nl/sp/bs/sq
		    		if(!Character.isDigit(mot.charAt(0))){
		    				afficherString(mot);	
				  	}else {
						    // le mot de 2lettres un chiffre et l'autre non 
				  			int nbRepetition = repetition(mot, mot.length()/2);
				    		afficherChar(mot.charAt(1),nbRepetition);
				  	}
    		}else{
        		    // si le mot est un mélange de chiffre et symbole	
        		if(mot.length()==4){
        			// (long maximum) si la longueur du mot est de 4 c-a-d un chiffre de deux et deux symboles qui sont des lettres soit nl/sp/bs/sq
        			int nbRepetition = repetition(mot, mot.length()/2 );
        			// concatener les caractère restant pour savoir ce que c'est
        			
        			String str ="";
        			for(int k=mot.length()/2; k < mot.length(); k++) {   
            			str = str+mot.charAt(k);            			
            		}
        			// vérifier la signification et l'afficher selon le nombre de répétition correspondant
            		
        			for(int rep=1; rep <= nbRepetition; rep++) {
        				afficherString(str);		
            		}			
        		}else {
        			
	        		// lire le mot de longeur moyenne 
		        	for(int j=0; j < mot.length()-1; j++) {
		        		char c1 = mot.charAt(j);
		        		
		        		//vérier le premier caractère
		        		if(!Character.isDigit(c1)) {
		        			if(mot.length()==2) {
		        			// si le premier caractère n'est pas un chiffre
		        			
		        				String str = mot.substring(j,j+2) ;
		        				afficherString(str);	   
		        				}     			 
		        		}else {
		        			// si le premier caractère est un chiffre
		        			
		        			char c2 =  mot.charAt(j+1);
		        			if(!Character.isDigit(c2)) {
		        				// si le deuxième caractère n'est pas un chiffre
		        				
		        				if(mot.length()==3) {
		        					
		        					int nbRepetition = Character.getNumericValue (c1);
		        					String str = mot.substring(mot.length()-2,mot.length());
		        					
		        					for(int k=1; k<= nbRepetition; k++) {
		        						afficherString(str);
		        					}
		        				}
		        				if(mot.length()==2){
		        					int nbRepetition = Character.getNumericValue (c1);		        					
		        					afficherChar(c2,nbRepetition);	
		        				}
		        			}else {
		        				// les deux premiers caractères sont des chiffres et le troisième est un symbole
		        				
		        				
		    	        		int nbRepetition = repetition(mot,mot.length()-1);
		        				afficherChar(mot.charAt(mot.length()-1),nbRepetition);
		        			}
		        		}
		        		
		        	}
	        	}
        	}
        }
        
        
        
        
        
       
		
	}
	
	public static boolean isentier(String mot) {
		
		try {
			Integer.parseInt(mot);
			
			return true;
		}catch (Exception e){
			return false;
		}
		
	}
	public static void afficherString(String str) {
		
		if(str.equals("sp")) {
			System.out.print(" ");
		}else
		if(str.equals("bS")) {
			System.out.print("\\");
		}else
		if(str.equals("sQ")) {
			System.out.print("'");
		}else
		if(str.equals("nl")) {
			System.out.print("\n");
		}
	}
	public static void afficherChar(char c, int nbrepetition) {
		for(int k=1; k<= nbrepetition; k++) {
			System.out.print(c);
		}
	}
	public static int repetition(String mot, int length) {
		String nbRepetitionStr = "";
		for(int i=0; i < length;i++) {
			nbRepetitionStr= nbRepetitionStr + mot.charAt(i);
		}
		int nbRepetition = Integer.parseInt(nbRepetitionStr);
		return nbRepetition;
	}
	

}
