package com.study;
import java.util.*;

public class Test1 {
	public static void main(String[] args) {
		try
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Numerator:");
		int a=sc.nextInt();
		System.out.println("Enter the Denominator:");
		int b=sc.nextInt();
		int q=a/b;
		System.out.println("Answer");
		System.out.println(q);
		}
		catch(ArithmeticException ae) {
			System.out.println("Enter non zero value");
		}
		catch(InputMismatchException ime) {
			System.out.println("Enter a numeric value");
		}
		finally {
			System.out.println("Finally block executed");
		}
		}
	

}
