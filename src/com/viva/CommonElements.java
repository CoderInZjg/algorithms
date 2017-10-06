package com.viva;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
