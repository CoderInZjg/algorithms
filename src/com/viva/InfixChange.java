package com.viva;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class InfixChange {
	public String infixToPostFix(String infix){
		Stack<Character> operators = new Stack<>();
		Stack<Character> items = new Stack<>();
		if(infix == null || infix.length() == 0){
			throw new IllegalArgumentException("notation can not be null");
		}
		for(int i=0,length = infix.length();i<length;i++){
			char current = infix.charAt(i);
			if(isOperator(Character.toString(current)) || current=='('){
				operators.push(current);
			}else if(current==')'){
				while(operators.peek() != '('){
					items.push(operators.pop());
				}
				operators.pop();
				
			}else{
				items.push(current);
			}
		}
		while(!operators.isEmpty()){
			items.push(operators.pop());
		}
		String res = items.stream()
						  .map(Object::toString)
						  .collect(Collectors.joining(""))
						  .toString();
	
		return res;
	}
	
	public String infixToPreFix(String infix){
		return infix;
	}
	
	public boolean isOperator(String op){
		return op.matches("^[-+^*/]{1,1}$");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InfixChange ic = new InfixChange();
		
		while(true){
			String input = sc.nextLine();
			System.out.println(ic.infixToPostFix(input));
		}
	}
	
}
