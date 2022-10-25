package org.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IllegalDimensionException, NoSquareException {
        for(;;) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int chooseNumber = scanner.nextInt();
            switch (chooseNumber) {
                case 1:
                    Matrix matrix1 = enterData();
                    Matrix matrix2 = enterData();
                    printMatrix(addition(matrix1, matrix2));
                    break;
                case 2:
                    Matrix matrix3 = enterData();
                    Matrix matrix4 = enterData();
                    printMatrix(subtraction(matrix3, matrix4));
                    break;
                case 3:
                    Matrix matrix5 = enterData();
                    Matrix matrix6 = enterData();
                    printMatrix(multiply(matrix5, matrix6));
                    break;
                case 4:
                    Matrix matrix7 = enterData();
                    printMatrix(transpose(matrix7));
                    break;
                case 5:
                    Matrix matrix8 = enterData();
                    System.out.println(determinant(matrix8));
                    break;
                case 6:
                    Matrix matrix9 = enterData();
                    printMatrix(cofactor(matrix9));
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("This value is not exists. Please, enter value again.");
            }
        }
    }

    private static Matrix enterData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n rows:");
        int n = scanner.nextInt();
        System.out.println("Enter m colons:");
        int m = scanner.nextInt();
        Matrix matrix = new Matrix(n, m);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter n values:");
            for (int j = 0; j < m; j++) {

                matrix.setValueAt(i, j, scanner.nextDouble());
            }
        }
        System.out.println("\nYour Matrix:");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix.getValueAt(i, j) + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    private static void printMatrix(Matrix matrix) {
        System.out.println("\nYour Matrix:");
        for(int i = 0; i < matrix.getNrows(); i++) {
            for (int j = 0; j < matrix.getNcols(); j++) {
                System.out.print(matrix.getValueAt(i, j) + " ");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===============================================================");
        System.out.println("Hello, this is matrix calculator");
        System.out.println("===============================================================");
        System.out.println("Choose one of the following actions (write only the number):");
        System.out.println("1 - Addition 2 matrix");
        System.out.println("2 - Subtraction 2 matrix");
        System.out.println("3 - Multiply 2 matrix");
        System.out.println("4 - Transponse matrix");
        System.out.println("5 - Determinant matrix");
        System.out.println("6 - Cofactor matrix");
        System.out.println("7 - Exit");
    }
    public static Matrix addition(Matrix matrix1, Matrix matrix2) {
        if (matrix1 == null || matrix2 == null) return null;
        if (matrix1.getNcols() != matrix2.getNcols() || matrix1.getNrows() != matrix2.getNrows())
            return null;
        Matrix sumMatrix = new Matrix(matrix1.getNrows(), matrix1.getNcols());
        for (int i = 0; i < matrix1.getNrows(); i++) {
            for (int j = 0; j < matrix1.getNcols(); j++)
                sumMatrix.setValueAt(i, j, matrix1.getValueAt(i, j) + matrix2.getValueAt(i, j));
        }
        return sumMatrix;
    }

    public static Matrix subtraction(Matrix matrix1, Matrix matrix2) {
        if (matrix1 == null || matrix2 == null) return null;
        return addition(matrix1, matrix2.multiplyByConstant(1));
    }


    public static Matrix multiply(Matrix matrix1, Matrix matrix2) throws IllegalDimensionException {
        if(matrix1 == null || matrix2 == null) return null;
        if(matrix1.getNcols() != matrix2.getNrows()) throw new IllegalDimensionException("matrix1 colons should be equals matrix2 rows");
        Matrix multipliedMatrix = new Matrix(matrix1.getNrows(), matrix2.getNcols());

        for (int i=0;i<multipliedMatrix.getNrows();i++) {
            for (int j=0;j<multipliedMatrix.getNcols();j++) {
                double sum = 0.0;
                for (int k=0;k<matrix1.getNcols();k++) {
                    sum += matrix1.getValueAt(i, k) * matrix2.getValueAt(k, j);
                }
                multipliedMatrix.setValueAt(i, j, sum);
            }
        }
        return multipliedMatrix;
    }

    public static Matrix transpose(Matrix matrix) {

    }

    public static double determinant(Matrix matrix) throws NoSquareException {

    }

    private static Matrix createSubMatrix(Matrix matrix, int excluding_row, int excluding_col) {

    }

    private static int changeSign(int i) {

    }

    public static Matrix cofactor(Matrix matrix) throws NoSquareException {

    }
}
