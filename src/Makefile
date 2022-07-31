JAVA_HOME = ..
SRC = $(JAVA_HOME)/src

# For package BayesMNIWConjugate
JC = javac
JFLAGS = -d
JAVA_SRC = $(SRC)/BayesMNIW.java $(SRC)/fileinput.java
PACKAGE = $(JAVA_HOME)/class/BayesMNIWConjugate
SUBPACKAGES_CLASS_PATH = $(JAVA_HOME)/class

all: subpackage $(PACKAGE)

subpackage:
	@mkdir -p $(@D)
	$(MAKE) -C ../JAMAJniGsl/src

$(PACKAGE): subpackage $(JAVA_SRC)
	@mkdir -p $(@D)
	ln -s ../JAMAJniGsl/class/JAMAJniGsl $(JAVA_HOME)/class/JAMAJniGsl
	ln -s ../JAMAJniGsl/lib $(JAVA_HOME)/lib
	$(JC) $(JFLAGS) $(JAVA_HOME)/class -classpath $(SUBPACKAGES_CLASS_PATH):. $(JAVA_SRC)

clean: 
	rm -fr $(JAVA_HOME)/class
	rm -fr $(JAVA_HOME)/lib
	rm $(JAVA_HOME)/JAMAJniGsl
