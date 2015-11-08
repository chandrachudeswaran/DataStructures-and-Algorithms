package com.algos.java.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array={9,8,7,6,5,4,3,2,1};
		doBubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	static void doBubbleSort(int[] array){
		
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<=array.length-2-i;j++){
				if(array[j]> array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
	}

}
