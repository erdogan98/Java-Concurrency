package Symmetric;
class MultiplyTwoMatrices extends Thread {
	
	private final int[][] matrix1;
	private int[][] matrix2;
	private int[][] resultMatrix;
	private int row;
	private int col;
	private int dimension;
	
	public MultiplyTwoMatrices (int[][] matrix1, int[][] matrix2, int[][] resultMatrix, int row, int col, int dimension) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.resultMatrix = resultMatrix;
		this.row = row;
		this.col = col; 
		this.dimension = dimension;
	} 

	public void run() {	
		for (int i = 0; i < dimension; i++) {
			resultMatrix[row][col] += matrix1[row][i]*matrix2[i][col];
			
		}
				System.out.println("row " + row + " " +"col "+ col + " completed" ); 
		}
	}
	

