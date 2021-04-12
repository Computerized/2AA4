#Path separator is different on Windows versus Unix based OSes
ifeq ($(OS),Windows_NT)
	SEP=;
else
	SEP=:
endif

JFLAGS = -g
JCLASS = -cp "src$(SEP).$(SEP)../junit-4.5.jar"
JC = javac
JVM = java

.PHONY: test doc expt

run:
	cd A4/src
	javac Board.java
	javac GUI.java
	javac ActiveBoard.java
	javac Game.java
	java Game
	cd A4

test:
	find . -name '*.class' -exec rm -f {} \;
	$(JC) $(JCLASS) $(JFLAGS) src/AllTests.java
	$(JVM) $(JCLASS) org.junit.runner.JUnitCore AllTests

doc:
	doxygen doxConfig
	cd latex && $(MAKE)

clean:
	rm -rf html
	rm -rf latex
	cd src
	rm **/*.class