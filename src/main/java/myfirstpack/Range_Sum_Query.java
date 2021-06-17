/*
Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)

My Idea :

[3, 0, 1, 4, 2]           [3, 3, 4, 8, 10]                 [3,  3,  4,  8,  10]
[5, 6, 3, 2, 1]           [8,                              [8,  14, 18, 24, 27]
[1, 2, 0, 1, 5]  ----->   [9,              --------->>     [9,  17, 21, 28, 36]
[4, 1, 0, 1, 7]           [13,                             [13, ...
[1, 0, 3, 0, 5]           [14,                             [14, ...


 */

package myfirstpack;

import java.util.Scanner;

public class Range_Sum_Query {
  static int[][] mat;
  public static void fun()
  {
    //mat=grid;
    for(int i=1;i<mat.length;i++)
    {
      mat[i][0]+=mat[i-1][0];
    }
    for(int j=1;j<mat[0].length;j++)
    {
      mat[0][j]+=mat[0][j-1];
    }
    for(int i=1;i<mat.length;i++)
    {
      for(int j=1;j<mat[0].length;j++)
      {
        mat[i][j]=mat[i][j]+mat[i-1][j];
        mat[i][j]+=mat[i][j-1];
        mat[i][j]-=mat[i-1][j-1];
      }
    }
  }

  public static int sumRegion(int row1, int col1, int row2, int col2) {
    int sum=0;
    sum=mat[row2][col2];
    if(row1-1>=0)
    {
      sum-=mat[row1-1][col2];
    }
    if(col1-1>=0)
    {
      sum-=mat[row2][col1-1];
    }
    if(row1-1>=0 && col1-1>=0)
    {
      sum+=mat[row1-1][col1-1];
    }
    //  cout<<endl;
    return sum;
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Please enter number of matrix rows : ");
    int row = sc.nextInt();
    System.out.println("Please enter number of matrix columns : ");
    int col = sc.nextInt();
    // defining two dimensional array java
    int[][] numbers = new int[row][col];
    // filling java matrix
    fillingMatrix(sc, numbers, row, col);
    // printing 2d array in matrix form in java
    printingMatrix(numbers, row, col);
    mat=numbers;
    fun();
    int numberOfQueries = sc.nextInt();

    while(numberOfQueries>0)
    {
      int row1 = sc.nextInt();
      int col1 = sc.nextInt();
      int row2 = sc.nextInt();
      int col2 = sc.nextInt();
      int ans=sumRegion(row1,col1,row2,col2);
      System.out.println(ans);
      numberOfQueries-=1;
    }

  }
  public static void fillingMatrix(Scanner scan, int num[][], int rows, int columns)
  {
    System.out.println("Please enter elements in matrix : ");
    for(int a = 0; a < rows; a++)
    {
      for(int b = 0; b < columns; b++)
      {
        num[a][b] = scan.nextInt();
      }
    }
  }
  public static void printingMatrix(int num[][], int rows, int columns)
  {
    System.out.println("Printing matrix : ");
    for(int a = 0; a < rows; a++)
    {
      for(int b = 0; b < columns; b++)
      {
        System.out.print(num[a][b] + "\t");
      }
      System.out.println();
    }
  }

}
