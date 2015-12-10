import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO:
// Allow user to rearrange and set rotors
// Allow user to set plugboard
// Implement other rotors and reflectors.

class Enigma {

public static void main (String[]args) {
boolean keep = true;
Rotor r1 = new Rotor();
Rotor r2 = new Rotor();
Rotor r3 = new Rotor();
Rotor r4 = new Rotor();
Rotor r5 = new Rotor();
Rotor reflect = new Rotor();

//Plugboard isn't a rotor, but we can use the cypher to get the same effect.
Rotor plugboard = new Rotor();


boolean doublestep = false;

r1.setCypher("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
r1.setOffset(0);
r1.setRollover(17);
r2.setCypher("AJDKSIRUXBLHWTMCQGZNPYFVOE");
r2.setOffset(4);
r2.setRollover(5);
r3.setCypher("BDFHJLCPRTXVZNYEIWGAKMUSQO");
r3.setOffset(0);
r3.setRollover(22);
r4.setCypher("ESOVPZJAYQUIRHXLNFTGKDCMWB");
r4.setRollover(9);
r5.setCypher("VZBRGITYUPSDNHLXAWMJQOFECK");
r5.setRollover(0);
reflect.setCypher("YRUHQSLDPXNGOKMIEBFZCWVJAT");
//plugboard.setCypher("ROSZPTIUGJKWMQBENACFHVLXYD");
//                   ABCDEFGHIJKLMNOPQRSTUVWXYZ



String input = "i feel pretty oh so pretty i feel pretty and fiiiiiiiiine";
char temp;
int i = 0;

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
if (r2.getOffset() == r2.getRollover()-1) {
   doublestep = true;
   }

r1.advance();
if (doublestep) {
r2.advance();
r3.advance();
doublestep = false;
}
 if (r1.getOffset() == r1.getRollover()) {
  r2.advance();
 
   if (r2.getOffset() == r2.getRollover()) {
   r3.advance();
   }
   }

temp = plugboard.plugIn(temp);
temp = r1.input(temp);
temp = r2.input(temp);
temp = r3.input(temp);
temp = reflect.input(temp);
temp = r3.output(temp);
temp = r2.output(temp);
temp = r1.output(temp);
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
System.out.println("\nRotor 1: " + r1.getOffset() + " Rotor 2: " + r2.getOffset() + " Rotor 3: " + r3.getOffset());
}
}
}
}

