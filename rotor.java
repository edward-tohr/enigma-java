class Rotor {
//The simple cypher each rotor performs.
String cypher = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

//The alphabet. Only here to look up letter offsets.
String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 

//Offset ranges from 0-25, and cooresponds to the rotor setting.
int offset = 0;

//The index at which the rotor advances the next rotor over.   
int rollover = 0;    

void advance(){
// Advances rotor by one step. Click!
// if offset goes beyond 25, it wraps back around to 0.
offset++;
if (offset == 26) { 
offset = 0; 
}
}

char input(char c){ 
// encyphers letters coming from keyboard to reflector.
// Take letter, convert to numerical offset via alpha.
// Add rotor offset to index.
// Get letter from cypher at that index.
// Get that letter's index from alpha.
// Subtract rotor offset from index.
// Return that index from alpha.
int i = alpha.indexOf(c);
i += offset;
i %= 26;
c = cypher.charAt(i);
i = alpha.indexOf(c);
i += 26;
i -= offset;
i %= 26;
return alpha.charAt(i);
}

char output(char c) { 
// encyphers letters coming from reflector to lampboard.
// Get numerical offset of letter from alpha.
// add rotor's offset to that index.
// Get alpha at that index.
// find that letter's index in cypher.
// get alpha at THAT index.
// subtract rotor's offset from that index.
// return alpha from there.
int i = alpha.indexOf(c);
i += offset;
i %= 26;
c = alpha.charAt(i);
i = cypher.indexOf(c);
i += 26;
i -= offset;
i %= 26;
return alpha.charAt(i);
}


void setCypher(String c) {
cypher = c;
}

void setOffset(int i) {
offset = i;
}

void setRollover(int i) {
rollover = i;
}

int getOffset(){
return offset;
}

int getRollover(){
return rollover;
}

String getCypher(){
return cypher;
}

char plugIn(char c){
//Plugboard just swaps ten pairs of letters, no roting or anything.
int i = alpha.indexOf(c);
return cypher.charAt(i);
}

char plugOut(char c) {
int i = cypher.indexOf(c);
return alpha.charAt(i);
}


void printRotor() {
// Prints out cypher key. Probably not useful,
// but may be handy when debugging?
for (int i = 0; i < 26; i++) {
System.out.print(cypher.charAt((i+offset)%26));
}
System.out.print("\n");
}



}

