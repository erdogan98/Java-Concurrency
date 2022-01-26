package Task1;
import java.util.Random;
import java.util.Scanner;

//TASK1
public class Matrix_multiplication extends Thread{

	public static void main(String[] args){  
    	//make user to choose the matrix dimensions
    	Scanner matrixInput = new Scanner(System.in);
    	System.out.println("Choose the length of your matrix ");
    	System.out.println("ROW:");
    	int row = matrixInput.nextInt();
    	System.out.println("Column:");
    	int column = matrixInput.nextInt();
    	  
    	//creating two matrices     
    	int [][] matrix1 = new int[column][row];	
    	int [][] matrix2 = new int[column][row];    
    	int [][] resultMatrix = new int[column][row];
    	
    	//random int
    	Random rand = new Random();
    	int randomNum = rand.nextInt(10);
    	
    	//filling matrices with random numbers
    	
    	System.out.println("MATRIX 1: ");
        
		for (int i = 0; i < matrix1.length; i++) { 
            for (int j = 0; j < matrix1[i].length; j++) {
              matrix1[i][j] = rand.nextInt(randomNum);
               System.out.print(matrix1[i][j] + " ");
            }
    		System.out.println();
    	}
        
    	System.out.println("MATRIX 2: ");
        for (int i = 0; i < matrix2.length; i++) { 
            for (int j = 0; j < matrix2[i].length; j++) {
              matrix2[i][j] = rand.nextInt(randomNum);
               System.out.print(matrix2[i][j] + " ");       
            }
    		System.out.println();
    	}//printing the result matrix
        System.out.println("RESULT MATRIX: ");   
    for(int i=0;i<matrix1.length;i++){
    	for(int j=0;j<matrix2.length;j++){
    	    resultMatrix[i][j]=0;      
    	    for(int k=0;k<resultMatrix.length;k++)      
    	    {      
    	    	resultMatrix[i][j]+=matrix1[i][k]*matrix2[k][j];      
    	     
    	    }//end of k loop  
    	    
    	    System.out.print(resultMatrix[i][j]+" ");   
    	    
    	}   
    	System.out.println(); 
    	 
    }    
    System.out.print("END");
    }
    
}  
    	

