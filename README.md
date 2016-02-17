# enigma-java
A program which emulates Enigma, written in Java.

Currently only emulates the M3 Army version, with rotors, rotor starting positions, and plugboard settings defined at compile-time.

Options should be configurable at runtime with various parameters.

-rXY, where X is the rotor position (1-3) and Y is the rotor to use (1-5).

-1P
-2P
-3P set the corresponding rotor number to position P (alphabetic? numeric? still TBD, but probably both).

-p to set the plugboard. This will most likely take space-delineated pairs of letters for the input.

None of the options currently work, but it's getting there.
