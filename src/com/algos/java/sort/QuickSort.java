package com.algos.java.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array ={9,8,7,6,5,4,3,2,1};
		doQuickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	static void doQuickSort(int[] array,int start,int end){
		if(start<end){
		int pIndex= doPartition(array, start, end);
		doQuickSort(array, start, pIndex-1);
		doQuickSort(array, pIndex+1, end);
		}
	}
	static int doPartition(int[] array,int start,int end){
		
		int pivot= array[end];
		int pIndex=start;
		for(int i=start;i<=end-1;i++){
			if(array[i]<=pivot){
				int temp=array[i];
				array[i]=array[pIndex];
				array[pIndex]=temp;
				pIndex++;
			}
		}
		
		int temp=array[pIndex];
		array[pIndex]=array[end];
		array[end]=temp;
		return pIndex;
	}
	
	

}
