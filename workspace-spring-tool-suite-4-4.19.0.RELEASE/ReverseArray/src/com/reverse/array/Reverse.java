package com.reverse.array;
import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		//taking the size from the user input
		
		System.out.println("Enter the size of the array: ");
		int size=scan.nextInt();
		
		
		//initiating the array
		int[] element=new int[size];
		
		//Taking an element into the array from the user
		System.out.println("Enter the element into the array: ");
		
		for(int i=0;i<size;i++) {
			
			element[i]=scan.nextInt();
		}
		
		// Printing the array in reverse order
        System.out.println("Array in reverse order:");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(element[i] + "\n");
        }

	}

}
