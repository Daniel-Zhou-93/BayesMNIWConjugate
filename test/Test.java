import JAMAJniGsl.*;
import BayesMNIWConjugate.*;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public final class Test {
	private Test() {}
	public static void main(String[] args) {
        //
        //Load data
        //
        int matrix_layout = Matrix.LAYOUT.RowMajor;
        final int nrow = 1200;
        final int ncol = 6;
        final int xncol = 3;
	final int yncol = 3;
        Matrix X = new Matrix(nrow, xncol);
        String xfilename = "../data/X.txt";
        File xfile = new File(xfilename); 
        fileinput xfi = new fileinput();
        xfi.readmatrix(xfile, X);
        Matrix Y = new Matrix(nrow, yncol);
        String yfilename = "../data/Y.txt";
        File yfile = new File(yfilename);
        fileinput yfi = new fileinput();
        yfi.readmatrix(yfile, Y);
        //
        // Prepare the matrices and other parameters
        //
        int p = X.getColumnDimension();
	int q = Y.getColumnDimension();
        double vv = 3;
        double nsam = 500;
        Matrix mub = new Matrix(p,q);//μβ, p*q
        Matrix Vr = Matrix.identity(p,p);//p*p
	double[][] PhivPrior = {{1,0.1,0.1},{0.1,5,0.3},{0.1,0.3,10}};
	Matrix Phiv = 	new Matrix(PhivPrior);//phi q*q
        //double[] Siresult;
	Matrix BetaResult,SiResult;
        //
        //Doing Bayesian Conjugate Linear Regression
        //
	JniGslRng.seed();
        BayesMNIW Bayes = new BayesMNIW(Y, X, mub, Vr, Phiv, vv);
	int i;
	for(i=0; i<nsam; i++){
        	SiResult = Bayes.getSigmaResult();
        	printMatrix(matrix_layout, SiResult.getArray(), SiResult.getRowDimension(), SiResult.getColumnDimension());
		System.out.printf("%n");
		BetaResult = Bayes.getBetaResult(SiResult);
        	printMatrix(matrix_layout, BetaResult.getArray(), BetaResult.getRowDimension(), BetaResult.getColumnDimension());
		System.out.printf("%n");
	}
	JniGslRng.free();
    }

    //
    /* Print the matrix X */
    //
    private static void printMatrix(String prompt, int layout, double[][] X, int I, int J) {
    	System.out.println(prompt);
    	if (layout == Matrix.LAYOUT.ColMajor) {
    		for (int i=0; i<I; i++) {
    			for (int j=0; j<J; j++)
    				System.out.print("\t" + string(X[j][i]));
    			System.out.println();
    		}
    	}
    	else if (layout == Matrix.LAYOUT.RowMajor){
    		for (int i=0; i<I; i++) {
    			for (int j=0; j<J; j++)
    				System.out.print("\t" + string(X[i][j]));
    			System.out.println();
    		}
    	}
    	else{System.out.println("** Illegal layout setting");}
    }
    private static void printMatrix(int layout, double[][] X, int I, int J) {
        if (layout == Matrix.LAYOUT.ColMajor) {
            for (int i=0; i<I; i++) {
                for (int j=0; j<J; j++)
                    System.out.print("\t" + string(X[j][i]));
                System.out.println();
            }
        }
        else if (layout == Matrix.LAYOUT.RowMajor){
            for (int i=0; i<I; i++) {
                for (int j=0; j<J; j++)
                    System.out.print("\t" + string(X[i][j]));
                System.out.println();
            }
        }
        else{System.out.println("** Illegal layout setting");}
    }
    //
    /* Print the array X */
    //
    private static void printIntArray(String prompt, int[] X, int L) {
    	System.out.println(prompt);
    	for (int i=0; i<L; i++) {
    		System.out.print("\t" + string(X[i]));
    	}
    	System.out.println();
    }
    //
    /* Shorter string for real number */
    //
    private static String string(double re) {
    	String s="";
    	if (re == (long)re)
    		s += (long)re;
    	else
    		s += re;
    	return s;
    }
}
