package com.viva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArmStrongNumber {
	
	public int[] armStrongNumber(){
		List<Integer> res = new ArrayList<>();
		int[] pows = new int[10];
		for(int i=0;i<pows.length;i++){
			pows[i] = (int)Math.pow(i, 3);
		}
		for(int i=1;i<10;i++){
			for(int j=0;j<10;j++){
				if(pows[i]+pows[j]>999){
					break;
				}
				for(int k=0;k<10;k++){
					int number = i*100+j*10+k;
					if(pows[i]+pows[j]+pows[k]==number){
						res.add(number);
					}
				}
			}
		}
		return res.stream().mapToInt(i->i).toArray();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// commit file
		ArmStrongNumber asn = new ArmStrongNumber();
		System.out.println(Arrays.toString(asn.armStrongNumber()));
	}

}
