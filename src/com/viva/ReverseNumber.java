package com.viva;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumber {
	
	public void reverseNumber(){
		Scanner sc = new Scanner(System.in);
		String input;
		for(;;){
			System.out.println("Please enter a number");
			input = sc.nextLine();
			if(input.matches("^[0-9]+$")){
				for(int length = input.length(),i=length-1;i>-1;i--){
					System.out.print(input.charAt(i));
				}
				System.out.println();
			}else if(input.equalsIgnoreCase("x")){
				System.exit(0);
			}else{
				System.out.println("Invalid number, please enter again");
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "123";
		StringBuilder sb = new StringBuilder("2343");
		System.out.println(sb.reverse().toString());
		String[] ss = new String[7];
		Arrays.asList(ss).stream().collect(Collectors.joining(""));
		new ReverseNumber().reverseNumber();
	}

}
