package Symmetric;
//thought it would be easier for me to implement Symmetric in only one file

//unlike other 2 algorithms, Symmetric doesn't have Main class hence implementing processor class with runnable
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


class Processor implements Runnable {
	//constructor Processor accepting ID to keep track
	private int ID;
	
	public Processor(int ID) {
		this.ID = ID;
	}
	public void run() {
		Date startTimer = new Date();
		Random rand = new Random();
		//S
		Scanner get = new Scanner(System.in); 
		
	   // System.out.print("Choose Matrix row: ");     
	    int row = 16;
	    		//get.nextInt() ;
	       
	   // System.out.print("Choose Matrix column: ");
	    int column = 16; 
		
	    System.out.println("\nStart multiplying with Thread: " + ID + " ");
		
		int[][] matrix1 = matrixGenerator.createMatrix(row, column);
		int[][] matrix2 = matrixGenerator.createMatrix(row, column);
		int[][] resultMatrix = matrixGenerator.createMatrix(row, column);
		MultiplyTwoMatrices[][] matrix= new MultiplyTwoMatrices[row][column];
		

		 for(int i=0;i<row;i++){
		      for(int j=0;j<column;j++) {
		         matrix[i][j]=new MultiplyTwoMatrices(matrix1,matrix2,resultMatrix,i,j,column);
		         matrix[i][j].start();
		       }
		     }
		   
		     for(int i=0;i<row;i++)
		     {
		         for(int j=0;j<column;j++)
		         {
		             matrix[i][j].run();
		         }
		     } 
		     System.out.println();
		     
		     System.out.println("Result");
		     System.out.println();
		     for(int i=0;i<row;i++)
		     {
		         for(int j=0;j<column;j++)
		         {
		            System.out.print(resultMatrix[i][j]+" ");
		         }    
		         System.out.println();   
		     }      
		
		Date endTimer = new Date();
		System.out.println("Multiplying ended. Thread: " + ID + "\nmultiplication time in ms:  " + (endTimer.getTime() - startTimer.getTime()));
		
		}
	}

public class Main {

	public static void main(String[] args) 
	{
		Date startTimer = new Date();
		//make threads
		for(int t = 0; t < 3 ; t++) {
		Thread thread = new Thread(new Processor(t));
		thread.start();
		
		//added  sleep to try to fix synchronise.
		try {
			thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
	
		Date endTimer = new Date();
		System.out.println("Total operation Time:  " + (endTimer.getTime() - startTimer.getTime()) +"ms");;
	}
}

