package com.viva;

import java.util.Arrays;
import java.util.Random;

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
