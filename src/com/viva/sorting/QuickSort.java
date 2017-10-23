package com.viva.sorting;

import java.util.Arrays;

public class QuickSort {
	
	public int[] quickSort(int[] arr, int from, int to){
//		if(from == to){
//			return;
//		}
		if(to<=from){
			return arr;
		}
		int flag = sortSubArr(arr,from,to);
		
		quickSort(arr,from,flag-1);
		quickSort(arr,flag+1,to);
		return arr;
	}
	
	public int sortSubArr(int[] sub, int start, int end){
		int flag = sub[end];
		int currentIndex = end;
		while(start<end){
			if(currentIndex == end){
				if(sub[start]<=flag){
					start ++;
				}else{
					int tem = sub[start];
					sub[start] = sub[currentIndex];
					sub[currentIndex] = tem;
					currentIndex = start;
				}
			}else if(currentIndex == start){
				if(sub[end]>=flag){
					end --;
				}else{
					int tem = sub[end];
					sub[end] = sub[currentIndex];
					sub[currentIndex] = tem;
					currentIndex = end;
				}
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8,1,5,1,9,2,7};
		int[] t1 = {2,1};
		int[] t2 = {9,8,7,6,5,4,3,2,1};
		
		QuickSort qs = new QuickSort();
		System.out.println(Arrays.toString(qs.quickSort(arr, 0, arr.length-1)));
		System.out.println(Arrays.toString(qs.quickSort(t1,0,t1.length-1)));
		System.out.println(Arrays.toString(qs.quickSort(t2,0,t2.length-1)));
	}

}
