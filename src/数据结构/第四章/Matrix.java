package 数据结构.第四章;

public class Matrix {
    public static void main(String[] args) {
        SparseMatrix sparseMatrix = new SparseMatrix(4, 4);

        sparseMatrix.add(1, 2, 1);
        sparseMatrix.add(0, 1, 2);
        sparseMatrix.add(2, 3, 3);

        sparseMatrix.print();
    }
}

class SparseMatrix {
    int rows;
    int cols;
    int size;
    int[][] matrix;

    public SparseMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows * cols][3];
        size = 0;
    }


    public void print() {
        System.out.println("稀疏矩阵的三元组表：");
        for (int i = 0; i < size; i++) {
            System.out.println(matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2]);
        }
    }

    public void add(int row, int col, int value) {
            matrix[size][0] = row;
            matrix[size][1] = col;
            matrix[size][2] = value;
            size++;
        }
    }

