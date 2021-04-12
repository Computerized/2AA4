This directory contains a half-baked implementation of 2048
How to play:
Press direction arrows to shift, ESC to exit.
Game ends when you have no moves

Due to this implementation using javax.swing for its GUI, it will not be able to run
fully on the Mills server. However, the make test and make doc do function just fine on Mills.
To run this program, it will have to be on a computer with java.awt and javax.swing installed. 
To run the program, make the active directory src and compile and run Game.java via:
javac Game.java
java Game
Do not try to compile the JUnit test files when doing this (such as by doing javac *.java), it won't
work, trust me.