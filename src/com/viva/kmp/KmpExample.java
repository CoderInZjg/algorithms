package com.viva.kmp;

import java.util.Arrays;
import java.util.Random;

public class KmpExample {
	
	public int[] generatePreTable(String searched){
		char[] searchChar = searched.toCharArray();
		int length = searchChar.length;
		int[] table = new int[length];
		int pos = 1;
		int cnd = 0;
		table[0] = -1;
		while(pos<length){
			if(searchChar[pos]==searchChar[cnd]){
				table[pos] = table[cnd];
				pos++;
				cnd++;
			}else{
				table[pos] = cnd;
				cnd = table[cnd];
				while(cnd>=0&&searchChar[pos]!=searchChar[cnd]){
					cnd = table[cnd];
				}
				
				pos++;
				cnd++;
			}
		}
		
		//table[pos] = cnd;
		
		
		return table;
	}
	
	public int kmpSearch(String source,String target){
		
		int[] table = generatePreTable(target);
		char[] sourceChar = source.toCharArray();
		char[] targetChar = target.toCharArray();
		int sourceIndex = 0;
		int targetIndex = 0;
		int sourceLength = source.length();
		while(sourceIndex+targetIndex<sourceLength){
			if(targetChar[targetIndex]==sourceChar[sourceIndex+targetIndex]){
				targetIndex ++;
				if(targetIndex == target.length()){
					return sourceIndex;
				}
			}else{
				if(table[targetIndex]>-1){
					sourceIndex = sourceIndex + targetIndex - table[targetIndex];
					targetIndex = table[targetIndex];
				}else{
					sourceIndex = sourceIndex + targetIndex + 1;
					targetIndex = 0;
				}
			}
		}
		return sourceIndex;
	}
	
	public String generateStringOfLength(int length){
		char[] target = new char[length];
		Random ra = new Random();
		for(int i=0;i<length;i++){
			target[i] = (char)ra.nextInt(256);
			
		}
		
		return new String(target);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KmpExample ke = new KmpExample();
		//System.out.println(ke.kmpSearch("ABC ABCDAB ABCDABCDABDE", "ABCDABD"));
		String source = ke.generateStringOfLength(1000000);
		String target = ke.generateStringOfLength(100);

		System.out.println(System.currentTimeMillis());
		System.out.println(ke.kmpSearch(source, target));
		System.out.println(System.currentTimeMillis());
		
//		System.out.println(Arrays.toString(ke.generatePreTable("ABCDABD")));
//		System.out.println(Arrays.toString(ke.generatePreTable("ABACABABC")));
	}

}
