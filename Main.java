public class Main {

	public static void main(String[] args) {
	boolean loop = true;
		
			   Enigma mainEnigma = new Enigma();
			   
			   Rotor rot1 = new Rotor(mainEnigma.r1);
			   Rotor rot2 = new Rotor(mainEnigma.r2);
			   Rotor rot3 = new Rotor(mainEnigma.r3);
			   Rotor refl = new Rotor(mainEnigma.ref1);
			   Rotor plug = new Rotor(mainEnigma.plugb);

			   while (loop){
		      loop = mainEnigma.enigma(rot1, rot2, rot3, refl, plug);
		   }
		   }

	}
