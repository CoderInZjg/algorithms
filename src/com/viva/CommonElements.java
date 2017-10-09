package com.viva;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
//
//Input:
//First line consists of T test cases. First line of every test case consists of 3 integers N1, N2 and N3, denoting the number of elements of 3 arrays. Second, Third and Forth line of every test case conisists of elements of array1, array2 and array3 respectively.
//
//Output:
//Single line output, Print the common elements of array. If not possible then print -1.
//
//Constraints:
//1<=T<=100
//1<=N1,N2,N3<=1000
//1<=Ai,Bi,Ci<=1000
//
//Example:
//Input:
//1
//6 5 8
//1 5 10 20 40 80
//6 7 20 80 100
//3 4 15 20 30 70 80 120
//Output:
//20 80
public class CommonElements {

	public List<String> commonElements(String[]... strings) {

		List<String> ls = new ArrayList<>();
		List<String> res = new ArrayList<>();
		for (String[] arr : strings) {
			Set<String> s = new HashSet<>();
			for (String i : arr) {
				s.add(i);
			}
			ls.addAll(s);
		}
		ls.sort(null);
		int count = 1;
		for (int i = 1, length = ls.size(); i < length; i++) {

			if (ls.get(i).equals(ls.get(i - 1))) {
				count++;
				if (count == 3) {
					res.add(ls.get(i));
					count = 1;
				} 
			}else{
				count = 1;
			}

		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s1 = { "1", "2", "3", "3" };
		String[] s2 = { "1", "7", "5", "3" };
		String[] s3 = { "5",  "2", "5", "7" };
		CommonElements ce = new CommonElements();
		System.out.println(ce.commonElements(s1, s2, s3));
	}

}
