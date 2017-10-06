package com.viva;

import java.util.Arrays;

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
