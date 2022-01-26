package Symmetric;

import java.time.LocalTime;
import java.util.Date;
import java.util.Random;


public class Job{
	int Ctt;
	LocalTime LaDateTime;
	public boolean done;

	public Job(int Ptt, LocalTime PaDateTime) 
	{
		Date startTimer = new Date();
		Random rand = new Random(); 
		//Scanner get = new Scanner(System.in); 
		
		System.out.println("Multiplying ended. Thread: " + "\nmultiplication time in ms:  ");// + (endTimer.getTime() - startTimer.getTime()));
		

		   // System.out.print("Choose Matrix row: ");     
		    int row=10;
		    		//get.nextInt() ;
		        
		    //System.out.print("Choose Matrix column: ");
		    int column=10;
		    		//get.nextInt();
			
		    //System.out.println("Start multiplying with Thread: " + ID + " ");
			
			int[][] matrix1 = matrixGenerator.createMatrix(row, column);
			int[][] matrix2 = matrixGenerator.createMatrix(row, column);
			int[][] resultMatrix = matrixGenerator.createMatrix(row, column);
			MultiplyTwoMatrices[][] thrd= new MultiplyTwoMatrices[row][column];
			

			 for(int i=0;i<row;i++){
			      for(int j=0;j<column;j++) {
			         thrd[i][j]=new MultiplyTwoMatrices(matrix1,matrix2,resultMatrix,i,j,column);
			         thrd[i][j].start();
			       }
			     }
			   
			     for(int i=0;i<row;i++)
			     {
			         for(int j=0;j<column;j++)
			         {
			             thrd[i][j].run();
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
			     System.out.println("Multiplying ended. Thread: " + "\nmultiplication time in ms:  " + (endTimer.getTime() - startTimer.getTime()));
					
		done = false;
		
	}
}

