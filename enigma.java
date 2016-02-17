import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO:
// Allow user to rearrange and set rotors
// Allow user to set plugboard
// Implement other rotors and reflectors.

class Enigma {

   public void main (String[]args) {
      Rotor r1 = new Rotor();
      Rotor r2 = new Rotor();
      Rotor r3 = new Rotor();
      Rotor r4 = new Rotor();
      Rotor r5 = new Rotor();
      Rotor rfl = new Rotor();
   
   //Plugboard isn't a rotor, but we can use the cypher to get the same effect.
      Rotor pgbd = new Rotor();
   
   
      r1.setCypher("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
      r1.setOffset(0);
      r1.setRollover(17);
      r2.setCypher("AJDKSIRUXBLHWTMCQGZNPYFVOE");
      r2.setOffset(0);
      r2.setRollover(5);
      r3.setCypher("BDFHJLCPRTXVZNYEIWGAKMUSQO");
      r3.setOffset(0);
      r3.setRollover(22);
      r4.setCypher("ESOVPZJAYQUIRHXLNFTGKDCMWB");
      r4.setRollover(9);
      r5.setCypher("VZBRGITYUPSDNHLXAWMJQOFECK");
      r5.setRollover(0);
      rfl.setCypher("YRUHQSLDPXNGOKMIEBFZCWVJAT");
   //plugboard.setCypher("ROSZPTIUGJKWMQBENACFHVLXYD");
   //                   ABCDEFGHIJKLMNOPQRSTUVWXYZ
   
   

      Rotor rot1 = r1;
      Rotor rot2 = r2;
      Rotor rot3 = r3;
      Rotor reflector = rfl;
      Rotor plugboard = pgbd;
      String input = "test";
      try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
           input = bufferRead.readLine();
         
         }
         catch(IOException e)
         {
            e.printStackTrace();
         }

      char temp = input.charAt(1);
      switch (temp) {
      case '-':
      options(input);
      break;
      default:
      enigma(rot1, rot2, rot3, rfl, pgbd);
      break;
      }
   }
      
   void enigma(Rotor rot1, Rotor rot2, Rotor rot3, Rotor reflect, Rotor plugboard) {
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
                  temp = reflect.input(temp);
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
      
   void options(String input) {
     char temp = input.charAt(2);
      switch (temp) {
         case 'r':
            rotors(input);
            break;
         case '1':
         case '2':
         case '3':
            positions(input);
            break;
         case 'p':
            plugboards(input);
            break;
         default:
         //enigma(rot1,rot2,rot3,rfl,pgbd); // TODO: inherit rot1, etc. from main().
         break;
      }
   }

   void rotors(String input) {
   char temp = input.charAt(3);
      char newRotor = input.charAt(4);
      switch (temp){
         case '1':
         // Set rot1 according to newRotor.
         break;
         case '2':
         break;
         case '3':
         break;
         default:
         break;
         
      }
   
   }

   void positions(String input) {
   // Determine which rotor by input.charAt(3), and parse 4 and 5 to determine where to set the rotor.
   
   }

   void plugboards(String input) {
   // Set up the plugboard settings based on the alphabetic string entered.
   // TODO: actually determine how to go about this. Pairs of letters separated by spaces? Seems easier than one big 20-character alphabet soup.
   
   }

}
