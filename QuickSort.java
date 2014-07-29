/*
 * Algorithm sorting
 * 
 * Author: Xin He (xh2176@columbia.edu)
 */
public class QuickSort {
	public static void quickSort(int[] nums){
		if(nums==null||nums.length<2) return;
		quickSort(nums, 0, nums.length-1);
	}
	
	public static void quickSort(int[] nums, int s, int e){
		if(s>=e) return;
		int r=partition(nums, s, e);
		quickSort(nums, s, r-1);
		quickSort(nums, r+1, e);
	}
	
	public static int partition(int[] nums, int s, int e){
		int pivot=nums[e];
		int end=e-1;
		for(;s<=end; s++){
			if(nums[s]>pivot){
				int temp=nums[end];
				nums[end]=nums[s];
				nums[s]=temp;
				s--;
				end--;
			}
		}
		//after for loop, s=end+1, otherwise the loop will continue
		nums[e]=nums[s];
		nums[s]=pivot;
		return s;
	}
	public static void print(int[] array){
		for(int i:array)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] array1={};
		int[] array2={1};
		int[] array3={1, 2, 3, 4};
		int[] array4={4, 3, 2, 1};
		int[] array5={1, 4, 2, 3};
		int[] array6={1, 1, 1, 1};
		
		quickSort(array1);
		quickSort(array2);
		quickSort(array3);
		quickSort(array4);
		quickSort(array5);
		quickSort(array6);
		
		print(array1);
		print(array2);
		print(array3);
		print(array4);
		print(array5);
		print(array6);
	}
}
