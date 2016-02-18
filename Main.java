
public class Main {

	public static void main(String[] args) {
		
			   Enigma mainEnigma = new Enigma();
			   
			   Rotor rot1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ",0,17);
			   Rotor rot2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE",0,5);
			   Rotor rot3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO",0,22);
			   Rotor reflector = new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT",0,0);
			   Rotor plugboard = new Rotor();
		      mainEnigma.enigma(rot1, rot2, rot3, reflector, plugboard);
		   }

	}