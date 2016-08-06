//TODO: Add a way to quit without ^C.
public class Main {

	public static void main(String[] args) {
	boolean loop = true;
		
			   Enigma mainEnigma = new Enigma();
			   while (loop){
		      loop = mainEnigma.enigma(mainEnigma.r1, mainEnigma.r2, mainEnigma.r3, mainEnigma.ref1, mainEnigma.plugb);
		   }
		   }

	}
