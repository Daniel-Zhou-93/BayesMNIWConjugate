## R Program to format data for input in ../test/Test.java

data.input = read.csv("Bayesdata.csv", header=F)

Y = data.input[,1:3]
write.table(Y, "Y.txt", row.names=F, col.names=F)

X = data.input[,4:6]
##X = cbind(1, X)
write.table(X, "X.txt", row.names=F, col.names=F)

