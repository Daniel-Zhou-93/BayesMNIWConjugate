# BayesMNIWConjugate
BayesMNIWConjugate is a Java package providing methods for Bayesian Multivariate Conjugate Linear Modeling which is widely used in Bayesian Geostatisitics. This package uses Java classes created by another package, JAMAJniGsl(You will not need to download it separately. They are included in this package). JAMAJniGsl is a highly computing efficient and user-friendly numerical linear algebra package, which helps to perform matrix operations and do sampling in BayesMNIWConjugate. 


Build Instructions
------------------

* Before compiling, you may have to go into the Makefile of JAMAJniGsl to change the extension of generated libraries based on your operating system. On OS X you have to change all the extensions of dynamic library to `.dylib` while on Linux the corresponding extensions are `.so`. Specific steps are described below.

* For JAMAJniGsl, enter JAMAJniGsl/src directory and copy the makefile based on the operating system.

For Linux user, use the following commands:
```
cd src
cp Makefile.linux Makefile
Make
```

For Mac user, use the following commands:
```
cd src
cp Makefile.mac Makefile
Make
```

* To compile the package, enter src directory and execute `make`.
This will first build the necessary libraries and packages for JAMAJniGsl and then build BayesMNIWConjugate. You don't have to do extra things for building subpackages.

* To clean generated files, type `make clean` on the command line. 

Data Format Preprocessing
-----------------

* To preprocess data, you need to install R software in advance.

* Enter data directory. Then open R environment and type `source("DataFormat.R")`. Then you will find two text files named X and Y generated under data directory.

* Notice: in your raw data, you should put Y in the first column and X in the rest columns.

Running the test
-----------------
* For testing, enter test directory and execute `make` . If you want to clean testing results and all class files, type `make clean`. 

* Notice: before running test, you have to preprocess data and execute `make` in the src directory.

Source Repository
-----------------
BayesMNIWConjugate's source-code repository is hosted here on GitHub: 
https://github.com/YuzhengDun1999/BayesMNIWConjugate


Authors
---------

| Name   | Email       |              |
|:------ |:----------- | :----------- |
| Yuzheng Dun (maintainer) | yuzhengdun1999@hust.edu.cn | Visiting student, Department of Biostatistics  UCLA|
| Sudipto Banerjee | sudipto@ucla.edu   | Professor, Department of Biostatistics  UCLA |
<!--- --->
                             


Licensing
---------
BayesMNIWConjugate is licensed under the Creative Commons Attribution License. 



