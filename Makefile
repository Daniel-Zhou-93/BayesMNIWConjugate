JAVA_SRC = src
PACKAGE = class/JAMAJniGsl
SUBPACKAGES_CLASS_PATH = class
JC = javac
JFLAGS = -d

all: package 

package:
	$(MAKE) -C JAMAJniGsl
	$(MAKE) -C src
	$(MAKE) -C test
	
clean:
	$(MAKE) clean -C test
	$(MAKE) clean -C src
	$(MAKE) clean -C JAMAJniGsl

