package Symmetric;
import java.util.Random;
public class matrixGenerator {
	public static int[][] createMatrix(int row,int column){
		//store matrix values
		int[][] resultMatrix = new int[row][column];
		
		//random num
		Random rand = new Random();
		
		//fill matrices
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				resultMatrix[i][j] = rand.nextInt(10);
			}
		}
		 
		//output
		return resultMatrix;
	}
	
	//prints matrix
	public static void print(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; i < column; i++) {
			System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
