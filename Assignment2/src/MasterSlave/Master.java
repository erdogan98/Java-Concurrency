package MasterSlave;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Master {
    public static void main(String[] args)
   {    
       Scanner get = new Scanner(System.in); 
        
       Random rand = new Random();
       int randomNum = rand.nextInt(10);
       
       System.out.print("Matrix A row: ");     
       int rowA=get.nextInt() ;
        
       System.out.print("Matrix A column: ");
       int columnA=get.nextInt();
       
       System.out.print("Matrix B row: ");     
       int rowB=get.nextInt();
       
       System.out.print("Matrix B column: ");
       int columnB=get.nextInt();
       System.out.println();
        
       if(columnA!=rowB) 
       {
            System.out.println("Matrix multiplication cannot be done!!");
            System.exit(-1);
       }
       
    System.out.println("Matrix dimensions are "+rowA +" x "+columnB);
    System.out.println();
    
    Date start = new Date();
    int[][] matrix1=new int[rowA][columnA];
    int[][] matrix2=new int[rowB][columnB]; 
    int[][] matrix3=new int[rowA][columnB];
    multiplyMatrix[][] thrd= new multiplyMatrix[rowA][columnB];


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
    }
    
     for(int i=0;i<rowA;i++){
      for(int j=0;j<columnB;j++) {
         thrd[i][j]=new multiplyMatrix(matrix1,matrix2,matrix3,i,j,columnA);
         thrd[i][j].start();
       }
     }
   
     for(int i=0;i<rowA;i++)
     {
         for(int j=0;j<columnB;j++)
         {
             thrd[i][j].run();
         }
     } 
     System.out.println();
     
     System.out.println("Result");
     System.out.println();
     for(int i=0;i<rowA;i++)
     {
         for(int j=0;j<columnB;j++)
         {
             System.out.print(matrix3[i][j]+" ");
         }    
         System.out.println();   
     }      
     Date end = new Date();
     System.out.println("\nmultiplication time in ms:  " + (end.getTime() - start.getTime()));
   }
}
