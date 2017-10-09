package com.viva;

import java.util.Arrays;

//Given a sorted array. Write a program that creates a Balanced Binary Search Tree using array elements. If there are n elements in array, then floor(n/2)'th element should be chosen as root and same should be followed recursively.
//
//Input:
//
//The first line of input contains an integer T denoting the number of test cases.
//The first line of each test case is N,N is the size of array.
//The second line of each test case contains N input A[].
//
//Output:
//
//Print the preorder traversal of constructed BST.
//
//Constraints:
//
//1 ¡Ü T ¡Ü 100
//1 ¡Ü N ¡Ü 1000
//1 ¡Ü A[] ¡Ü 10000
//
//Example:
//
//Input:
//1
//7
//7 6 5 4 3 2 1
//
//Output:
//4 6 7 5 2 3 1
public class ArrayToBST {
	
	
	public int[] arrayToBST(int[] arr,int start,int end){
		int amount = end - start + 1, root = start+amount/2;
		if(amount<3){
			return arr;
		}
		int tem = arr[root];
		for(int i=root-1;i>=start;i--){
			arr[i+1]=arr[i];
		}
		arr[start] = tem;
		arr=arrayToBST(arr,start+1,root);
		arr=arrayToBST(arr,root+1,end);
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[15];
		
		for(int i=0,len = arr.length;i<len;i++){
			arr[i] = len-i;
		}
		System.out.println(Arrays.toString(arr));
		ArrayToBST atb = new ArrayToBST();
		
		System.out.println(Arrays.toString(atb.arrayToBST(arr, 0, arr.length-1)));
	}

}
