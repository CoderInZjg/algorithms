package com.viva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//For a given 3 digit number, find whether it is armstrong number or not. An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371
//
//Input:
//First line contains an integer, the number of test cases 'T' Each test case should contain a positive integer N.
//
//
//Output:
//Print "Yes" if it is a armstrong number else print "No".
//
//
//Constraints:
//1<=T<=31
//100<= N <1000
//
//
//Example:
//Input:
//1
//371
//
//Output:
//Yes



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
		
		ArmStrongNumber asn = new ArmStrongNumber();
		System.out.println(Arrays.toString(asn.armStrongNumber()));
	}

}
