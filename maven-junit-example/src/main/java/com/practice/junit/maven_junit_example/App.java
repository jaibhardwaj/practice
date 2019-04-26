package com.practice.junit.maven_junit_example;

/**
 * Hello world!
 *
 */
public class App 
{
	public static int findMax(int arr[]){  
        int max=0;  
        for(int i=1;i<arr.length;i++){  
            if(max<arr[i])  
                max=arr[i];  
        }  
        return max;  
    }
	
	public static int findMin(int arr[]){  
        int min=0;  
        for(int i=1;i<arr.length;i++){  
            if(min>arr[i])  
            	min=arr[i];  
        }  
        return min;  
    }
	
	public static void throwExcep() {
		throw new MyOwnException("My Exception!!");
	}
	
	public static void timeOutExc() {
		for (int i = 0; i < 100000; i++) {
			//System.out.println(i);
		}
	}
}
