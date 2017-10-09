package com.viva;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
//
//Input:
//
//The first line of input contains an integer T denoting the number of test cases.
//The first line of each test case is r and c,r is the number of rows and c is the number of columns.
//The second line of each test case contains all the elements of the matrix in a single line separated by a single space.
//
//Output:
//
//Print the modified array.
//
//Constraints:
//
//1 ¡Ü T ¡Ü 50
//1 ¡Ü r,c ¡Ü 20
//0 ¡Ü Elements of matrix ¡Ü 1
//
//Example:
//
//Input:
//3
//2 2
//1 0 0 0
//2 3
//0 0 0 0 0 1
//3 4
//1 0 0 1 0 0 1 0 0 0 0 0
//
//Output:
//1 1 1 0
//0 0 1 1 1 1
//1 1 1 1 1 1 1 1 1 0 1 1
public class BooleanMatrix {
	
	public int[] booleanMatrix(int[] arr,int row,int col){
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				int index = i*col+j;
				
				if(arr[index]==1){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				int index = i*col+j;
				if(rows.contains(i)||cols.contains(j)){
					arr[index] = 1;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0};
		int row = 3, col =4;
		BooleanMatrix bm = new BooleanMatrix();
		System.out.println(Arrays.toString(bm.booleanMatrix(arr, row, col)));
	}

}
