package algorithm.sorting.quicksort;

public class Main {
	public static void main(String[] args){
		int[] arr = {12, 34,999,32,3,45,555,333,1,6,212};
		QuickSort qSort = new QuickSort();
		/*int position = qSort.partitionIt(arr, 0,arr.length-1);
		System.out.println("position: "+position);*/
		qSort.sort(arr);
		for(int i:arr){
			System.out.print("\t"+i);
		}
	}
}
