package com.algos.java.util;

public class BinarySearch {

	public static void main(String[] args) {
	
		int[] array={1,2,3,4,5,6,7,8,9};
		System.out.println(doBinarySearch(array, 6,0,array.length-1));
	}
	
	static int doBinarySearch(int[] array,int element,int start,int end){
	
		
		int mid = (start+end)/2;
		if(mid<0){
			return -1;
		}
		
		if(array[mid]==element){
			return mid;
			
		}
		if(element<array[mid]){
			return doBinarySearch(array, element,start,mid-1);
			
		}
		else{
			return doBinarySearch(array, element,mid+1,end);
			
		}
		
		
	
		
	}

}
