package com.algos.java.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		doMergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	static void doMergeSort(int[] array) {

		int length= array.length;
		if(length<2){
			return;
		}else{
			int center = length/2;
			int[] left= new int[center];
			for(int i=0;i<center;i++){
				left[i]=array[i];
			}
			int[] right= new int[length-center];
			for(int j=center;j<=length-1;j++){
				right[j-center]=array[j];
			}
			
			doMergeSort(left);
			doMergeSort(right);
			doMerge(left, right, array);
		}
	}

	static void doMerge(int[] left, int[] right, int[] array) {

		int left_size = left.length;
		int right_size = right.length;

		int i = 0, j = 0, k = 0;
		while (i <= left_size - 1 && j <= right_size - 1) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}

		while (i <= left_size - 1) {
			array[k] = left[i];
			k++;
			i++;
		}
		while (j <= right_size - 1) {
			array[k] = right[j];
			k++;
			j++;
		}
	}

}
