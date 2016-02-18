import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO:
// Allow user to set plugboard
// Implement other rotors and reflectors.



 class Enigma {
	 
	   final Rotor r1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ",0,17);
	   final Rotor r2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE",0,5);
	   final Rotor r3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO",0,22);
	   final Rotor r4 = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB",0,9);
	   final Rotor r5 = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK",0,0);
	   final Rotor ref1 = new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT",0,0);
 
      
   void enigma(Rotor rot1, Rotor rot2, Rotor rot3, Rotor reflector, Rotor plugboard) {
         char temp;
      int i = 0;
            boolean keep = true;
            String input = "";
                  boolean doublestep = false;
      while (keep == true) {
         boolean loop = true;
      
         try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
           input = bufferRead.readLine();
         
         }
         catch(IOException e)
         {
            e.printStackTrace();
         }
      
         try {
            do {
            //for (int i = 0; i < input.length(); i++) {
               temp = input.charAt(i);
               if (temp == '-'){
            	   input = input.substring(1);
            	   options(input,rot1, rot2, rot3, reflector, plugboard);
               }
               if (Character.isLetter(temp)) {
                  temp = Character.toUpperCase(temp);
                  if (rot2.getOffset() == rot2.getRollover()-1) {
                     doublestep = true;
                  }
               
                  rot1.advance();
                  if (doublestep) {
                     rot2.advance();
                     rot3.advance();
                     doublestep = false;
                  }
                  if (rot1.getOffset() == rot1.getRollover()) {
                     rot2.advance();
                  
                     if (rot2.getOffset() == rot2.getRollover()) {
                        rot3.advance();
                     }
                  }
               
                  temp = plugboard.plugIn(temp);
                  temp = rot1.input(temp);
                  temp = rot2.input(temp);
                  temp = rot3.input(temp);
                  temp = reflector.input(temp);
                  temp = rot3.output(temp);
                  temp = rot2.output(temp);
                  temp = rot1.output(temp);
                  temp = plugboard.plugOut(temp);
               }
            
               System.out.print(temp);
            
               i++;
            } while (loop);
         }
         catch(IndexOutOfBoundsException e){
            loop = false;
            i = 0;
         }
         finally {
            System.out.println("\nRotor 1: " + rot1.getOffset() + " Rotor 2: " + rot2.getOffset() + " Rotor 3: " + rot3.getOffset());
         
         }
      }
   }
      
   void options(String input, Rotor rot1, Rotor rot2, Rotor rot3, Rotor reflector, Rotor plugboard) {
	 if (input.isEmpty()){
		 enigma(rot1,rot2,rot3,reflector,plugboard);
	 }
     char temp = input.charAt(0);
      switch (temp) {
         case 'r':
            rotors(input, rot1, rot2, rot3, reflector, plugboard);
            break;
         case 'o':
            positions(input, rot1, rot2, rot3, reflector, plugboard);
            break;
         case 'p':
            plugboards(input);
            break;
         default:
         enigma(rot1,rot2,rot3,reflector,plugboard); 
         break;
      }
   }

   void rotors(String input, Rotor rot1, Rotor rot2, Rotor rot3, Rotor reflector, Rotor plugboard) {
   char temp = input.charAt(1);
      char newRotor = input.charAt(2);
      switch (temp){
         case '1':
        	 switch(newRotor){
        	 case '1':
        		 rot1.setCypher(r1.getCypher());
        		 rot1.setRollover(r1.getRollover());
        		 break;
        	 case '2':
        		 rot1.setCypher(r2.getCypher());
        		 rot1.setRollover(r2.getRollover());
        		 break;
        	 case '3':
        		 rot1.setCypher(r3.getCypher());
        		 rot1.setRollover(r3.getRollover());
        		 break;
        	 case '4':
        		 rot1.setCypher(r4.getCypher());
        		 rot1.setRollover(r4.getRollover());
        		 break;
        	 case '5':
        		 rot1.setCypher(r5.getCypher());
        		 rot1.setRollover(r5.getRollover());
        		 break;
             default:
            	 rot1.setCypher(r1.getCypher());
            	 rot1.setRollover(r1.getRollover());
             break;
        	 }
         break;
         case '2':
        	 switch(newRotor){
        	 case '1':
        		 rot2.setCypher(r1.getCypher());
        		 rot2.setRollover(r1.getRollover());
        		 break;
        	 case '2':
        		 rot2.setCypher(r2.getCypher());
        		 rot2.setRollover(r2.getRollover());
        		 break;
        	 case '3':
        		 rot2.setCypher(r3.getCypher());
        		 rot2.setRollover(r3.getRollover());
        		 break;
        	 case '4':
        		 rot2.setCypher(r4.getCypher());
        		 rot2.setRollover(r4.getRollover());
        		 break;
        	 case '5':
        		 rot2.setCypher(r5.getCypher());
        		 rot2.setRollover(r5.getRollover());
        		 break;
             default:
            	 rot2.setCypher(r2.getCypher());
            	 rot2.setRollover(r2.getRollover());
             break;
        	 }
         break;
         case '3':
        	 switch(newRotor){
        	 case '1':
        		 rot3.setCypher(r1.getCypher());
        		 rot3.setRollover(r1.getRollover());
        		 break;
        	 case '2':
        		 rot3.setCypher(r2.getCypher());
        		 rot3.setRollover(r2.getRollover());
        		 break;
        	 case '3':
        		 rot3.setCypher(r3.getCypher());
        		 rot3.setRollover(r3.getRollover());
        		 break;
        	 case '4':
        		 rot3.setCypher(r4.getCypher());
        		 rot3.setRollover(r4.getRollover());
        		 break;
        	 case '5':
        		 rot3.setCypher(r5.getCypher());
        		 rot3.setRollover(r5.getRollover());
        		 break;
             default:
            	 rot3.setCypher(r3.getCypher());
            	 rot3.setRollover(r3.getRollover());
             break;
        	 }
         break;
         default:
         break;
         
      }
   input = input.substring(3);
   options(input, rot1, rot2, rot3, reflector, plugboard);
   }

  void positions(String input, Rotor rot1, Rotor rot2, Rotor rot3, Rotor reflector, Rotor plugboard) {
   // Determine which rotor by input.charAt(1), and parse 2 and 3 to determine where to set the rotor.
	  char rotnum = input.charAt(1);
	  int rotpos = Integer.parseInt(input.substring(2));
	  
	  
	  switch(rotnum){
	  case '1':
		  rot1.setOffset(rotpos);
		  break;
	  case '2':
		  rot2.setOffset(rotpos);
		  break;
	  case '3':
		  rot3.setOffset(rotpos);
		  break;
	  default:
		  break;			 
	  
	  }
   if (rotpos < 10){
	   options(input.substring(2), rot1, rot2, rot3, reflector, plugboard);
   } else {
	   options(input.substring(3), rot1, rot2, rot3, reflector, plugboard);
   }
   }

   void plugboards(String input) {
   // Set up the plugboard settings based on the alphabetic string entered.
   // TODO: actually determine how to go about this. Pairs of letters separated by spaces? Seems easier than one big 20-character alphabet soup.
   
   }

}
