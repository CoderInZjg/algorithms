package com.viva;

import java.util.Arrays;
import java.util.Random;

//Given an array and a number k where k is smaller than size of array, the task is to find the k¡¯th smallest element in the given array. It is given that all array elements are distinct.
//
//Input:
//
//First Line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.
//
//Output:
//
//Corresponding to each test case, print the desired output in a new line.
//
//Constraints:
//
//1<=T<=200
//1<=N<=1000
//K
//
//Expected Time Complexity: O(n)
//
//Example:
//
//INPUT
//2
//6
//7 10 4 3 20 15
//3
//5
//7 10 4 20 15
//4
//
//Output:
//
//7
//15

public class KthSmallestElement {
	
	public int KthSmalestValue(int[] eles,int k){
		int length = eles.length;
		
		if(k>length){
			throw new IllegalArgumentException("k is bigger than the length of array");
		}
		if(k>length/2){
			for(int i=0;i<(length-k)+1;i++){
				int maxIndex = 0,j=1;
				
				for(;j<length-i;j++){
					if(eles[j]>eles[maxIndex]){
						maxIndex = j;
					}
				}
				int tem = eles[maxIndex];
				eles[maxIndex] = eles[j-1];
				eles[j-1] = tem;
			}
			System.out.println(Arrays.toString(eles));
			return eles[k-1];
		}else{
			for(int i=0;i<k;i++){
				int minIndex = 0,j=1;
				for(;j<length-i;j++){
					if(eles[j]<eles[minIndex]){
						minIndex = j;
					}
				}
				int tem = eles[minIndex];
				eles[minIndex] = eles[j-1];
				eles[j-1] = tem;
			}
			System.out.println(Arrays.toString(eles));
			return eles[length-k];
		}
		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		Random rd = new Random();
		for(int i=0;i<arr.length;i++){
			arr[i] = rd.nextInt(1000);
		}
		
		KthSmallestElement kse = new KthSmallestElement();
		System.out.println(kse.KthSmalestValue(arr, 2));
		System.out.println(kse.KthSmalestValue(arr, 8));
		System.out.println(kse.KthSmalestValue(arr, 11));
	}

}
