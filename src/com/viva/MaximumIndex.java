package com.viva;

//Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
//
//Example :
//
//A : [3 5 4 2]
//
//Output : 2 
//for the pair (3, 4)
//
// 
//
//Input:
//
//The first line contains an integer T, depicting total number of test cases. 
//Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.
//
//
//Output:
//
//Print the maximum difference of the indexes i and j in a separtate line.
//
//
//Constraints:
//
//1 ¡Ü T ¡Ü 100
//1 ¡Ü N ¡Ü 1000
//0 ¡Ü A[i] ¡Ü 100
//
//
//Example:
//
//Input
//1
//2
//1 10
//Output
//1

public class MaximumIndex {
	
	public int maxIndexDiff(int[] arr){
		int currentMax = 1;
		for(int i=1,max=arr.length;i<max;i++){
			for(int j=0,lim=arr.length-i;j<lim;j++){
				if(arr[j]<=arr[j+i]){
					currentMax = i;
					break;
				}
			}
		}
		return currentMax;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,4,2}; 
		System.out.println(new MaximumIndex().maxIndexDiff(arr));
	}

}
