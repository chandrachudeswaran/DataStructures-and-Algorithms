package com.algos.java.sort;

import java.util.Arrays;

public class HeapSort {
	int heapSize;

	public static void main(String[] args) {
		
			int array[] ={16,4,10,14,7,9,3,2,8,1};
			HeapSort sort = new HeapSort();
		
			
			sort.buildMaxHeap(array);
			sort.doHeapSort(array);
			System.out.println(Arrays.toString(array));
	}
	
	void doHeapifyMax(int[] array,int position){
		
		int left = getLeft(position);
		int right = getRight(position);
		int largest=position;
	
		if(left <=heapSize-1 && array[left]>array[position]){
			largest=left;
		}else{
			largest=position;
		}
		if(right<=heapSize-1 && array[right]>array[largest]){
			largest=right;
		}
		if(largest!=position){
			int temp=array[position];
			array[position]=array[largest];
			array[largest]=temp;
			doHeapifyMax(array, largest);
		}
		
	}
	
	 void buildMaxHeap(int[] array){
		 heapSize= array.length;
		for(int i=(array.length/2)-1;i>=0;i--){
			doHeapifyMax(array, i);
		}
	}
	
	 void doHeapSort(int[] array){
		
		for(int i=array.length-1;i>0;i--){
			int temp=array[0];
			array[0]=array[i];
			array[i]=temp;
			
			heapSize = heapSize-1;
			
			doHeapifyMax(array, 0);
		}
	}
	
	 int getLeft(int pos){
		return 2*pos +1;
	}
	 int getRight(int pos){
		return 2*pos +2;
	}
	
	

}
