JAVA_HOME = ..

TEST_CLASS = Test.class
TEST_RUN = test_result.txt

all:  $(TEST_CLASS) $(TEST_RUN) 

$(TEST_CLASS):
	javac -classpath $(JAVA_HOME)/class:. Test.java

$(TEST_RUN):
	java -Djava.library.path=$(JAVA_HOME)/lib -classpath $(JAVA_HOME)/class:. Test > test_result.txt

clean: 
	rm -f *.txt *.class *.out *.serial
	rm -f $(JAVA_HOME)/data/X.txt
	rm -f $(JAVA_HOME)/data/Y.txt
