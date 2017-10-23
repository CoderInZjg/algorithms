package com.viva.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort {
	public void heapSort(int[] arr){
		
	}
	
	public void heapify(int[] heap, int size, int index){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> li = new ArrayList<>();
		for(int i=1;i<8;i++){
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<i;j++){
				sb.append("a");
			}
			li.add(sb.toString());
		}
		li.sort((String a,String b)->{
			
			return b.length()-a.length();
		});
		System.out.println(li.toString());
	}

}
