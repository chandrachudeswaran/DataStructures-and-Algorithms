package com.algos.java.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		 	int[] array= {9,8,7,6,5,4,3,2,1};
		 	
		 	for(int i=1;i<array.length;i++){
		 		
		 		int index= array[i];
		 		int j=i;
		 		
		 		while(j>0&& array[j-1]>index){
		 			array[j]=array[j-1];
		 			j--;
		 		}
		 		array[j]=index;
		 	}
		 	
		 System.out.println(Arrays.toString(array));

	}

}
