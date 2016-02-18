# enigma-java
A program which emulates Enigma, written in Java.

Currently only emulates the M3 Army version, with rotors I-V. Plugboard settings are defined at compile-time, but the rotors can be swapped and repositioned at runtime now.

To change out the rotors, use the following commands:
-rXY, where X is the rotor position (1-3) and Y is the rotor to use (1-5).

-oXY, where X is the rotor position (1-3) and Y is the offset for that rotor (0-25)
