package com.viva;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
