package com.viva;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;



//Given an infix expression. Conver the infix expression to postfix expression.
//
//Infix expression:The expression of the form a op b. When an operator is in-between every pair of operands.
//
//Postfix expression:The expression of the form a b op. When an operator is followed for every pair of operands.
//
//Input:
//
//The first line of input contains an integer T denoting the number of test cases.
//The next T lines contains an infix expression.The expression contains all characters and ^,*,/,+,-.
//
//Output:
//Output the infix expression to postfix expression.
//
//Constraints:
//1<=T<=100
//1<=length of expression<=30
//
//Example:
//Input:
//2
//a+b*(c^d-e)^(f+g*h)-i
//A*(B+C)/D
//
//Output:
//abcd^e-fgh*+^*+i-
//ABC+*D/


public class InfixChange {
	private static final int GREATERTHAN = 1;
	private static final int SMALLERTHAN = 0;
	private static final int EQUAL = -1;
	public String infixToPostFix(String infix){
		Stack<Character> operators = new Stack<>();
		Stack<Character> items = new Stack<>();
		if(infix == null || infix.length() == 0){
			throw new IllegalArgumentException("notation can not be null");
		}
		for(int i=0,length = infix.length();i<length;i++){
			char current = infix.charAt(i);
			if(isOperator(Character.toString(current))){
				while(!operators.isEmpty()&&
					  operators.peek()!='('&&
					  compareOperator(Character.toString(current), Character.toString(operators.peek()))<GREATERTHAN){
					items.push(operators.pop());
				}
				
				operators.push(current);
			}else if(current=='('){
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
		Stack<Character> operators = new Stack<>();
		Stack<Character> items = new Stack<>();
		if(infix == null || infix.length() == 0){
			throw new IllegalArgumentException("notation can not be null");
		}
		for(int length = infix.length(),i=length-1;i>-1;i--){
			char current = infix.charAt(i);
			if(isOperator(Character.toString(current))){
				while(!operators.isEmpty()&&
					  operators.peek()!=')'&&
					  compareOperator(Character.toString(current), Character.toString(operators.peek()))<EQUAL){
					items.push(operators.pop());
				}
				
				operators.push(current);
			}else if(current==')'){
				operators.push(current);
			}else if(current=='('){
				while(operators.peek() != ')'){
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
		Collections.reverse(items);
		String res = items.stream()
						  .map(Object::toString)
						  .collect(Collectors.joining(""))
						  .toString();
		
		return res;
		
	}
	
	public boolean isOperator(String op){
		return op.matches("^[-+^*/]{1,1}$");
	}
	
	public int compareOperator(String op1,String op2){
		int op1Priority=0,op2Priority=0;
		if(op1.matches("^[-+]{1,1}$")){
			op1Priority = 1;
		}else if(op1.matches("^[*/]{1,1}$")){
			op1Priority = 2;
		}else if(op1.equals("^")){
			op1Priority = 3;
		}
		
		if(op2.matches("^[-+]{1,1}$")){
			op2Priority = 1;
		}else if(op2.matches("^[*/]{1,1}$")){
			op2Priority = 2;
		}else if(op2.equals("^")){
			op2Priority = 3;
		}
		if(op1Priority>op2Priority){
			return GREATERTHAN;
		}else if(op1Priority == op2Priority){
			return EQUAL;
		}else{
			return SMALLERTHAN;
		}
		
	}
	
	public static void main(String[] args) {
		
		String expression = "1+((2+3)*4)-5";
		
		InfixChange ic = new InfixChange();
		System.out.println("post expression:"+ic.infixToPostFix(expression));
		System.out.println("pre expression:"+ic.infixToPreFix(expression));
		
	}
	
}
